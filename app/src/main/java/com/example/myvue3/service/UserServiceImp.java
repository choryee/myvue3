package com.example.myvue3.service;

import com.example.myvue3.dao.UserDao;
import com.example.myvue3.dto.ResultDTO;
import com.example.myvue3.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    private ResultDTO rDto;

    @Autowired
    private UserDao uDao;

    @Override
    public ResultDTO findAll() {
        rDto=new ResultDTO();
        List<UserDTO> resultList = uDao.findAll();
        if(resultList !=null){
            rDto.setState(true);
            rDto.setResult(resultList);
            rDto.setMessage("hey, Brian!!");
        }else {
            rDto.setState(false);
        }
        return rDto;
    }

    @Override
    public ResultDTO editById(UserDTO userDTO) {//수정
        rDto=new ResultDTO();
        int no=userDTO.getNo();
        int state=uDao.editById(userDTO);
        if(state==1){
            rDto.setState(true);
            rDto.setMessage("사용자수정 성공!!");
        }else {
            rDto.setState(false);
            rDto.setMessage("사용자수정 실패!!");
        }
        return rDto;
    }

    @Override
    public ResultDTO delete(int no) {
        rDto=new ResultDTO();
        int state=uDao.delete(no);
        if(state==1){
            rDto.setState(true);
            rDto.setMessage("삭제성공");
        }else{
            rDto.setState(false);
            rDto.setMessage("삭제실패!!");
        }
        return rDto;
    }

    @Override
    public ResultDTO save(UserDTO userDTO) {
        rDto=new ResultDTO();
        int state=uDao.save(userDTO);
        if(state==1){
            rDto.setState(true);
            rDto.setMessage("저장성공!!");
        }else {
            rDto.setState(false);
            rDto.setMessage("저장실패!!");
        }
        return rDto;
    }
}
