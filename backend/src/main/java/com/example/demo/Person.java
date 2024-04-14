package com.example.demo;

public class Person {

    private String name;
    private int age;
    private String role;
    private int yearsOfExperience;

    public Person(String name, int age, String role, int yearsOfExperience) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}
