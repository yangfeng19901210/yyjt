package com.yy.user.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.yy.user.dto.UserImportDTO;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Slf4j
public class UserImportListener extends AnalysisEventListener<UserImportDTO> {
    private static final int BATCH_SIZE = 1000;
    private List<UserImportDTO> cachedData = new ArrayList<>(BATCH_SIZE);
    private final List<String> errorMessages = new ArrayList<>();
    private final Validator validator;

    public UserImportListener(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void invoke(UserImportDTO data, AnalysisContext context) {
        // 数据校验
        Set<ConstraintViolation<UserImportDTO>> violations = validator.validate(data);
        if (!violations.isEmpty()) {
            int rowNum = context.readRowHolder().getRowIndex() + 1;
            errorMessages.add("第 " + rowNum + " 行错误: " + 
                violations.stream().map(v -> v.getMessage()).collect(Collectors.joining(";")));
            return;
        }
        
        cachedData.add(data);
        if (cachedData.size() >= BATCH_SIZE) {
            saveBatch();
            cachedData.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if (!cachedData.isEmpty()) saveBatch();
    }

    private void saveBatch() {
        // 批量插入数据库（示例使用 MyBatis Plus）
        log.info("获取到的用户数据为{}", cachedData);

    }

    // 获取错误信息（供Controller返回）
    public List<String> getErrorMessages() {
        return errorMessages;
    }
}