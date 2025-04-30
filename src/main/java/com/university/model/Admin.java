/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.university.model;

/**
 *
 * @author Admin
 */
public class Admin {
    private int userId;
    private String name;
    private String access_level;
    private String last_login;

    // ✅ Add public getters (required for JSP EL like ${teacher.name})
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getAccess_level() {
        return access_level;
    }

    public String getLast_login() {
        return last_login;
    }

    // Optional: Add setters if needed
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccessLevel(String access_level) {
        this.access_level = access_level;
    }

    public void setLastLogin(String last_login) {
        this.last_login = last_login;
    }

}
