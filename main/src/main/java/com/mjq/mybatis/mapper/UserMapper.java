package com.mjq.mybatis.mapper;

import com.mjq.mybatis.model.User;
import com.mjq.mybatis.provider.UserProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author majingqiang
 * @since 2018-11-10
 */
@Mapper
public interface UserMapper {

    String baseColumn = "`id`, `user_name`, `password`, `birthday`, `create_time`, `update_time`,`update_time` ";

    @InsertProvider(type = UserProvider.class, method = "insert" )
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "user.id" )
    int insert(@Param("user" ) User user);

    @UpdateProvider(type = UserProvider.class, method = "updateByPrimaryKey" )
    int updateByPrimaryKey(@Param("user" ) User user);

    @DeleteProvider(type = UserProvider.class, method = "delete" )
    int delete(@Param("user" ) User user);

    @SelectProvider(type = UserProvider.class, method = "selectByUser" )
    List<User> selectByUser(@Param("user" ) User user);

    @SelectProvider(type = UserProvider.class, method = "selectOne" )
    User selectOne(@Param("user" ) User user);

    @Select("SELECT " + baseColumn + " FROM user WHERE `id` = #{id}" )
    User selectByPrimaryKey(@Param("id" ) Long id);

}
