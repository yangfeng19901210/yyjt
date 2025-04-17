package com.yy.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yy.user.config.mybatis.JsonbTypeHandler;
import com.yy.user.dto.UserInfoDTO;
import lombok.Data;

/**
 * 
 * @TableName test_user
 */
@TableName(value ="test_user",autoResultMap = true)
@Data
public class TestUser {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String uuid;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户信息
     */
    @TableField(typeHandler = JsonbTypeHandler.class)
    private UserInfoDTO userInfo;
}