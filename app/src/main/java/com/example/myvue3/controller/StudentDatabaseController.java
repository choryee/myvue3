//package com.example.myvue3.controller;
//
//import Refactorying_Java_2nd.chapter12.removeSubClass.Data;
//import com.example.myvue3.dao.Department;
//import com.example.myvue3.dao.Student;
//import com.example.myvue3.dto.DataDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.*;
//
//@CrossOrigin(origins = "http://localhost:8080")
//@RestController
//public class StudentDatabaseController { // 230825 데이터 일부는 vue.js에 뿌려짐. 리스트는 안 됨.
//
//    // @Autowired
//
//   // private Map<Department, List<Student>> departmentStudentMap= new EnumMap<>(Department.class);
//    // T, List<Student>  >> COMPUTER_SCIENCE, List<Student>
//
//    private Map<Department, List<Student>> dsmap=new HashMap<>();
//
//
////    StudentDatabaseController( Class<T> enumClass ){  생성자는 없어도 되는 듯.
////          departmentStudentMap=new EnumMap<>(enumClass);
////    }
//
//    public void addStudent(Department department, Student student){
//        //  departmentStudentMap.computeIfAbsent(department, k -> new ArrayList<>()).add(student);
//        List<Student> students = dsmap.get(department); // 해당 department의 리스트
//        if(students == null){ // students 리스트가 없다면,
//            students=new ArrayList<>();
//            dsmap.put(department, students);
//        }
//        students.add(student); // students 리스트가 있을때,
//        dsmap.put(department, students);
//    }
//
//    @GetMapping("/findAll") // DataContrller.java에도 findAll있어, 번갈아 가면서 막아야.
//    public DataDto show(){
//        addStudent(Department.ENGINEERING, new Student("Brianna", 34));
//        addStudent(Department.ENGINEERING, new Student("Bob", 16));
//       // addStudent(Department.MATHEMATICS, new Student("Jon", 12));
//
//        //dataDto=new DataDto(); 이렇게 객체 만들지 말고, 위 처럼, @Autowired로 해라.
//        // Map.Entry<T, List<Student>> entry = null;
////        Department departmentName=null;
////        //Map.Entry<T, List<Student>> entry;
////        for( Map.Entry<Department, List<Student>> entry : departmentStudentMap.entrySet()){
////            departmentName= (Department) entry.getKey(); // getKey()가 Department
////            System.out.println("전공영문은 "+entry.getKey()+ ", 전공 한글명은 "+departmentName.getName() + ", 학생은 "+entry.getValue());
////            dataDto.setKey(entry.getKey());
////            dataDto.setStudentList(entry.getValue());
////            dataDto.setName(departmentName);
////        }
//        DataDto dataDto=new DataDto();
//        List<Student> list=dsmap.get(Department.ENGINEERING);
//        for(Student s : list){
//            System.out.println(s);
//        }
//        dataDto.setName(Department.ENGINEERING);
//        dataDto.setStudentList(list);
//        String example = "She said, \"Hello!\""; //이스케이프 쿤자.
//        System.out.println("dataDto>>"+dataDto.getStudentList());
//        return dataDto;
//    }
//
//}
