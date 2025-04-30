package com.university.model;

public class Teacher {
    private int userId;
    private String name;
    private String department;
    private String hiredate;
    private String office;

    // ✅ Add public getters (required for JSP EL like ${teacher.name})
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getHiredate() {
        return hiredate;
    }

    public String getOffice() {
        return office;
    }

    // Optional: Add setters if needed
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
