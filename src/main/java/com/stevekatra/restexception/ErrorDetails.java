package com.stevekatra.restexception;

import java.util.Date;

public class ErrorDetails {
    private Date date;
    private String message;
    private String description;

    public ErrorDetails() {
    }

    public ErrorDetails(Date date, String message, String description) {
        this.date = date;
        this.message = message;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "date=" + date +
                ", message='" + message + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
