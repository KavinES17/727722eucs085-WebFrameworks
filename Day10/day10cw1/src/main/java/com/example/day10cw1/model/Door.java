package com.example.day10cw1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Door {
    @Id
    private int doorId;
    private String doorType;
    private String material;
    private String color;
    private int price;
    public Door() {
    }
    public Door(int doorId, String doorType, String material, String color, int price) {
        this.doorId = doorId;
        this.doorType = doorType;
        this.material = material;
        this.color = color;
        this.price = price;
    }
    public int getDoorId() {
        return doorId;
    }
    public void setDoorId(int doorId) {
        this.doorId = doorId;
    }
    public String getDoorType() {
        return doorType;
    }
    public void setDoorType(String doorType) {
        this.doorType = doorType;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
}
