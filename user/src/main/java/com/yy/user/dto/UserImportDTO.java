package com.yy.user.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserImportDTO {
    @ExcelProperty("姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @ExcelProperty("手机号")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式错误")
    private String phone;
}