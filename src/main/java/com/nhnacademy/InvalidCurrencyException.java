package com.nhnacademy;

public class InvalidCurrencyException extends IllegalArgumentException {
    public InvalidCurrencyException() {
        super("invalid input");
    }
}
