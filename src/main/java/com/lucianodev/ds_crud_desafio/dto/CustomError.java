package com.lucianodev.ds_crud_desafio.dto;

import java.time.Instant;

public class CustomError {

    private Instant timeStamp;
    private Integer status;
    private String message;
    private String path;


    public CustomError(Instant timeStamp, Integer status, String message, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
