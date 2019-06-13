package com.itheima.service.impl;

import com.itheima.domain.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentMapper.findAll();
        return studentList;
    }

    @Override
    public Student findOne(int id) {
        return studentMapper.findOne(id);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void delete(Integer[] ids) {
        studentMapper.delete(ids);
    }

    @Override
    public void save(Student student) {
        studentMapper.save(student);
    }
}
