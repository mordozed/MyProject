package com.task.entities;

/**
 *
 * @author Mubariz
 */
public class Users {

    private int id;
    private String name;
    private String username;
    private String password;
    private String job;
    private int isActive;

    public Users() {
    }

    public Users(int id, String name, String username, String password, String job) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.job = job;
    }

    public Users(int id, String name, String username, String password, String job, int isActive) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.job = job;
        this.isActive = isActive;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
