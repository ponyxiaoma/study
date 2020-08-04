package com.mjq.common.web.bean;

import com.mjq.common.web.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {

    public int code;

    public String message;

    public T data;


    public static int SUCCESS_CODE = 200;
    public static int FAIL_CODE = 500;

    public static String SUCCESS_MESSAGE = "SUCCESS";
    public static String ERROR_MESSAGE = "网络异常";


    public static <T> Result<T> successResult(T data) {
        return new Result<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> Result<T> failResult(String message) {
        return new Result<>(FAIL_CODE, message, null);
    }

    public static <T> Result<T> failResult(int code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> failResult(CodeEnum codeEnum) {
        return new Result<>(codeEnum.getCode(), codeEnum.getMessage(), null);
    }

}
