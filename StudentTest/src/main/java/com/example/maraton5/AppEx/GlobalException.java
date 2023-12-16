package com.example.maraton5.AppEx;

import com.example.maraton5.Maraton5Application;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Builder
@ControllerAdvice
public class GlobalException {

//    @ExceptionHandler(MarAppException.class)
//    @ResponseBody
//    public ResponseEntity<ErrorMessage> handleManagerException(MarAppException ex) {
//        HttpStatus httpStatus = ex.getErrorType().getHttpStatus();
//        return new ResponseEntity(createError(ex), httpStatus);
//    }
//
//    @ExceptionHandler(ArithmeticException.class)
//    @ResponseBody
//    public ResponseEntity<ErrorMessage> handleManagerException(ArithmeticException ex) {
//        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
//        return new ResponseEntity(createError(ex, httpStatus.value()), httpStatus);
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public ResponseEntity<ErrorMessage> handleManagerException(Exception ex) {
//        System.out.println(ex.getMessage());
//        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
//        return new ResponseEntity(createError(ex, httpStatus.value()), httpStatus);
//    }
//
//
//    private ErrorMessage createError (MarAppException ex){
//        return ErrorMessage.builder()
//                .code(ex.getErrorType().getCode())
//                .message(ex.getMessage())
//                .build();
//    }
//
//    private ErrorMessage createError(Exception ex, int value){
//        return ErrorMessage.builder()
//                .code(value)
//                .message(ex.getMessage())
//                .build();
//    }


}
