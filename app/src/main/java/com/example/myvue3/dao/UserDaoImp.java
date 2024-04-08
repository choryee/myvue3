package com.example.myvue3.dao;

import com.example.myvue3.dto.UserDTO;
import com.example.myvue3.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @Autowired UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int editById(UserDTO userDTO) {
        return userMapper.editById(userDTO);
    }

    @Override
    public int delete(int no) {
        return userMapper.delete(no);
    }

    @Override
    public int save(UserDTO userDTO) {
        return userMapper.save(userDTO);
    }
}
