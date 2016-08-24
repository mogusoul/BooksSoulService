package com.soulsbooks.net.model;

/**
 * Created by zhangjun on 2016/7/24.
 */
public class User {

    private int id;
    private String name;
    private String nick_name;
    private int sex;
    private String password;
    private String account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", sex=" + sex +
                ", password='" + password + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
