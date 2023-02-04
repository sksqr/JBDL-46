package com.gfg;

public class Teacher extends Person{
    private String course;

    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void teaching(){
        System.out.println(getName() + " is teaching "+course);
    }

    @Override
    public void walk(){

        System.out.println(getName()+", teacher is walking");
    }
}
