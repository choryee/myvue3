package com.example.myvue3.mapper;

import com.example.myvue3.dto.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user3 where del=false order by regDate DESC")
    public List<UserDTO> findAll();

    @Update("update user3 set name=#{name}, pwd=#{pwd}, gender=#{gender} where no=#{no}")
    public int editById(UserDTO userDTO);

    @Update("update user3 set del=true where no=#{no}")
    public int delete(int no);

    @Insert("insert into user3(name, email, pwd, gender) value(#{name},#{email},#{pwd},#{gender})")
    public int save(UserDTO userDTO);

}
