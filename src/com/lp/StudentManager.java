package com.lp;

import java.util.*;

public class StudentManager {
    static ArrayList<Student> studentList = new ArrayList<Student>();

    //7 11 函数是否已经有文档注释？（功能、输入、返回及其他可选函数是否已经有文档注释？（功能、输入、返回及其他可选)
    /**
     * 功能：主函数，接收用户输入的数字，执行相应功能
     * 输入：无
     * 输出：无
     * */
    static void App(){
        while (true){
            System.out.println("");
            System.out.println("请选择操作：");
            System.out.println("***********************************");
            // 19 代码行长度是否在要求之内？ 参考《Google Java编程风格指南》4.4 同一行里的字符长度不超过100
            //System.out.println("*                           1  插入                                  *");
            //System.out.println("*                           2  查找                                  *");
            //System.out.println("*                           3  删除                                  *");
            //System.out.println("*                           4  修改                                  *");
            //System.out.println("*                           5  输出                                  *");
            //System.out.println("*                           6  退出                                  *");
            System.out.println("*                           1  插入                             *");
            System.out.println("*                           2  查找                             *");
            System.out.println("*                           3  删除                             *");
            System.out.println("*                           4  修改                             *");
            System.out.println("*                           5  输出                             *");
            System.out.println("*                           6  退出                             *");
            System.out.println("***********************************");

            Scanner sc = new Scanner(System.in);
            switch (sc.nextLine()){
                case "1":{
                    System.out.println("请输入学生学号：");
                    int id = Integer.parseInt(sc.nextLine());
                    Student student = new Student();
                    student.setID(id);
                    System.out.println("请输入学生姓名：");
                    student.setName(sc.nextLine());
                    System.out.println("请输入学生出生日期：");
                    student.setBirDate(sc.nextLine());
                    System.out.println("请输入学生性别：");
                    String geneder = sc.nextLine();
                    if(geneder.equals("男"))
                        student.setGeneder(true);
                    else if(geneder.equals("女"))
                        student.setGeneder(false);
                    else {
                        System.out.println("添加失败，请正确输入性别！");
                        break;
                    }
                    if(insertStudent(student))
                        System.out.println("成功插入1条学生数据！");

                    break;
                }
                case "2":{
                    System.out.println("请输入学生姓名：");
                    int count = getStudentsByName(sc.nextLine());
                    //23
                    //if(count !=0 ) System.out.println("共找到"+ count+"条记录");
                    //else System.out.println("查无此人!");
                    if(count !=0 ) {
                        System.out.println("共找到"+ count+"条记录");
                    }else {
                        System.out.println("查无此人!");
                    }
                    break;
                }
                case "3":{
                    System.out.println("请输入学生姓名：");
                    int count = deleteStudentsByName(sc.nextLine());
                    //18 23
                    //if(count !=0 ) System.out.println("共删除"+ count+"条记录");
                    if(count != 0 ) {
                        System.out.println("共删除"+ count+"条记录");
                    } else {
                        System.out.println("查无此人!");
                    }
                    break;
                }
                case "4":{

                    Student student = new Student();
                    System.out.println("请输入学生姓名：");
                    student.setName(sc.nextLine());
                    System.out.println("请输入学生修改后出生日期：");
                    student.setBirDate(sc.nextLine());
                    System.out.println("请输入学生修改后性别：");
                    String geneder = sc.nextLine();
                    //23
                    // if(geneder.equals("男"))
                    if(geneder.equals("男")) {
                        student.setGeneder(true);
                    }else if(geneder.equals("女")) {
                        student.setGeneder(false);
                    }else {
                        System.out.println("添加失败，请正确输入性别！");
                        break;
                    }

                    int count = updateStudentsByName(student);
                    //23
                    //if(count !=0 ) System.out.println("修改"+ count+"条记录");
                    if(count !=0 ) {
                        System.out.println("修改"+ count+"条记录");
                    } else {
                        System.out.println("查无此人！");
                    }
                    break;
                }
                case "5":{
                    outputStudents();
                    break;
                }
                case "6":{
                    exitStudents();
                    System.out.println("退出系统成功！");
                    return;
                }
                default:
                    System.out.println("请正确输入按键序号！");
                    break;

            }
        }

    }

