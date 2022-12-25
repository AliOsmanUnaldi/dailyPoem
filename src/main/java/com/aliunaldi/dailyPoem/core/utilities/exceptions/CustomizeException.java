package com.aliunaldi.dailyPoem.core.utilities.exceptions;

import lombok.Data;

@Data
public class CustomizeException extends Exception{

    private String message;
    public CustomizeException() {
    }

    public CustomizeException(String message) {
        this.message = message;
    }
}
