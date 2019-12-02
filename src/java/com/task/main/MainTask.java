/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task.main;

import com.task.DAO.CountryService;
import com.task.DAO.CountryImp;
import com.task.DAO.EmployeeImp;
import com.task.DAO.EmployeeService;
import com.task.db.DBConnect;
import com.task.entities.Countries;
import com.task.entities.Employees;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mubariz
 */
public class MainTask {

    public static void main(String[] args) {
        EmployeeService emps = new EmployeeService();
        
        List<Employees> lemp = new ArrayList<>(emps.getAllEmployees());
        
        for (Employees emp : lemp){
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSurname());
        }
    }
}
