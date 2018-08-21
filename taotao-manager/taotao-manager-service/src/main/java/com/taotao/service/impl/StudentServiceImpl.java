package com.taotao.service.impl;

import com.taotao.mapper.StudentMapper;
import com.taotao.pojo.Student;
import com.taotao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student getByName(String name) {
        if(Objects.equals("1",name)){
            List<Student> list = studentMapper.getByName("小王");
            if(!CollectionUtils.isEmpty(list)){
                return list.get(0);
            }
        }
       return studentMapper.getByMobile("13333333333");
    }

    @Override
    public void insertSb() {
        Student student = new Student();
        student.setName("sb");
        student.setMobile("888888");

        studentMapper.insert(student);
    }
    @Override
    public void insertFromWeb(Student student) {
        if(student.getName()!=null&&student.getMobile()!=null){
            studentMapper.insert(student);
            System.out.println(student.getId() );
        }
    }
}
