package com.example.greendao.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Useinfo {

    private String name ;
    private  int  age;
    @Generated(hash = 1835248056)
    public Useinfo(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 942179355)
    public Useinfo() {



    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
