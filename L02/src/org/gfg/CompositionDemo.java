package org.gfg;

public class CompositionDemo {
    public static void main(String[] args) {
        Batch batch = new Batch();

        batch.setName("JBDL-46");
        Teacher teacher = new Teacher("Ravi",29);
        batch.setMentor(teacher);

        Student student1 = new Student();
        student1.setName("Sumit");
        batch.getStudentList().add(student1);


        Batch batch2 = new Batch();
        batch2.setName("JBDL-47");
        batch2.setMentor(teacher);

        System.out.println(batch);
        System.out.println(batch2);

        //batch = null;

      //  batch2 = null;



    }
}
