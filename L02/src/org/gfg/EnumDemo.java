package org.gfg;

public class EnumDemo {

    public static void main(String[] args) {
//        LectureStatus lectureStatus = new LectureS();

        Lecture lecture = new Lecture();
        lecture.setMentor("Shashi");
        lecture.setStatus(LectureStatus.LIVE);

        System.out.println(lecture.getStatus().equals(LectureStatus.LIVE));
    }
}
