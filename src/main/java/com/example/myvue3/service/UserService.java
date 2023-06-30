package com.example.myvue3.service;

import com.example.myvue3.dto.ResultDTO;
import com.example.myvue3.dto.UserDTO;

public interface UserService {
    public ResultDTO findAll();
    public ResultDTO editById(UserDTO userDTO);
    public ResultDTO delete(int no);
    public ResultDTO save(UserDTO userDTO);
}
