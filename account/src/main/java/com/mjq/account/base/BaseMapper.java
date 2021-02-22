package com.mjq.account.base;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;
import tk.mybatis.mapper.common.base.select.SelectByPrimaryKeyMapper;

import java.util.List;

@RegisterMapper
public interface BaseMapper<T> extends SelectByPrimaryKeyMapper<T>, BaseUpdateMapper<T>, BaseDeleteMapper<T>, IdsMapper<T> {

    /**
     * 批量插入，支持批量插入的数据库可以使用，支持主键非自增列
     *
     * @param recordList 插入数组
     */
    @Options(useGeneratedKeys = true)
    @InsertProvider(type = BaseInsertProvider.class, method = "insertList")
    int insertList(List<? extends T> recordList);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param record 对象
     */
    @Options(useGeneratedKeys = true)
    @InsertProvider(type = BaseInsertProvider.class, method = "insertSelective")
    int insertSelective(T record);
}
