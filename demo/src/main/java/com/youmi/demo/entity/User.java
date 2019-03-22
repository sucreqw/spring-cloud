package com.youmi.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: User
 * @Package
 * @Description:
 * @date 2019-03-21 14:55
 */

public class User {
    private int id;
    private String nick;


    private String pass;
    private String  uid;
    private String avater;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @JsonIgnore
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

/*    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", pass='" + pass + '\'' +
                ", uid='" + uid + '\'' +
                ", avater='" + avater + '\'' +
                '}';
    }*/
}
