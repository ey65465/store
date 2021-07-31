package com.myapp1.store.pojo;

import java.util.Date;

public class School {
    private int id;
    private String name;
    private String address;
    private City city;
    private Date openDate;
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openTime) {
        this.openDate = openTime;
    }
}
