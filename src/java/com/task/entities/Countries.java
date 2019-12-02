/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task.entities;

/**
 *
 * @author Mubariz
 */
public class Countries {

    private int id;
    private String countryId;
    private String name;
    private int regionId;
    private int isActive;

    public Countries() {
    }

    public Countries(String countryId) {
        this.countryId = countryId;
    }

    public Countries(int id, String countryId, String name, int regionId, int isActive) {
        this.id = id;
        this.countryId = countryId;
        this.name = name;
        this.regionId = regionId;
        this.isActive = isActive;
    }

    public Countries(int id, String countryId, String name, int regionId) {
        this.id = id;
        this.countryId = countryId;
        this.name = name;
        this.regionId = regionId;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
      
        this.id = id;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

}