package com.taotao.service;

import com.taotao.pojo.Student;

public interface StudentService {

    Student getByName(String name);

    void insertSb();
    void insertFromWeb(Student student);
}
