package com.yy.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yy.user.config.mybatis.handler.special.JsonbTypeHandler;
import com.yy.user.dto.UserInfoDTO;
import lombok.Data;

/**
 * 
 * @TableName test_jsonb
 */
@TableName(value ="test_jsonb",autoResultMap = true)
@Data
public class TestJsonb {
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