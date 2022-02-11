package com.grupozeus.telecom.Entitys;

import lombok.Data;

@Data
public class Response {
    
    private String message;

    public Response(String message) {
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
