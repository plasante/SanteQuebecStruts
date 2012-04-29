package com.uniksoft.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.uniksoft.model.User;


public class UserAction extends ActionSupport {
    private String username;
    private String password;
    private String passwordConfirmation;
    
    public String addUser() throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setEncryptedPassword(password);
        user.setSalt(password);
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
}
