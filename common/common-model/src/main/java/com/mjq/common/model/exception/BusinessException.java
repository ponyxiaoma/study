package com.mjq.common.model.exception;

import com.mjq.common.model.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException {

    private int code;

    private String message;

    public BusinessException(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

}
