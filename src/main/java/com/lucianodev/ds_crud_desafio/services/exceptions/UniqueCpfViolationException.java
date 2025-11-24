package com.lucianodev.ds_crud_desafio.services.exceptions;

public class UniqueCpfViolationException extends RuntimeException {
    public UniqueCpfViolationException(String msg) {
        super(msg);
    }
}
