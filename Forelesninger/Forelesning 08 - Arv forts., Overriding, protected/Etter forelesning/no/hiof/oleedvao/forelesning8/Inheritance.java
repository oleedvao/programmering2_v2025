package no.hiof.oleedvao.forelesning8;

import no.hiof.oleedvao.forelesning8.model.BussDriver;
import no.hiof.oleedvao.forelesning8.model.Carpenter;
import no.hiof.oleedvao.forelesning8.model.CarpenterApprentice;
import no.hiof.oleedvao.forelesning8.model.Person;

import java.time.LocalDate;

public class Inheritance {
    public static void main(String[] args) {


        Person person = new Person("Ola", "Nordmann", 20);
        System.out.println("Person: " + person.getFirstName() + " " + person.getLastName());

        Carpenter carpenter = new Carpenter("Rudolf", "Arnesen", 45, 3);
        System.out.println("\nCarpenter: " + carpenter.getFirstName() + " " + carpenter.getLastName());
        System.out.println("Carpenter has built " + carpenter.getNumHousesBuilt() + " houses.");

        carpenter.setFirstName("Noldus");
        carpenter.setLastName("Gnoldus");
        System.out.println("Carpenter: " + carpenter.getFirstName() + " " + carpenter.getLastName());

        BussDriver bussDriver = new BussDriver("Bjarne", "Bo", 55, "630 - Moss, Halden");
        System.out.println("\nBuss driver: " + bussDriver.getFirstName() + " " + bussDriver.getLastName());
        System.out.println("Buss driver has route " + bussDriver.getRoute());

        /*
        Vi oppretter her et par LocalDate-objekter. Disse opprettese på en litt spesiell måte ved å benytte metoder
        gjennom klassen:

            ... = LocalDate.<metode>

        Ikke tenk på mye på hvordan dette funker for nå. Vi går gjennom konseptene dette er basert på i en senere
        forelesning, men legg merke ved at vi kan opprette objekter av disse som under
         */
        LocalDate startDate = LocalDate.now(); // Oppretter basert datoen for når programmet kjøres.
        LocalDate endDate = LocalDate.of(2026, 6, 15); //Oppretter en fast bestemt dato

        /*
        Vi oppretter her et objekt av CarpenterApprentice som er en barneklasse av Carpenter. Vi kan da se at dette
        objektet arver alle egenskaper fra både Carpenter (direkte foreldreklasse), men også Person (foreldreklassen sin
        foreldreklasse.
         */
        CarpenterApprentice apprentice = new CarpenterApprentice("Jon", "Då", 21, 0,
                startDate, endDate);
        System.out.println("\nCarpenter apprentice: "+ apprentice.getFirstName() + " " + apprentice.getLastName());
        System.out.println("Carpenter apprentice num houses built: " + apprentice.getNumHousesBuilt());
        System.out.println("Carpenter apprentice training period: " +
                apprentice.getTrainingStartDate() + " - " + apprentice.getTrainingEndDate());


        /*
        System.out.println("\n---Print description---");
        person.printDescription();

        System.out.println();
        carpenter.printDescription();

        System.out.println();
        bussDriver.printDescription();

        System.out.println();
        apprentice.printDescription();
         */

        /*
        Vi ser her bruk av toString()-metode for de forskjellige objektene. Legg merke ved at vi ikke trenger å kalle
        metoden, men at Java automatisk antar at vi ønsker å benytte toString når vi skriver ut et objekt.
        Dette ...
            System.out.println(person);

        ... er altså en smidigere måte å skrive dette:

            System.out.println(person.toString())

        Merk at utskriftene nå vil være tilpasset de forskjellige objekttypene fordi vi har overridet toString() unikt
        for hver av dem.
         */
        System.out.println("\n---toString()---");
        System.out.println("-Person object-");
        System.out.println(person);

        System.out.println("\n-Carpenter object-");
        System.out.println(carpenter);

        System.out.println("\n-BussDriver object-");
        System.out.println(bussDriver);

        System.out.println("\n-CarpenterApprentice object-");
        System.out.println(apprentice);


    }
}
