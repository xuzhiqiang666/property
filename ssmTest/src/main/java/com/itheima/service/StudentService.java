package com.itheima.service;

import com.itheima.domain.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public Student findOne(int id);
    public void update(Student student);
    public void delete(Integer[] ids);
    public void save(Student student);
}
