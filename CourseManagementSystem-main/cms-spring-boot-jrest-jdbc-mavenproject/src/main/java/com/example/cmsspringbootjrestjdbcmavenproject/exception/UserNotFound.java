package com.example.cmsspringbootjrestjdbcmavenproject.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String message) {
        super(message);
    }

}
