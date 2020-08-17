package com.demo.meatball.common.exception;

import com.demo.meatball.common.response.RespResult;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author  xxx
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BindException.class)
    public RespResult violationException(BindException exception) {
        // 不带任何参数访问接口,会抛出 BindException
        // 因此，我们只需捕获这个异常，并返回我们设置的 message 即可
        
        String message = exception.getAllErrors().get(0).getDefaultMessage();
        return new RespResult();
    }
}
