package com.mjq.webflux.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by majingqiang on 2018/11/15.
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
