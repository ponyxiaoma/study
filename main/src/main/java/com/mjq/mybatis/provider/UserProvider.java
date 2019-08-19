package com.mjq.mybatis.provider;

import com.mjq.mybatis.mapper.UserMapper;
import com.mjq.mybatis.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;
import java.util.List;


/**
 * @author majingqiang
 * @since 2018-11-10
 */
public class UserProvider {

    private static final String baseColumn = UserMapper.baseColumn;

    private void where(SQL sql, User user) {
        if (user.getId() != null) {
            sql.WHERE("`id` = #{user.id}" );
        }
        if (user.getUserName() != null) {
            sql.WHERE("`user_name` = #{user.userName}" );
        }
        if (user.getPassword() != null) {
            sql.WHERE("`password` = #{user.password}" );
        }
        if (user.getBirthday() != null) {
            sql.WHERE("`birthday` = #{user.birthday}" );
        }
        if (user.getCreateTime() != null) {
            sql.WHERE("`create_time` = #{user.createTime}" );
        }
        if (user.getUpdateTime() != null) {
            sql.WHERE("`update_time` = #{user.updateTime}" );
        }
    }

    //动态保存
    public String insert(@Param("user" ) User user) {
        return new SQL() {{
            List<String> columnList = new ArrayList<>();
            List<String> valueList = new ArrayList<>();
            if (user.getUserName() != null) {
                columnList.add("`user_name`" );
                valueList.add("#{user.userName}" );
            }
            if (user.getPassword() != null) {
                columnList.add("`password`" );
                valueList.add("#{user.password}" );
            }
            if (user.getBirthday() != null) {
                columnList.add("`birthday`" );
                valueList.add("#{user.birthday}" );
            }
            if (user.getCreateTime() != null) {
                columnList.add("`create_time`" );
                valueList.add("#{user.createTime}" );
            }
            if (user.getUpdateTime() != null) {
                columnList.add("`update_time`" );
                valueList.add("#{user.updateTime}" );
            }
            INSERT_INTO("`user`" );
            INTO_COLUMNS(columnList.stream().toArray(String[]::new));
            INTO_VALUES(valueList.stream().toArray(String[]::new));
        }}.toString();
    }

    //动态修改
    public String updateByPrimaryKey(@Param("user" ) User user) {
        return new SQL() {{
            List<String> setList = new ArrayList<>();
            UPDATE("`user`" );
            if (user.getUserName() != null) {
                setList.add("`user_name` = #{user.userName}" );
            }
            if (user.getPassword() != null) {
                setList.add("`password` = #{user.password}" );
            }
            if (user.getBirthday() != null) {
                setList.add("`birthday` = #{user.birthday}" );
            }
            if (user.getCreateTime() != null) {
                setList.add("`create_time` = #{user.createTime}" );
            }
            if (user.getUpdateTime() != null) {
                setList.add("`update_time` = #{user.updateTime}" );
            }
            SET(setList.stream().toArray(String[]::new));
            WHERE("`id` = #{user.id}" );
        }}.toString();
    }

    //删除
    public String delete(@Param("user" ) User user) {
        return new SQL() {{
            DELETE_FROM("`user`" );
            where(this, user);
        }}.toString();
    }

    public String selectByUser(@Param("user" ) User user) {
        return new SQL() {{
            SELECT(baseColumn);
            FROM("`user`" );
            where(this, user);
        }}.toString();
    }

    public String selectOne(@Param("user" ) User user) {
        return new SQL() {{
            SELECT(baseColumn);
            FROM("`user`" );
            where(this, user);
        }}.toString();
    }

}
