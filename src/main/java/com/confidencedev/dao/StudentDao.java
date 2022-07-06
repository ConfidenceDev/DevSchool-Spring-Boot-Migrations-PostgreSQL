package com.confidencedev.dao;

import com.confidencedev.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    int createStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> getStudentById(int id);
    int updateStudent(int id, Student student);
    int deleteStudent(int id);
}
