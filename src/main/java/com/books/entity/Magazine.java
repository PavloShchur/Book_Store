package com.books.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Magazine")
public class Magazine extends AbstractEntity{

    private String titleOfMagazine;
    private String priceOfMagazine;

    public Magazine() {
    }

    public Magazine(String titleOfMagazine, String priceOfMagazine) {
        this.titleOfMagazine = titleOfMagazine;
        this.priceOfMagazine = priceOfMagazine;
    }

    public Magazine(String titleOfMagazine) {
        this.titleOfMagazine = titleOfMagazine;
    }

    public String getTitleOfMagazine() {
        return titleOfMagazine;
    }

    public void setTitleOfMagazine(String titleOfMagazine) {
        this.titleOfMagazine = titleOfMagazine;
    }

    public String getPriceOfMagazine() {
        return priceOfMagazine;
    }

    public void setPriceOfMagazine(String priceOfMagazine) {
        this.priceOfMagazine = priceOfMagazine;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "titleOfMagazine='" + titleOfMagazine + '\'' +
                ", priceOfMagazine='" + priceOfMagazine + '\'' +
                '}';
    }
}
