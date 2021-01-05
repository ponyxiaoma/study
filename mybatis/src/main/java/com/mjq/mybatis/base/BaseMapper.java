package com.mjq.mybatis.base;

import tk.mybatis.mapper.common.MySqlMapper;

public interface BaseMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>, MySqlMapper<T> {
}
