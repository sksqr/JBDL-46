package com.gfg;

import java.util.List;

public class InheritanceDemo {
    public static void main(String[] args) {

        Object obj = new Object();
        Lecture lec1 = new Lecture();

        Lecture lecture1 = lec1;
        Lecture lecture2 = lec1;

        System.out.println(lecture1.equals(lecture1));

        Person person = new Person("rocky",23);
        person.walk();

        Student student = new Student();
        student.setAge(26);
        student.setName("Hitesh");

        student.walk();

//        Person teacher = new Teacher("Shashi", 30);

        Teacher t2 = new Teacher();

        Person teacher = new Teacher("Shashi", 30);

        if(teacher instanceof Teacher){
            Teacher t1 = (Teacher)teacher;
            t1.setCourse("Java");
            t1.teaching();
        }

        System.out.println(teacher instanceof Student);

        System.out.println(teacher instanceof Person);
        Person person1 = new Person();
        System.out.println(person1 instanceof Teacher);

//        Student student1 = (Student) teacher;
//        student1.walk();

        Teacher teacher1 = (Teacher) new Person();

        teacher1.walk();

       // Student st1 = new Teacher();

        teacher.walk();



    }
}
