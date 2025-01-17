public class Encapsulation {
    public static void main(String[] args) {



        System.out.println("---Student 1---");

        Student student1 = new Student();

        /*
        Etter å fulgt innkapslings-prinsippet kan vi nå bare aksessere instansvariablene gjennom get- og set-metoder.
        Dette er i motsetning til hvordan student2 er definert i kommentaren lenger ned
         */

        /*
        Vi benytter standardiserte set-metoder for å sette verdier for instansvariabler. Disse tilater oss å sende
        med verdien som skal settes, men hvordan denne operasjonen blir utført bestemmes av metode-definisjonen
        i klassen.
         */
        student1.setFirstName("Ole-Edvard");
        student1.setLastName("Ørebæk");
        student1.setStudentId("123456");

        /*
        En fordel med å benytte get- og set-metoder er at vi kan automatisere logikk, slik som å kontrollere
        parameterverdier. Her har vi automatisert at bare alder-verdier mellom 0 og 120 er godtatt.
        Se setAge()-definisjonen i Student-klassen for logikken.
         */
        student1.setAge(-50);
        System.out.println("Trying to set age to -50 " + student1.getAge());
        student1.setAge(2000);
        System.out.println("Trying to set age to 2000 " + student1.getAge());
        student1.setAge(27);
        System.out.println("Trying to set age to 27 " + student1.getAge());

        /*
        Skal vi hente ut verdier for instansvariabler benytter vi get-metoder. Disse metodene standardiserer hvilke
        instansvariabler som vi kan hente ut (de vi har tilgjengelige set-metoder for) og hvordan verdiene hentes ut.
         */
        System.out.println();
        System.out.println("First name: " + student1.getFirstName());
        System.out.println("Last name: " + student1.getLastName());
        System.out.println("Age: " + student1.getAge());
        System.out.println("Age: " + student1.getStudentId());

        /*
         En annen fordel med get- og set-metoder er at vi kan kontrollere akkurat hvilke handlinger som skal være lov
        for en gitt instansvariabel. Her kan vi bare lese birthNumber, men ikke sette noen ny verdi.
        Det motsatte hadde også vært mulig ved å bare opprette en set-metode og ingen get-metode.
         */
        System.out.println("Birth number: " + student1.getBirthNumber());


        /*
        Den kommenterte koden under er hvordan vi opprettet objekter før vi fulgte innkapslingsprinsippet.
         */
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

        /*
        Vi benytter her et Course-objekt etter at denne klassen er blitt oppdatert til å følge innkapslingsprinsippet.
         */
        Course course1 = new Course();
        course1.setCourseName("Programmering 2");
        course1.setCourseCode("ITF10619");

        System.out.println(course1.getCourseName());
        System.out.println(course1.getCourseName());

    }
}
