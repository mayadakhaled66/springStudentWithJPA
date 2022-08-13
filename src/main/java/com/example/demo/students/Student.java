package com.example.demo.students;

import com.example.demo.school.School;

import javax.persistence.*;

@Entity(name = "Student")
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Transient
    @Column(name = "is_graduated")
    private boolean isGraduated;

    @OneToOne(cascade = CascadeType.ALL) //cascade is added due to object references an unsaved transient instance - save the transient instance before flushing error
    private HomeAddress homeAddress;

    @ManyToOne
    @JoinColumn(name = "school_id",nullable=false)  //FK
    private School school;


    public Student() {
    }

    public Student( String firstName, String lastName, String email,boolean isGraduated,HomeAddress homeAddress,School school) {//
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isGraduated =isGraduated;
        this.homeAddress = homeAddress;
        this.school = school;
    }


    public boolean isGraduated() {
        return isGraduated;
    }

    public void setGraduated(boolean graduated) {
        isGraduated = graduated;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
