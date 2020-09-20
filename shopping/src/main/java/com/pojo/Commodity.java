package com.pojo;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "social_shopping",type = "commodity")
public class Commodity {
    private Integer id;
    private String name;
    private Double price;
    private Integer inventory;
    private String comment;
    private String type;

    public Commodity() {
    }

    public Commodity(Integer id, String name, Double price, Integer inventory, String comment, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.comment = comment;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", comment='" + comment + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
