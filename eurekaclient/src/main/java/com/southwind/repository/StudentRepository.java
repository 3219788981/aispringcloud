package com.southwind.repository;

import com.southwind.entity.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository {
    //set,list,queue都是继承的该接口Collection
    public Collection<Student> findAll();
    public Student findById(long id);
    public void saveOrUpdate(Student student);
    public void deleteById(long id);
}
