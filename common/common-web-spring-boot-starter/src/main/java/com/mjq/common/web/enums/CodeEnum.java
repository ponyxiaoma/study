package com.mjq.common.web.enums;

import lombok.Getter;

@Getter
public enum CodeEnum {

    NETWORK_ERROR(500, "网络异常");

    private int code;

    private String message;

    CodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


}
