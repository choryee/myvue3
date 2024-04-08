package com.example.myvue3.dto;

import com.example.myvue3.dao.Department;
import com.example.myvue3.dao.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
//@Component
public class DataDto {
    private Object key;
    private Department name;
    private List<Student> studentList;
   // private Object studentList;


    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        for(Student s : studentList){
            System.out.println("DataDto setter>>"+ s);
        }
    }


}
