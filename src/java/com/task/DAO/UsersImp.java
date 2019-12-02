/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task.DAO;

import com.task.entities.Users;
import java.util.List;

/**
 *
 * @author Mubariz
 */
public interface UsersImp {
    
    public List<Users> getAllUsers(); //r

    public Users getUserById(int id); //r

    public boolean updateUser(Users country); //u

    public boolean addNewUser(Users country); //c

    public boolean deleteUser(Users country); //d
    
}
