package com.yy.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.yy.user.config.mybatis.handler.special.JsonbTypeHandler;
import com.yy.user.dto.UserInfoDTO;
import lombok.Data;

import java.time.LocalDateTime;

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

    /**
     * 创建时间
     */
    @OrderBy
    private LocalDateTime crtTime;

    /**
     * 更新时间
     */
    private LocalDateTime uptTime;


    /**
     * 数据状态：null删除，1正常。（使用null是为了再逻辑删除情况下保证唯一索引的正常使用）
     */
    @TableLogic(value = "1", delval = "NULL")
    private Integer delFlag;
}