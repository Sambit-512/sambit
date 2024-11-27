package com.sambit.payload;

import java.util.Date;

public class ErrorDetiles {
    private String message;
    private Date date;
    private String request;




    public ErrorDetiles(String message, Date date, String request) {
        this.message = message;
        this.date = date;


        this.request = request;
    }
    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public String getRequest() {
        return request;
    }
}