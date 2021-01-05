package com.mjq.account.base;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseEntity {

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    private String updateBy;
}
