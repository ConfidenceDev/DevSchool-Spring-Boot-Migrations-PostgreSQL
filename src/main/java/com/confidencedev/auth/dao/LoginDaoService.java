package com.confidencedev.auth.dao;

import com.confidencedev.auth.models.Login;
import com.confidencedev.dao.StudentRowMapper;
import com.confidencedev.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoginDaoService implements LoginDao{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Login> check(String email) {
        var sql = """
                SELECT full_name, email
                FROM student
                WHERE email = ?;
                """;
        return jdbcTemplate.query(sql, new LoginRowMapper(), email).stream().findFirst();
    }
}
