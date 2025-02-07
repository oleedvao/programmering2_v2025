public class Encapsulation {
    public static void main(String[] args) {

        System.out.println("---Student 1---");

        Student student1 = new Student();

        student1.firstName = "Ole-Edvard";
        student1.lastName = "Ørebæk";
        student1.age = 27;
        student1.studentId = "123456";

        System.out.println(student1.firstName);
        System.out.println(student1.lastName);
        System.out.println(student1.age);
        System.out.println(student1.studentId);


        //---Student 2---
        /*
        System.out.println("\n---Student 2---");

        Student student2 = new Student();

        student2.firstName = "John";
        student2.lastName = "Doe";
        student2.age = 40;
        student2.studentId = "654321";

        System.out.println(student2.firstName);
        System.out.println(student2.lastName);
        System.out.println(student2.age);
        System.out.println(student2.studentId);
         */


        //---Course object---
        System.out.println("\n---Course object---");

        Course course1 = new Course();
        course1.courseName = "Programmering 2";
        course1.courseCode = "ITF10619";

        System.out.println(course1.courseName);
        System.out.println(course1.courseCode);

    }
}
