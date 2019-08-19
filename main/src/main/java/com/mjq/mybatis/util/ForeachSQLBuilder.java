package com.mjq.mybatis.util;

import java.text.MessageFormat;

/**
 * @Description:
 * @Author: majingqiang
 * @Date: 2019-03-07 16:34
 */
public class ForeachSQLBuilder {

    public static String buildForeachSql(String values, int length) {
        StringBuilder sb = new StringBuilder();
        MessageFormat mf = new MessageFormat(values);
        for (int i = 0; i < length; i++) {
            sb.append("(");
            sb.append(mf.format(new Object[]{i}));
            sb.append(")");
            if (i < length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
