package com.example.myvue3.dao;

import com.example.myvue3.dto.UserDTO;

import java.util.List;

public interface UserDao {
    public List<UserDTO> findAll();
    public int editById(UserDTO userDTO);
    public int delete(int no);
    public int save(UserDTO userDTO);
}
