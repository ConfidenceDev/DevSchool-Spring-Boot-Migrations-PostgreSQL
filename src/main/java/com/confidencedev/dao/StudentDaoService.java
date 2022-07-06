package com.confidencedev.dao;

import com.confidencedev.models.Student;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentDaoService implements StudentDao{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int createStudent(Student student) {
        var sql = """
                INSERT INTO student(full_name, current_level, address, started)
                VALUES (?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql, student.getFullName(),
                student.getCurrentLevel(), student.getAddress(),
                LocalDateTime.now());
    }

    @Override
    public List<Student> getAllStudents() {
        var sql = """
                SELECT id, full_name, current_level, address, started
                FROM student
                LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public Optional<Student> getStudentById(int id) {
        var sql = """
                SELECT id, full_name, current_level, address, started
                FROM student
                WHERE id = ?;
                """;
        return jdbcTemplate.query(sql, new StudentRowMapper(), id)
                .stream().findFirst();
    }

    @Override
    public int updateStudent(int id, Student student) {
        var sql = """
                UPDATE student SET full_name = ?, current_level = ?, address = ?, started = ?
                WHERE id = ?;
                """;
        return jdbcTemplate.update(sql,
                student.getFullName(),
                student.getCurrentLevel(),
                student.getAddress(),
                LocalDateTime.now(),
                id);
    }

    @Override
    public int deleteStudent(int id) {
        var sql = """
                DELETE FROM student
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    }
}
