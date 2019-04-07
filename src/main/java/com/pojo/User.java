package com.pojo;
import java.sql.Timestamp;
import  java.util.Date;
import java.util.UUID;
/**
 * @创建人 zcl
 * @创建时间:2019/4/7
 * @描述 用户的实体
 */
public class User {
    private  String ID;
    private  String UserID;
    private  String UserName;
    private  String Password;
    private  String Email;
    private  String SEX;
    private Timestamp  Gen_Time;
    private  Timestamp Login_Time;
    private  Timestamp Last_Login_Time;
    private   boolean ISDelete;
    private  int Count;
    public User genarateID() {
        if (this.ID == null) {
            this.ID = UUID.randomUUID().toString();
        }
        return this;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public Timestamp getGen_Time() {
        return Gen_Time;
    }

    public void setGen_Time(Timestamp gen_Time) {
        Gen_Time = gen_Time;
    }

    public Timestamp getLogin_Time() {
        return Login_Time;
    }

    public void setLogin_Time(Timestamp login_Time) {
        Login_Time = login_Time;
    }

    public Timestamp getLast_Login_Time() {
        return Last_Login_Time;
    }

    public void setLast_Login_Time(Timestamp last_Login_Time) {
        Last_Login_Time = last_Login_Time;
    }

    public boolean isISDelete() {
        return ISDelete;
    }

    public void setISDelete(boolean ISDelete) {
        this.ISDelete = ISDelete;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }


}
