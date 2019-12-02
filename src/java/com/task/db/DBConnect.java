/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Mubariz
 */
public class DBConnect {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hr?characterSetResult=UTF-8&characterEncoding=UTF-8&useUnicode=yes", "root", "2000");
        } catch (Exception ex) {
            System.out.println("Failure in Connection class " + ex);

        }
        return con;
    }
}
