/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task.DAO;

import com.task.db.DBConnect;
import com.task.entities.Countries;
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
public class CountryService implements CountryImp {

    @Override
    public List<Countries> getAllCountries() {
        List<Countries> lc = new ArrayList<>();
        Connection connection = DBConnect.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from hr.countries as c where c.isActive='1'");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lc.add(new Countries(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }

        } catch (SQLException ex) {
            System.out.println("getAllCountries Failure: " + ex);
        }
        return lc;
    }

    @Override
    public Countries getCountryById(String id) {
        Connection connection = DBConnect.getConnection();
        Countries c = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from hr.countries as c where c.COUNTRY_ID=? and c.isActive='1'");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c = new Countries(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
            return c;
        } catch (SQLException ex) {
            System.out.println("getCountryById Failure" + ex);
        }
        return c;
    }

    @Override
    public boolean updateCountry(Countries country) {
        Connection connection = DBConnect.getConnection();
        boolean res = false;
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE hr.countries as c SET c.COUNTRY_ID=?, c.COUNTRY_NAME=?, c.REGION_ID=?  WHERE c.id=?");
            
            ps.setString(1, country.getCountryId());
            ps.setString(2, country.getName());
            ps.setInt(3, country.getRegionId());
            ps.setInt(4, country.getId());
            
//            System.out.println("psssss "+ps);
            ps.executeUpdate();
            res = true;
        } catch (SQLException ex) {
            System.out.println("updateCountry Failure: " + ex);
        }
        return res;
    }

    @Override
    public boolean addNewCountry(Countries country) {
        Connection connection = DBConnect.getConnection();
        boolean res = false;
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO hr.countries (COUNTRY_ID, COUNTRY_NAME, REGION_ID, isActive) VALUES (?, ?, ?, ?)");
            ps.setString(1, country.getCountryId());
            ps.setString(2, country.getName());
            ps.setInt(3, country.getRegionId());
            ps.setInt(4, 1);
            ps.executeUpdate();
            res = true;
            System.out.println("NEW COUNTRY ADDED");
        } catch (SQLException ex) {
            System.out.println("addNewCountry Failure: " + ex);
        }
        return res;
    }

    @Override
    public boolean deleteCountry(Countries country) {
        Connection connection = DBConnect.getConnection();
        System.out.println("IMPL "+country.getId());
        boolean res = false;
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE hr.countries as c SET c.isActive=0 WHERE c.id=?");
            ps.setInt(1, country.getId());
            ps.executeUpdate();
            System.out.println("pssss "+ps);
            res = true;
            System.out.println("COUNTRY DELETED");
        } catch (SQLException ex) {
            System.out.println("deleteCountry Failure: " + ex);
        }
        return res;
    }

}
