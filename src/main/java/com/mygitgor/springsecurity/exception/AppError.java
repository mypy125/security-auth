package com.mygitgor.springsecurity.exception;

import lombok.Data;

import java.util.Date;

@Data
public class AppError {
    private int status;
    private String massage;
    private Date timeStamp;

    public AppError(int status, String massage) {
        this.status = status;
        this.massage = massage;
        this.timeStamp = new Date();
    }
}
