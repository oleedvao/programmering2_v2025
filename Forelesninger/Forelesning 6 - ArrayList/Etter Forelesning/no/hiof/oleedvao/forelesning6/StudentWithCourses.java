package no.hiof.oleedvao.forelesning6;

import no.hiof.oleedvao.forelesning6.model.Course;
import no.hiof.oleedvao.forelesning6.model.Student;

import java.util.ArrayList;

public class StudentWithCourses {
    public static void main(String[] args) {

        /*
        Se Student-klassen sin definisjon: Vi har nå opprettet en instansvariabel, courses, som er en ArrayList som
        kan holde på Course objekter og som representerer "kursene" som studenten tar.
         */
        Student ole = new Student("Ole-E", "Ørebæk", 27,
                "123456");

        Course prog2 = new Course("Programmering 2",
                "ITF10619");
        Course databaser = new Course("Databasesystemer",
                "ITF12345");

        /*
        Vi har opprettet en metode som har den spesifikke oppgaven å legge til Course-objekter til den interne
        Course-ArrayListen. Merk at vi ikke benytter en typisk set-metode for denne handlingen og vil typisk ikke ha
        en set-metode for lister.
        For andre handlinger slik som å hente spesifikke elementer, fjerne elementer, få antall elementer osv., vil vi
        typisk opprette unike metoder for hver av disse. Dette er mer fornuftig for å håndtere innkapsling med lister.
         */
        ole.addToCourses(prog2);
        ole.addToCourses(databaser);

        /*
        Vi har opprettet en metode som internt i klassen skriver ut studenten sine "kurs".
         */
        System.out.println("Oles courses: ");
        ole.printCourses();

        /*
        Vi benytter her en get-metode for å hente en liste med studenten sine "kurs".
        VIKTIG: Merk at vi har definert get-metoden på en litt spesiell måte slik at den returnerer en KOPI av
        "studenten" sin liste, IKKE den faktiske listen. Dette er gjort for å sørge for at den virkelige listen ikke
        kan modifiseres fritt utenfor klassen. Altså gjør vi dette for å opprettholde innkapsling.
         */
        ArrayList<Course> olesCourses = ole.getCourses();

        /*
        Vi kan se at liste-kopien inneholder de samme elementene som "studentens" virkelige liste.
         */
        System.out.println("\nCopy of oles courses:");
        for (Course course : olesCourses) {
            System.out.println(course.getCourseName());
        }

        /*
        Vi fjerner her et element fra liste-kopien. Dette påvirker IKKE den ekte listen inneholdt i "studenten".
         */
        olesCourses.remove(databaser);
        System.out.println("\nCopy of oles courses after removal:");
        for (Course course : olesCourses) {
            System.out.println(course.getCourseName());
        }

        /*
        Vi kan ved en ny utskrift av "studentens" kurs, bekrefte at denne ikke har endret seg.
         */
        System.out.println("\nOles courses:");
        ole.printCourses();

    }
}
