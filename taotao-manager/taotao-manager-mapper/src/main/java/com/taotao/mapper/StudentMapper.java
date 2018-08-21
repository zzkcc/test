package com.taotao.mapper;

import com.taotao.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    List<Student> getByName(@Param("name") String name);

    Student getByMobile(@Param("mobile")String mobile);

    void insert(Student student);
}
