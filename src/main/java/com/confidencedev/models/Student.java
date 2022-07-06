package com.confidencedev.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Student {

    private Integer id;
    private String fullName;
    private String email;
    private String currentLevel;
    private String address;
    private LocalDateTime started;

    public Student(String fullName, String email, String currentLevel,
                   String address, LocalDateTime started) {
        this.fullName = fullName;
        this.email = email;
        this.currentLevel = currentLevel;
        this.address = address;
        this.started = started;
    }
}
