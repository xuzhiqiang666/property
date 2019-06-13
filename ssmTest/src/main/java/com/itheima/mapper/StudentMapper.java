package com.itheima.mapper;

import com.itheima.domain.Student;

import java.util.List;
public interface StudentMapper {
    public List<Student> findAll();
    public void update(Student student);
    public void delete(Integer[] ids);
    public void save(Student student);

    public Student findOne(int id);
}
