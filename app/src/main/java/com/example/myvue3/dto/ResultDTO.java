package com.example.myvue3.dto;

import lombok.Data;

@Data
public class ResultDTO {
    private Boolean state;
    private Object result;
    private String message;
}
