package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "dicts")//you can only write "@Table" and JPA will create the table with the class name
public class Dict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//This is for generate the id automatically by jpa
    private int id;

    @Column(name = "langue")//adding this above every attribute will rename the column name
    private String langue;

    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", langue='" + langue + '\'' +
                ", price=" + price +
                '}';
    }
}
