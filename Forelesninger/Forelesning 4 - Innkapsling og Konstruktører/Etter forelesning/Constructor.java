public class Constructor {
    public static void main(String[] args) {

        /*
        Her benytter vi en konstruktør til å ta imot verdier for firstName, lastName, age og studentId og sette dem
        samtidig som Student-objektet blir opprettet. Dette er mer smiding enn å sette verdier for disse
        instansvariablene på en og en linje.
         */
        System.out.println("---Student constructor use---");
        Student student = new Student("John", "Doe", 50,
                "654321");

        /*
        Etter å ha benyttet konstruktøren er verdiene for disse instansvariablene satt og vi kan benytte dem uten å
        foreta oss noe mer. Vi kan imidlertid ogås oppdatere dem men set-metodene som er tilgjengelig, om vi skulle
        ønsket det.
         */
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getAge());
        System.out.println(student.getStudentId());


        /*
        Under er et tilsvarende eksempel av konstruktørbruk for Course klassen etter at det er blitt implementert
        en konstruktør for denne klassen som tar parametere for instansvariablene courseName og courseCode.
         */
        System.out.println("\n---Course constructor use---");
        Course course = new Course("Databasesystemer", "ITF10319");

        System.out.println(course.getCourseName());
        System.out.println(course.getCourseCode());


    }
}
