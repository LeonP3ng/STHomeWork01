package com.lp;

public class Student {

    private int ID;
    private String name;
    private String birDate;
    private boolean geneder;


    @Override
    public String toString() {
        String res = "学号:"+ID+"\t\t姓名:"+name+"\t\t出生日期："+birDate;
        res += geneder?"\t\t男":"\t\t女";
        return res;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirDate() {
        return birDate;
    }

    public void setBirDate(String birDate) {
        this.birDate = birDate;
    }

    public boolean isGeneder() {
        return geneder;
    }

    public void setGeneder(boolean geneder) {
        this.geneder = geneder;
    }
}
