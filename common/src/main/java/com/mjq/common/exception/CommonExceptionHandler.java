package com.mjq.common.exception;

import com.mjq.common.bean.Result;
import com.mjq.common.enums.CodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Result handlerException(BusinessException e) {
        log.error("业务异常 message={}", e.getMessage());
        return Result.failResult(e.getCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        log.error("系统异常", e);
        return Result.failResult(CodeEnum.NETWORK_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handlerException(MethodArgumentNotValidException e) {
        String message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        log.error("参数异常 message={}", message);
        return Result.failResult(message);
    }
}
