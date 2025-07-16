package com.java.todolist.utils.exeptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}