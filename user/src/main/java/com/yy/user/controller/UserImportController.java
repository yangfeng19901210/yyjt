package com.yy.user.controller;

import com.alibaba.excel.EasyExcel;
import com.yy.user.dto.UserImportDTO;
import com.yy.user.listener.UserImportListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserImportController {
    @Autowired
    private Validator validator;

    @PostMapping("/import")
    public ResponseEntity<?> importUsers(@RequestParam("file") MultipartFile file) {
        try (InputStream in = file.getInputStream()) {
            UserImportListener listener = new UserImportListener(validator);
            
            EasyExcel.read(in, UserImportDTO.class, listener)
                .sheet()
                .headRowNumber(1)  // 跳过表头
                .doRead();

            if (!listener.getErrorMessages().isEmpty()) {
                return ResponseEntity.badRequest().body(
                        Map.of("code",400, "msg","部分数据导入失败", "errors",listener.getErrorMessages())

                );

            }
            return ResponseEntity.ok(Map.of("code",200, "msg","导入成功"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(
                Map.of("code",500, "msg","系统错误: " + e.getMessage())
            );
        }
    }
    @GetMapping("/template")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment;filename=user_template.xlsx");
        EasyExcel.write(response.getOutputStream(), UserImportDTO.class)
                .sheet("用户模板")
                .doWrite(Collections.emptyList());
    }
}