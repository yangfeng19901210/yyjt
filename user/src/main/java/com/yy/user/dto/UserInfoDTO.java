package com.yy.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: UserInfoDTO
 ** @author: yangfeng
 ** @date: 2025/4/16 16:30
 ** @version: 1.0.0
 *********************************************************/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
    private String name;

    private String phone;

    private String email;
}
