package no.hiof.oleedvao.forelesning5;

import no.hiof.oleedvao.forelesning5.model.Student;

public class ObjectReferences {

    public static void main(String[] args) {

        Student student1 = new Student("Ole-Edvard", "Ørebæk",
                27, "123456");

        /*
        Vi setter her en objekt-variabel lik en annen som allerede har et objekt. Dette innebærer egentlig bare at
        to variabler "peker" på samme objekt. Dette produserer altså IKKE to objekter.
         */
        Student student2 = student1;

        System.out.println("Student1: " + student1.getFirstName() + " " + student1.getLastName());
        System.out.println("Student2: " + student2.getFirstName() + " " + student2.getLastName());

        /*
        Hvis vi endrer på en av objektvariablene vil i så fall resultatene av dette gjelde uansett hvilken variabel
        vi benytter. Resultatet av endringen under er altså at både student1 og student2 vil vise at Student-objektets
        etternavn er blitt endret til Antonsen, selv om handlingen bare ble gjort for student2.
         */
        student2.setLastName("Antonsen");

        System.out.println();
        System.out.println("Student1: " + student1.getFirstName() + " " + student1.getLastName());
        System.out.println("Student2: " + student2.getFirstName() + " " + student2.getLastName());


    }
}
