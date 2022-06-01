package com.example.springweek03day04.exception;

public class InvalidException extends RuntimeException{

    public InvalidException(String message) {
        super(message);
    }
}
