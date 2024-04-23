package com.example.day7pah.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {
    @Id
    private int cardId;
    private String carName;
    private String carType;
    private int owners;
    private String currentOwnerName;
    private long mobile;
    private String address;
    public Car() {
    }
    public Car(int cardId, String carName, String carType, int owners, String currentOwnerName, long mobile,
            String address) {
        this.cardId = cardId;
        this.carName = carName;
        this.carType = carType;
        this.owners = owners;
        this.currentOwnerName = currentOwnerName;
        this.mobile = mobile;
        this.address = address;
    }
    public int getCardId() {
        return cardId;
    }
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }
    public String getCarType() {
        return carType;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public int getOwners() {
        return owners;
    }
    public void setOwners(int owners) {
        this.owners = owners;
    }
    public String getCurrentOwnerName() {
        return currentOwnerName;
    }
    public void setCurrentOwnerName(String currentOwnerName) {
        this.currentOwnerName = currentOwnerName;
    }
    public long getMobile() {
        return mobile;
    }
    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
}