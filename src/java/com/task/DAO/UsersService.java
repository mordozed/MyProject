/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task.DAO;

import com.task.db.DBConnect;
import com.task.entities.Users;
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
public class UsersService implements UsersImp {

    @Override
    public List<Users> getAllUsers() {
        List<Users> lu = new ArrayList<>();
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select u.name, u.job from hr.users as u where u.isActive='1'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lu.add(new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println("getAllUsers Failure: " + ex);
        }
        return lu;
    }

    @Override
    public Users getUserById(int id) {
        Connection connection = DBConnect.getConnection();
        Users u = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from hr.users as u where u.id=1 and u.isActive='1'");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new Users(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
            return u;
        } catch (SQLException ex) {
            System.out.println("getUserById Failure" + ex);
        }
        return u;
    }

    @Override
    public boolean updateUser(Users user) {
        Connection connection = DBConnect.getConnection();
        boolean res = false;
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE hr.users as u SET u.name=?, u.username=?, u.password=?, u.job=?  WHERE u.id=?");

            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getJob());
            ps.setInt(5, user.getId());
            ps.executeUpdate();
            res = true;
        } catch (SQLException ex) {
            System.out.println("updateUser Failure: " + ex);
        }
        return res;
    }

    @Override
    public boolean addNewUser(Users user) {
        Connection connection = DBConnect.getConnection();
        boolean res = false;
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO hr.users (name, username, password, job, isActive) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getJob());
            ps.setInt(5, 1);
            ps.executeUpdate();
            res = true;
            System.out.println("NEW USER ADDED");
        } catch (SQLException ex) {
            System.out.println("addNewUser Failure: " + ex);
        }
        return res;
    }

    @Override
    public boolean deleteUser(Users user) {
        Connection connection = DBConnect.getConnection();
        System.out.println("IMPL " + user.getId());
        boolean res = false;
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE hr.user as u SET u.isActive=0 WHERE u.id=?");
            ps.setInt(1, user.getId());
            ps.executeUpdate();
            System.out.println("pssss " + ps);
            res = true;
            System.out.println("USER DELETED");
        } catch (SQLException ex) {
            System.out.println("deleteUser Failure: " + ex);
        }
        return res;
    }

}
