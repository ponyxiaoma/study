package com.mjq.mybatis.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author majingqiang
 * @since 2018-11-10
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 生日
     */
    private Date birthday;

    private Date createTime;

    private Date updateTime;


}
