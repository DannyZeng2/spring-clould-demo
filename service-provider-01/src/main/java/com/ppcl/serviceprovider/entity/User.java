package com.ppcl.serviceprovider.entity;

/**
 * @version: 1.0.0
 * @Author: Danny Zeng
 * @Date: 2021/5/2 19:34
 * @LastEditors: Danny Zeng
 * @LastEditTime: 2021/5/2 19:34
 */
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
