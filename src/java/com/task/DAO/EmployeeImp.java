/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task.DAO;

import com.task.entities.Employees;
import java.util.List;

/**
 *
 * @author Mubariz
 */
public interface EmployeeImp {
    public List<Employees> getAllEmployees(); //r

    public Employees getEmployeesById(String id); //r

    public boolean updateEmployee(Employees emp); //u

    public boolean addNewEmployee(Employees emp); //c

    public boolean deleteEmployee(Employees emp); //d

}
