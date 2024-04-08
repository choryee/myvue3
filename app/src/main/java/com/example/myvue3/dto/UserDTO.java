package com.example.myvue3.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private int no;
    private String name;
    private String email;
    private String pwd;
    private boolean gender;
    private boolean del;
    private LocalDateTime regDate;
}
