package com.goltsov.springcourse.models;

import javax.validation.constraints.*;

public class Person {

    private int id;

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name should contain from 2 to 30 letters")
    private String name;

    @Min(value = 18, message = "User should be older than 18 years old")
    private int age;
    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Email should be valid")
    private String email;

    public Person() {
    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
