package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "emprunts")//you can only write "@Table" and JPA will create the table with the class name
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//This is for generate the id automatically by jpa
    private int id;

    @Column(name = "type")//adding this above every attribute will rename the column name
    private String type;

    @Column(name = "cinadherent")
    private String cinadherent;

    private int documentid;

    @Column(name = "dateemprunt")
    private String dateemprunt;

    @Column(name = "dateretour")
    private String dateretour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCinadherent() {
        return cinadherent;
    }

    public void setCinadherent(String cinadherent) {
        this.cinadherent = cinadherent;
    }

    public void setDocumentid(int documentid) {
        this.documentid = documentid;
    }

    public int getDocumentid() {
        return documentid;
    }

     public String getDateemprunt() {
        return dateemprunt;
    }

    public void setDateemprunt(String dateemprunt) {
        this.dateemprunt = dateemprunt;
    }

     public String getDateretour() {
        return dateretour;
    }

    public void setDateretour(String dateretour) {
        this.dateretour = dateretour;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", cinadherent='" + cinadherent + '\'' +
                ", documentid=" + documentid +
                ", dateemprunt='" + dateemprunt + '\'' +
                ", dateretour='" + dateretour + '\'' +
                '}';
    }
}