    //11 函数是否已经有文档注释？（功能、输入、返回及其他可选函数是否已经有文档注释？（功能、输入、返回及其他可选)
    /**  功能:输入'1'，插入学生信息
    *   输入：Student类型变量,学生实体
    *   返回：布尔类型，插入成功返回true,插入失败返回false
    * */
    static boolean insertStudent(Student student){
        if(studentList.size() == 20) {
            System.out.println("插入失败，系统人数已达到上限20人！");
            return false;
        }

        for (int x = 0; x < studentList.size(); x++) {
            Student s = studentList.get(x);
            if (s.getID() == student.getID()) {
                System.out.println("学号已存在,插入失败");
                return false;
            }
        }

        studentList.add(student);

        Collections.sort(studentList, new Comparator<Student>() {

            public int compare(Student s1, Student s2) {
                Integer id1 = new Integer(s1.getID());
                Integer id2 = new Integer(s2.getID());
                Integer result = id1.compareTo(id2);
                return result;
            }
        });

        return true;
    }

    //11 函数是否已经有文档注释？（功能、输入、返回及其他可选函数是否已经有文档注释？（功能、输入、返回及其他可选)
    /**  功能：输入'2'，通过名字查找学生记录
     *  输入：String类型，学生名字
     *  返回：int类型，返回操作影响的记录条数
     * */
    static int getStudentsByName(String name){

        int count = 0;
        for(Student sd : studentList)
            if(sd.getName().equals(name)){
                System.out.println(sd);
                count++;
            }

        return count;

    }

    //11 函数是否已经有文档注释？（功能、输入、返回及其他可选函数是否已经有文档注释？（功能、输入、返回及其他可选)
    /** 功能：输入'3'，通过名字删除学生记录
    *  输入：String类型，学生名字
    *  返回：int类型，返回操作影响的记录条数
    * */

    static int deleteStudentsByName(String name){

        int count = 0;
        int size = studentList.size();
        for(int i=0;i<size;i++) {
            //23
            //if(i>=studentList.size()) break; //防止一次删除多个元素，导致越界
            if(i>=studentList.size()) {
                break;
            }
            Student student = studentList.get(i);
            if(student.getName().equals(name)) {
                count++;
                //60
                studentList.remove(student);
            }
        }

        return count;
    }


    //11 函数是否已经有文档注释？（功能、输入、返回及其他可选函数是否已经有文档注释？（功能、输入、返回及其他可选)
    /**  功能：输入'4'，通过名字修改学生记录
     *  输入：Student类型，学生实体
     *  返回：int类型，返回操作影响的记录条数
     * */
    static int updateStudentsByName(Student student){
        int count = 0;
        int size = studentList.size();
        for(int i=0;i<size;i++) {
            Student temp = studentList.get(i);
            if (temp.getName().equals(student.getName())) {
                temp.setGeneder(student.isGeneder());
                temp.setBirDate(student.getBirDate());
                count++;
            }
        }
        return count;
    }

    //11 函数是否已经有文档注释？（功能、输入、返回及其他可选函数是否已经有文档注释？（功能、输入、返回及其他可选)
    /**  功能：输入'5'，打印所有学生信息
     *  输入：无
     *  返回：无
     * */
    static void outputStudents(){
        //23
        //for(Student student:studentList)
        //    System.out.println(student);
        for(Student student:studentList){
            System.out.println(student);
        }

        System.out.println("共计"+studentList.size()+"条记录");
    }

    //11 函数是否已经有文档注释？（功能、输入、返回及其他可选函数是否已经有文档注释？（功能、输入、返回及其他可选)
    /**  功能：输入'6'，清空list，退出系统
     *  输入：无
     *  返回：无
     * */
    static void exitStudents(){
        studentList.clear();
    }


}
