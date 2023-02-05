package org.gfg;

import java.util.Date;

public class Lecture {

    static {
        System.out.println("Loading Class");
    }

//    public  static int count;
    public  static int count;
    private String title;
    private String mentor;
    private LectureStatus status;

    private final Date created;

    private double payment;

    protected Lecture() {
        count++;
        created = new Date();
    }

    public Lecture(String title, String mentor, LectureStatus status) {
        this.title = title;
        this.mentor = mentor;
        this.status = status;
        count++;
        created = new Date();
//        created = new Date();
    }

    protected String getMentor() {
        return mentor;
//        created=new Date();
    }

    public Date getCreated() {
        return created;
    }

    public LectureStatus getStatus() {
        return status;
    }

    public void setStatus(LectureStatus status) {
        this.status = status;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "title='" + title + '\'' +
                ", mentor='" + mentor + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
