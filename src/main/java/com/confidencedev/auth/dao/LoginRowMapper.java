package com.confidencedev.auth.dao;

import com.confidencedev.auth.models.Login;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRowMapper implements RowMapper<Login> {

    @Override
    public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Login(
                rs.getString("full_name"),
                rs.getString("email")
        );
    }
}
