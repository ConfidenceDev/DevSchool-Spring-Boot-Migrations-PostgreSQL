package com.confidencedev.services;

import com.confidencedev.auth.dao.LoginDao;
import com.confidencedev.auth.models.Login;
import com.confidencedev.dao.StudentDao;
import com.confidencedev.exceptions.NotFoundException;
import com.confidencedev.models.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final LoginDao loginDao;
    private final StudentDao studentDao;

    public String validateLogin(Login login){
        Optional<Login> check = loginDao.check(login.email());
        if (check.isPresent()) return "User exists";

        return String.format("No user found with the email: %s", login.email());
    }

    public void addNewStudent(Student student) {
        // TODO: check if movie exists
        int result = studentDao.createStudent(student);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }

    public List<Student> getStudents() {
        return studentDao.getAllStudents();
    }

    public Student getStudent(int id) {
        return studentDao.getStudentById(id)
                .orElseThrow(() ->
                        new NotFoundException(
                                String.format("Student with id %s not found", id)));
    }

    public void updateStudent(int id, Student student) {
        Optional<Student> students = studentDao.getStudentById(id);
        students.ifPresentOrElse(m -> {
            int result = studentDao.updateStudent(id, student);
            if (result != 1) {
                throw new IllegalStateException("oops could not update student");
            }
        }, () -> {
            throw new NotFoundException(String.format("Student with id %s not found", id));
        });
    }

    public void deleteStudent(Integer id) {
        Optional<Student> student = studentDao.getStudentById(id);
        student.ifPresentOrElse(s -> {
            int result = studentDao.deleteStudent(id);
            if (result != 1) {
                throw new IllegalStateException("oops could not delete student");
            }
        }, () -> {
            throw new NotFoundException(String.format("Student with id %s not found", id));
        });
    }
}
