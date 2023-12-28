package com.training.project.employee.input.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withErrorDesc("argument not valid : " + exp.getMessage())
                       .withErrorCode(1003)
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleError(MethodArgumentNotValidException exp) {
        return ErrorObj.builder()
                       .withErrorDesc("validation error")
                       .withErrorCode(1004)
                       .withSubErrors(exp.getAllErrors()
                                         .stream()
                                         .map(se -> ErrorObj.builder()
                                                            .withErrorDesc(se.toString())
                                                            .withErrorCode(1005)
                                                            .build())
                                         .collect(Collectors.toList()))
                       .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorObj handleError(ConstraintViolationException exp) {
        return ErrorObj.builder()
                       .withErrorDesc("db validation error")
                       .withErrorCode(1006)
                       .withSubErrors(exp.getConstraintViolations()
                                         .stream()
                                         .map(se -> ErrorObj.builder()
                                                            .withErrorDesc(se.toString())
                                                            .withErrorCode(1005)
                                                            .build())
                                         .collect(Collectors.toList()))
                       .build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleError(Exception exp) {
        if (exp instanceof NullPointerException){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                                 .body(ErrorObj.builder()
                                               .withErrorDesc("code error : " + exp.getMessage())
                                               .withErrorCode(2002)
                                               .build());

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ErrorObj.builder()
                                           .withErrorDesc("server error : " + exp.getMessage())
                                           .withErrorCode(2001)
                                           .build());
    }


}
