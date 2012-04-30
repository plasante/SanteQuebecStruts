package com.uniksoft.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.uniksoft.model.User;
import com.uniksoft.util.SimpleSHA1;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;


public class UserAction extends ActionSupport {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String passwordConfirmation;
    
    List<User> users = new ArrayList<User>();
    
    @Override
    public String execute() {
        return SUCCESS;
    }
    
    public String addUser() throws Exception {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        String salt = SimpleSHA1.getSalt(password);
        user.setSalt(salt);
        user.setEncryptedPassword(SimpleSHA1.getEncryptedPassword(salt, password));
        UserDAO dao = new UserDAO();
        String daoAddUserResult = dao.addUser(user);
        if (daoAddUserResult.equals("success")) {
            addActionMessage("Registration success");
            return SUCCESS;
        } else if (daoAddUserResult.equals("duplicated")) {
            addActionError("Duplicated Username. Please chose a different one.");
            return ERROR;
        } else {
            addActionError("Registration failed");
            return ERROR;
        }
    }

    @SkipValidation
    public String listUsers() throws Exception {
        UserDAO dao = new UserDAO();
        users = dao.getUsers();
        return SUCCESS;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
