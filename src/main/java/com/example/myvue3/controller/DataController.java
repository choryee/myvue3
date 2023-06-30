package com.example.myvue3.controller;

import com.example.myvue3.dto.ResultDTO;
import com.example.myvue3.dto.UserDTO;
import com.example.myvue3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DataController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String name(){
        return "data 준비중...";
    }

    @GetMapping("/findAll")
    public ResultDTO findAll(){
        return userService.findAll();
    }

    @PostMapping("/editById")
    public ResultDTO editById(@RequestBody UserDTO userDTO){
        System.out.println("UserDTO userDTO>>"+ userDTO);
        return userService.editById(userDTO);
    }

    @DeleteMapping("/delete")
    public ResultDTO delete(@RequestParam("no") int no){// RequestParam로 받을때는, 화면에서 밑처럼 데이터 보내야.
        // const params={ //5강. 13'33
        //  params:{no:1}
        //}
        return userService.delete(no);
    }

    @PutMapping("/save")
    public ResultDTO save(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }




}
