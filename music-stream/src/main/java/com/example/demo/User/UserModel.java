package com.example.demo.User;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UserID;

    private String UserName;

    private String FirstName;
    private String LastName;

    public UserModel(Integer userID, String userName, String firstName, String lastName) {
        UserID = userID;
        UserName = userName;
        FirstName = firstName;
        LastName = lastName;
    }

    public UserModel() {
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
