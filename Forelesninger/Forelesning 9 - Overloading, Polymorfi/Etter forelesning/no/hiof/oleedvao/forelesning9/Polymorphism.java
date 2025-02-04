package no.hiof.oleedvao.forelesning9;

import no.hiof.oleedvao.forelesning9.model.BussDriver;
import no.hiof.oleedvao.forelesning9.model.Carpenter;
import no.hiof.oleedvao.forelesning9.model.CarpenterApprentice;
import no.hiof.oleedvao.forelesning9.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;

public class Polymorphism {
    public static void main(String[] args) {
        Person person = new Person("Ola", "Nordmann", 20);

        Carpenter carpenter = new Carpenter("Rudolf", "Arnesen", 45, 3);

        BussDriver bussDriver = new BussDriver("Bjarne", "Bo", 55, "630 - Moss, Halden");

        CarpenterApprentice apprentice = new CarpenterApprentice("Jon", "Då", 21, 0,
                LocalDate.now(), LocalDate.of(2026, 6, 15));


        System.out.println("\n---Descriptions---");
        System.out.println("-Person object-");
        System.out.println(person);

        System.out.println("\n-Carpenter object-");
        System.out.println(carpenter);

        System.out.println("\n-BussDriver object-");
        System.out.println(bussDriver);

        System.out.println("\n-CarpenterApprentice object-");
        System.out.println(apprentice);


        System.out.println("\n---Age comparison (Polymorphism)---");

        /*
        Vi ser at compareAgeTo() på grunn av polymorfisme i parameteren (av typen Person) kan benyttes til å
        sammenligne alle typer objekter som er av  typen Person eller arver fra Person. Denne metoden er altså veldig
        fleksibel til typen objekt, så lenge det arver fra og konseptuelt er en Person, som er noe vi kan si om både
        BussDriver, Carpenter og CarpenterApprentice.
         */
        person.compareAgeTo(person);
        person.compareAgeTo(bussDriver);
        person.compareAgeTo(carpenter);
        person.compareAgeTo(apprentice);

        System.out.println();
        carpenter.compareAgeTo(bussDriver);
        carpenter.compareAgeTo(apprentice);

        System.out.println("\n---List of Persons (Polymorphism)---");
        /*
        Vi benytter her polymorfisme til å opprette en liste som kan holde på alle typer Person-objekter. Det
        inkluderer altså objekter av Person sine barneklasser, BussDriver, Carpenter og CarpenterApprentice.
         */
        ArrayList<Person> listOfPersons = new ArrayList<>();
        listOfPersons.add(person);
        listOfPersons.add(bussDriver);
        listOfPersons.add(carpenter);
        listOfPersons.add(apprentice);

        /*
        Vi kan også benytte polymorfisme til å gå gjennom alle Person-objekter i listen. Dette vil inkludere de
        objektene som er av Person sine barneklasser. Merk likevel at vi bare har tilgang Person-funksjonalitet når
        vi benytter dette som datatype på referansen(e). Hvis vi vil benytte barneklassefunksjonalitet må vi gjøre noe
        mer. Dette kommer i neste forelesning...
         */
        for (Person personX : listOfPersons) {
            System.out.println(personX);
            System.out.println();
        }
    }
}
