package com.confidencedev.auth.dao;

import com.confidencedev.auth.models.Login;
import com.confidencedev.models.Student;

import java.util.Optional;

public interface LoginDao {
    Optional<Login> check(String email);
}
