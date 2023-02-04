package com.gfg;

public class ClassObjDemo {

    static int a;

    public static void main(String[] args) {
        createObjects();
        System.out.println("Total obj : "+Lecture.count);

    }

    public static void createObjects(){
        Lecture lecture1 =  new Lecture();//new Lecture("lec-01","shashi","live");
        Lecture lecture2 = new Lecture();//new Lecture("lec-02","shashi","upcoming");
        System.out.println(lecture2);
        lecture2.setStatus("live");
        lecture1.setStatus("completed");
        System.out.println(lecture1.getStatus());
        System.out.println(lecture2.getStatus());

    }
}
