package org.gfg;

import java.util.ArrayList;
import java.util.List;

public class Batch {

    private String name;

    private Teacher mentor;

    private List<Student> studentList;

    private List<Lecture> lectureList;

    public Batch() {
        studentList = new ArrayList<>();
        lectureList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getMentor() {
        return mentor;
    }

    public void setMentor(Teacher mentor) {
        this.mentor = mentor;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "name='" + name + '\'' +
                ", mentor=" + mentor +
                ", studentList=" + studentList +
                ", lectureList=" + lectureList +
                '}';
    }
}
