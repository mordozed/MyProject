package com.task.entities;

/**
 *
 * @author Mubariz
 */
public class Departments {

    private int id;
    private String name;
    private int managerId;
    private int locationId;

    public Departments() {
    }

    public Departments(int id, String name, int managerId, int locationId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.locationId = locationId;
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

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

}
