package com.example.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Restaurant {
    @Id
    private int restaurntId;
    private String restaurntName;
    private String location;
    private long capacity;
    private String special;
    public Restaurant() {
    }
    public Restaurant(int restaurntId, String restaurntName, String location, long capacity, String special) {
        this.restaurntId = restaurntId;
        this.restaurntName = restaurntName;
        this.location = location;
        this.capacity = capacity;
        this.special = special;
    }
    public int getRestaurntId() {
        return restaurntId;
    }
    public void setRestaurntId(int restaurntId) {
        this.restaurntId = restaurntId;
    }
    public String getRestaurntName() {
        return restaurntName;
    }
    public void setRestaurntName(String restaurntName) {
        this.restaurntName = restaurntName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public long getCapacity() {
        return capacity;
    }
    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }
    public String getSpecial() {
        return special;
    }
    public void setSpecial(String special) {
        this.special = special;
    }
    
}
