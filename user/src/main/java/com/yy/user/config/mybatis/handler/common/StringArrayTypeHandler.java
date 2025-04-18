package com.yy.user.config.mybatis.handler.common;

import io.gitee.loulan_yxq.owner.core.collection.ArrayTool;
import io.gitee.loulan_yxq.owner.core.stream.CollectorTool;
import io.gitee.loulan_yxq.owner.core.tool.StrTool;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*********************************************************
 ** mybatis-plus字符串数组的类型处理器
 ** <br><br>
 ** Date: Created in 2022/10/25 14:16
 ** @author loulan
 ** @version 0.0.0
 *********************************************************/
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(String[].class)
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
        if (ArrayTool.isNotEmpty(parameter)) {
            ps.setString(i,ArrayTool.stream(parameter).collect(CollectorTool.toStr(",")));
        }
    }

    @Override
    public String[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String str = rs.getString(columnName);
        if (StrTool.isNotEmpty(str)) {
            String[] datas = str.split(",");
            return datas;
        } else {
            return null;
        }
    }

    @Override
    public String[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = rs.getString(columnIndex);
        if (StrTool.isNotEmpty(str)) {
            String[] datas = str.split(",");
            return datas;
        } else {
            return null;
        }
    }

    @Override
    public String[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String str = cs.getString(columnIndex);
        if (StrTool.isNotEmpty(str)) {
            String[] datas = str.split(",");
            return datas;
        } else {
            return null;
        }
    }
}
