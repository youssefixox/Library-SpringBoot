package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")//you can only write "@Table" and JPA will create the table with the class name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//This is for generate the id automatically by jpa
    private int id;

    @Column(name = "firstname")//adding this above every attribute will rename the column name
    private String fname;

    @Column(name = "lastname")
    private String lname;

    @Column(name = "adress")
    private String adress;

    @Column(name = "cin")
    private String cin;

    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

     public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

     public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", cin='" + cin + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
