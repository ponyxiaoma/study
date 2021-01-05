package com.mjq.mybatis.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Table(name = "`user`")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
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
    private LocalDateTime birthday;

    /**
     * create_time
     */
    @Column(insertable = false)
    private LocalDateTime createTime;

    /**
     * update_time
     */
    @Column(insertable = false)
    private LocalDateTime updateTime;
}
