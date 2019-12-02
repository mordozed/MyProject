/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task.DAO;

import com.task.entities.Countries;
import java.util.List;

/**
 *
 * @author Mubariz
 */
public interface CountryImp {

    public List<Countries> getAllCountries(); //r

    public Countries getCountryById(String id); //r

    public boolean updateCountry(Countries country); //u

    public boolean addNewCountry(Countries country); //c

    public boolean deleteCountry(Countries country); //d

}
