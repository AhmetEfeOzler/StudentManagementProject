package com.studentmanagementproject.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private Integer age;
    private String momName;
    private String dadName;
    private String address;
    private String gender;
    private Integer credit;
    private String major;
    private String school;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentLesson> lessons;

    public Student(String name, String surname, Integer age, String momName, String dadName, String address, String gender, Integer credit, String major, String school) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.momName = momName;
        this.dadName = dadName;
        this.address = address;
        this.gender = gender;
        this.credit = credit;
        this.major = major;
        this.school = school;
    }

    public Student() {}

    public Integer getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public String getMomName() { return momName; }

    public void setMomName(String momName) { this.momName = momName; }

    public String getDadName() { return dadName; }

    public void setDadName(String dadName) { this.dadName = dadName; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public Integer getCredit() { return credit; }

    public void setCredit(Integer credit) { this.credit = credit; }

    public String getMajor() { return major; }

    public void setMajor(String major) { this.major = major; }

    public String getSchool() { return school; }

    public void setSchool(String school) { this.school = school; }

    public List<StudentLesson> getLessons() { return lessons; }

    public void setLessons(List<StudentLesson> lessons) { this.lessons = lessons; }
}
