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
public class Jobs {

    private String id;
    private String title;
    private int minSal;
    private int maxSal;

    public Jobs() {
    }

    public Jobs(String id, String title, int minSal, int maxSal) {
        this.id = id;
        this.title = title;
        this.minSal = minSal;
        this.maxSal = maxSal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMinSal() {
        return minSal;
    }

    public void setMinSal(int minSal) {
        this.minSal = minSal;
    }

    public int getMaxSal() {
        return maxSal;
    }

    public void setMaxSal(int maxSal) {
        this.maxSal = maxSal;
    }

}
