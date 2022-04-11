package com.example.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "name","surName","followerList","createdAt"})
public class User {
    private int id;
    private String name;
    private String surName;
    private int[] followerList;
    private LocalDate createdAt = LocalDate.now();
    private String message;
}
