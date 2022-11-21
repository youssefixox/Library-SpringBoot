package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "reviews")//you can only write "@Table" and JPA will create the table with the class name
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//This is for generate the id automatically by jpa
    private int id;

    @Column(name = "reference")//adding this above every attribute will rename the column name
    private String reference;

    @Column(name = "pubdate")
    private String pubdate;

    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", price=" + price +
                '}';
    }
}
