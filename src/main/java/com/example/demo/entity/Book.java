package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")//you can only write "@Table" and JPA will create the table with the class name
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//This is for generate the id automatically by jpa
    private int id;

    @Column(name = "auteur")//adding this above every attribute will rename the column name
    private String auteur;

    private int nbp;

    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setNbp(int nbp) {
        this.nbp = nbp;
    }

    public int getNbp() {
        return nbp;
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
                ", auteur='" + auteur + '\'' +
                ", nbp=" + nbp +
                ", price=" + price +
                '}';
    }
}
