package services;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

public class UserService {
    
    public User login(String email, String password) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }
        // If the username and password do not match, then will return nothing
        return null;
    }
    
    public Role userRole(String email) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            return user.getRole();
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<User> getAll() throws Exception {
        UserDB userdb = new UserDB();
        List<User> users = userdb.getAll();
        return users;
    }
    
    public User get(String email) throws Exception {
        UserDB userdb = new UserDB();
        User user = userdb.get(email);
        return user;
    }
    
    public void insert(String email, String firstName, String lastName, String password, int role) throws Exception {
        User user = new User(email, true, firstName, lastName, password);
        AdminService as = new AdminService();
        Role r = as.get(role);
        user.setRole(r);
        UserDB userdb = new UserDB();
        userdb.insert(user);
    }
    
    public void update(String email, String firstName, String lastName, String password, int role) throws Exception {
        UserDB userdb = new UserDB();
        
        User u = userdb.get(email);
        
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setPassword(password);
        
        AdminService as = new AdminService();
        Role r = as.get(role);
        u.setRole(r);
        
        userdb.update(u);
    }
    
    public void delete(String email) throws Exception {
        UserDB userdb = new UserDB();
        User user = userdb.get(email);
        userdb.delete(user);
    }
}
