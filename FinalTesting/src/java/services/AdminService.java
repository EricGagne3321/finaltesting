/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;

/**
 *
 * @author Eric
 */
public class AdminService {
    public List<Role> getAll() throws Exception {
        RoleDB roledb = new RoleDB();
        List<Role> roles = roledb.getAll();
        return roles;
    }
    
    public Role get(int roleID) throws Exception {
        RoleDB roledb = new RoleDB();
        Role role = roledb.get(roleID);
        return role;
    }
}
