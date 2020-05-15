package com.lp;

public class SMTest {
    public static void main(String[] args) {
        //参考《Google Java编程风格指南》6.3 静态成员：使用类进行调用
        //应使用类名调用静态的类成员，而不是具体某个对象或表达式
        //StudentManager studentManager =new StudentManager();
        StudentManager.App();
        
    }
}
