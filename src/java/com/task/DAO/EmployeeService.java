/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task.DAO;

import com.task.db.DBConnect;
import com.task.entities.Countries;
import com.task.entities.Employees;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mubariz
 */
public class EmployeeService implements EmployeeImp {

    @Override
    public List<Employees> getAllEmployees() {
        List<Employees> lemp = new ArrayList<>();
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT tabl1.EMPLOYEE_ID as id, tabl1.FIRST_NAME as name, tabl1.LAST_NAME as surname, tabl1.EMAIL, tabl1.PHONE_NUMBER, tabl1.SALARY, tabl1.COMMISSION_PCT, tabl1.DEPARTMENT_NAME, tabl1.STREET_ADDRESS, tabl1.POSTAL_CODE, tabl1.CITY, tabl1.STATE_PROVINCE, tabl1.JOB_TITLE, tabl1.MIN_SALARY, tabl1.MAX_SALARY, tabl1.COUNTRY_NAME, r.REGION_NAME\n"
                    + "FROM (SELECT tab1.EMPLOYEE_ID, tab1.FIRST_NAME, tab1.LAST_NAME, tab1.EMAIL, tab1.PHONE_NUMBER, tab1.SALARY, tab1.COMMISSION_PCT, tab1.DEPARTMENT_NAME, tab1.STREET_ADDRESS, tab1.POSTAL_CODE, tab1.CITY, tab1.STATE_PROVINCE, tab1.JOB_TITLE, tab1.MIN_SALARY, tab1.MAX_SALARY, c.COUNTRY_NAME, c.REGION_ID\n"
                    + "FROM (SELECT ta1.EMPLOYEE_ID, ta1.FIRST_NAME, ta1.LAST_NAME, ta1.EMAIL, ta1.PHONE_NUMBER, ta1.SALARY, ta1.COMMISSION_PCT, ta1.DEPARTMENT_NAME, ta1.STREET_ADDRESS, ta1.POSTAL_CODE, ta1.CITY, ta1.STATE_PROVINCE, ta1.COUNTRY_ID, j.JOB_TITLE, j.MIN_SALARY, j.MAX_SALARY\n"
                    + "FROM (SELECT t1.EMPLOYEE_ID, t1.FIRST_NAME, t1.LAST_NAME, t1.EMAIL, t1.PHONE_NUMBER,t1.JOB_ID, t1.SALARY, t1.COMMISSION_PCT, t1.DEPARTMENT_ID, t1.DEPARTMENT_NAME, t1.MANAGER_ID, t1.LOCATION_ID, l.STREET_ADDRESS, l.POSTAL_CODE, l.CITY, l.STATE_PROVINCE, l.COUNTRY_ID\n"
                    + "FROM (SELECT e.EMPLOYEE_ID, e.FIRST_NAME, e.LAST_NAME, e.EMAIL, e.PHONE_NUMBER, e.JOB_ID, e.SALARY, e.COMMISSION_PCT, e.DEPARTMENT_ID, d.DEPARTMENT_NAME, d.MANAGER_ID, d.LOCATION_ID \n"
                    + "FROM hr.employees as e \n"
                    + "LEFT JOIN hr.departments as d\n"
                    + "ON e.DEPARTMENT_ID= d.DEPARTMENT_ID) as t1\n"
                    + "left JOIN hr.locations as l\n"
                    + "ON t1.Location_id = l.Location_id) as ta1\n"
                    + "INNER JOIN hr.jobs as j\n"
                    + "ON ta1.JOB_ID = j.JOB_ID) as tab1\n"
                    + "INNER JOIN hr.countries as c\n"
                    + "ON tab1.COUNTRY_ID = c.COUNTRY_ID) as tabl1\n"
                    + "INNER JOIN hr.regions as r\n"
                    + "ON tabl1.REGION_ID = r.REGION_ID\n"
                    + "Order By tabl1.Employee_id");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lemp.add(new Employees(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17)));
            }

        } catch (SQLException ex) {
            System.out.println("getAllEmployees Failure: " + ex);
        }
        return lemp;
    }

    @Override
    public Employees getEmployeesById(String id) {

        Connection connection = DBConnect.getConnection();
        Employees emp = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT tabl1.EMPLOYEE_ID as id, tabl1.FIRST_NAME as name, tabl1.LAST_NAME as surname, tabl1.EMAIL, tabl1.PHONE_NUMBER, tabl1.SALARY, tabl1.COMMISSION_PCT, tabl1.DEPARTMENT_NAME, tabl1.STREET_ADDRESS, tabl1.POSTAL_CODE, tabl1.CITY, tabl1.STATE_PROVINCE, tabl1.JOB_TITLE, tabl1.MIN_SALARY, tabl1.MAX_SALARY, tabl1.COUNTRY_NAME, r.REGION_NAME\n"
                    + "FROM (SELECT tab1.EMPLOYEE_ID, tab1.FIRST_NAME, tab1.LAST_NAME, tab1.EMAIL, tab1.PHONE_NUMBER, tab1.SALARY, tab1.COMMISSION_PCT, tab1.DEPARTMENT_NAME, tab1.STREET_ADDRESS, tab1.POSTAL_CODE, tab1.CITY, tab1.STATE_PROVINCE, tab1.JOB_TITLE, tab1.MIN_SALARY, tab1.MAX_SALARY, c.COUNTRY_NAME, c.REGION_ID\n"
                    + "FROM (SELECT ta1.EMPLOYEE_ID, ta1.FIRST_NAME, ta1.LAST_NAME, ta1.EMAIL, ta1.PHONE_NUMBER, ta1.SALARY, ta1.COMMISSION_PCT, ta1.DEPARTMENT_NAME, ta1.STREET_ADDRESS, ta1.POSTAL_CODE, ta1.CITY, ta1.STATE_PROVINCE, ta1.COUNTRY_ID, j.JOB_TITLE, j.MIN_SALARY, j.MAX_SALARY\n"
                    + "FROM (SELECT t1.EMPLOYEE_ID, t1.FIRST_NAME, t1.LAST_NAME, t1.EMAIL, t1.PHONE_NUMBER,t1.JOB_ID, t1.SALARY, t1.COMMISSION_PCT, t1.DEPARTMENT_ID, t1.DEPARTMENT_NAME, t1.MANAGER_ID, t1.LOCATION_ID, l.STREET_ADDRESS, l.POSTAL_CODE, l.CITY, l.STATE_PROVINCE, l.COUNTRY_ID\n"
                    + "FROM (SELECT e.EMPLOYEE_ID, e.FIRST_NAME, e.LAST_NAME, e.EMAIL, e.PHONE_NUMBER, e.JOB_ID, e.SALARY, e.COMMISSION_PCT, e.DEPARTMENT_ID, d.DEPARTMENT_NAME, d.MANAGER_ID, d.LOCATION_ID \n"
                    + "FROM hr.employees as e \n"
                    + "LEFT JOIN hr.departments as d\n"
                    + "ON e.DEPARTMENT_ID= d.DEPARTMENT_ID) as t1\n"
                    + "left JOIN hr.locations as l\n"
                    + "ON t1.Location_id = l.Location_id) as ta1\n"
                    + "INNER JOIN hr.jobs as j\n"
                    + "ON ta1.JOB_ID = j.JOB_ID) as tab1\n"
                    + "INNER JOIN hr.countries as c\n"
                    + "ON tab1.COUNTRY_ID = c.COUNTRY_ID) as tabl1\n"
                    + "INNER JOIN hr.regions as r\n"
                    + "ON tabl1.REGION_ID = r.REGION_ID\n"
                    + "WHERE tabl1.EMPLOYEE_ID=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emp = new Employees(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
            }
            return emp;
        } catch (SQLException ex) {
            System.out.println("getEmployeesById Failure" + ex);
        }
        return emp;
    }

    @Override
    public boolean updateEmployee(Employees emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public boolean addNewEmployee(Employees emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteEmployee(Employees emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
