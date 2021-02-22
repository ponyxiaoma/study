package com.mjq.account.mybatisinterceptor;

import com.mjq.account.annotation.AutoSaveOperator;
import com.mjq.account.base.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 自动插入和修改数据库表中的create和update字段
 */
@Component
@ConditionalOnProperty(prefix = "mjq.mybatis", value = "AutoSaveOperator")
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
@Slf4j
public class InsertAndUpdateInterceptor implements Interceptor {

    private static final String CREATE_TIME_KEY = "createTime";
    private static final String CREATE_BY_KEY = "createBy";
    private static final String UPDATE_TIME_KEY = "updateTime";
    private static final String UPDATE_BY_KEY = "updateBy";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 根据签名指定的args顺序获取具体的实现类
        // 1. 获取MappedStatement实例, 并获取当前SQL命令类型
        MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
        Class mapperClass = Class.forName(ms.getId().substring(0, ms.getId().lastIndexOf(".")));
        Annotation annotation = mapperClass.getDeclaredAnnotation(AutoSaveOperator.class);
        if (annotation != null) {
            AutoSaveOperator autoSaveOperator = (AutoSaveOperator) annotation;
            if (!autoSaveOperator.value()) {
                //当前mapper不需要自动保存，直接返回
                return invocation.proceed();
            }
        }
        SqlCommandType commandType = ms.getSqlCommandType();
        // 2. 获取当前正在被操作的类, 有可能是Java Bean, 也可能是普通的操作对象, 比如普通的参数传递
        // 普通参数, 即是 @Param 包装或者原始 Map 对象, 普通参数会被 Mybatis 包装成 Map 对象
        // 即是 org.apache.ibatis.binding.MapperMethod$ParamMap
        Object parameter = invocation.getArgs()[1];
        // 获取拦截器指定的方法类型, 通常需要拦截 update
        String methodName = invocation.getMethod().getName();
        log.info("NormalPlugin, methodName; {}, commandType: {}", methodName, commandType);
        LocalDateTime now = LocalDateTime.now();
        // 6. 均不是需要被拦截的类型, 不做操作
        if (SqlCommandType.UPDATE.equals(commandType)) {
            log.info("进入修改方法");
            if (parameter instanceof BaseEntity) {
                BaseEntity entity = (BaseEntity) parameter;
                entity.setUpdateBy("admin");
                entity.setUpdateTime(now);
            } else if (parameter instanceof Map) {
                Map<String, Object> map = (Map) parameter;
                if (map.containsKey(UPDATE_BY_KEY)) {
                    map.put(UPDATE_BY_KEY, "admin");
                    map.put(UPDATE_TIME_KEY, now);
                }
            }
        } else if (SqlCommandType.INSERT.equals(commandType)) {
            log.info("进入插入方法");
            if (parameter instanceof BaseEntity) {
                BaseEntity entity = (BaseEntity) parameter;
                entity.setCreateBy("admin");
                entity.setCreateTime(now);
                entity.setUpdateBy("admin");
                entity.setUpdateTime(now);

            } else if (parameter instanceof Map) {
                Map<String, Object> map = (Map) parameter;
                if (map.containsKey("list")) {
                    Object param = map.get("list");
                    if (param instanceof List) {
                        List<Object> insertList = (List<Object>) param;
                        insertList.forEach(p -> {
                            if (p instanceof BaseEntity) {
                                BaseEntity entity = (BaseEntity) p;
                                entity.setCreateBy("admin");
                                entity.setCreateTime(now);
                                entity.setUpdateBy("admin");
                                entity.setUpdateTime(now);
                            }
                        });
                    }
                } else if (map.containsKey(CREATE_BY_KEY)) {
                    map.put(CREATE_BY_KEY, "admin");
                    map.put(UPDATE_BY_KEY, "admin");
                    map.put(UPDATE_TIME_KEY, now);
                    map.put(CREATE_TIME_KEY, now);
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

}
