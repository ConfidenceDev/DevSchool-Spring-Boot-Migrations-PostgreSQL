package com.confidencedev.services;

import com.confidencedev.dao.StudentDao;
import com.confidencedev.models.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@DataJdbcTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentDao studentDao;

    @Autowired
    private StudentService underTest;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Disabled
    void addNewStudent() {
        //Given
        Student student = new Student(
                "John Doe",
                "johndoe@gmail.com",
                "senior high school",
                "world wide",
                LocalDateTime.now()
        );

        //When
        underTest.addNewStudent(student);

        //Then
        ArgumentCaptor<Student> studentArgumentCaptor =
                ArgumentCaptor.forClass(Student.class);

        verify(studentDao).createStudent(studentArgumentCaptor.capture());

        Student capturedUser = studentArgumentCaptor.getValue();

        assertThat(capturedUser).isEqualTo(student);
    }

    @Test
    @Disabled
    void getStudents() {
        //When
        underTest.getStudents();

        //Given
        verify(studentDao).getAllStudents();
    }

    @Test
    @Disabled
    void getStudent() {
        //Given
        int id = 1;

        //When
        Student student = underTest.getStudent(id);

        //Then
        assertThat(student.getId()).isEqualTo(id);
    }

    @Test
    @Disabled
    void updateStudent() {
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}