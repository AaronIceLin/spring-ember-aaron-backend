package com.springember.model;


/**
 * Created by aaron.lin on 3/12/17.
 */
public class User {
    private Integer id;
    private String fullName;
    private String phone;

    public User(){

    }

    public User(Integer id, String fullName, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", fullName=" + fullName + ", phone=" + phone + "]";
    }
}
