package no.hiof.oleedvao.forelesning10;

import no.hiof.oleedvao.forelesning10.model.BussDriver;
import no.hiof.oleedvao.forelesning10.model.Carpenter;
import no.hiof.oleedvao.forelesning10.model.CarpenterApprentice;
import no.hiof.oleedvao.forelesning10.model.Person;

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

        person.compareAgeTo(person);
        person.compareAgeTo(bussDriver);
        person.compareAgeTo(carpenter);
        person.compareAgeTo(apprentice);

        System.out.println();
        carpenter.compareAgeTo(bussDriver);
        carpenter.compareAgeTo(apprentice);

        System.out.println("\n---List of Persons (Polymorphism)---");
        ArrayList<Person> listOfPersons = new ArrayList<>();
        listOfPersons.add(person);
        listOfPersons.add(bussDriver);
        listOfPersons.add(carpenter);
        listOfPersons.add(apprentice);

        for (Person personX : listOfPersons) {

            /*
            Vi kan sjekke om et objekt er av en spesifikk type klasse ved bruk av nøkkelordet instanceof, som
            returnerer true hvis objektet er av den spesifiserte klassen og false hvis ikke.
            Vi kan altså benytte dette til å definere unik logikk for håndtering av de forskjellige typene objekter.
             */
            if (personX instanceof BussDriver) {
                /*
                På grunn av polymorfi vil Java fremdeles tolke personX som et objekt av Person og funksjonaliteten
                tilgjengelig gjennom denne variabelen vil fortsatt være begrenset til Person-funksjonalitet.
                Hvis vi ønsker å benytte spesifikk funksjonalitet for BussDriver, slik som
                getRoute() og setRoute(), må vi dermed fortelle Java at objektvariabelen skal
                spesifikt tolkes som et BussDriver-objekt. Dette gjør vi med Object Type Casting.
                Altså som vi kan se under Type Caster vi personX til å tolkes som et BussDriver-object
                med koden ((BussDriver) personX), og vi kan kalle funksjonalitet tilhørende
                gjennom den ytre parantesen. Den ytre parantesen blir altså et objekt.
                 */
                System.out.println(personX.getFirstName() + " " + personX.getLastName() +
                        " is a BussDriver and has route " + ((BussDriver) personX).getRoute());
            }
            /*
            Merk også at vi må først lage if-tester for barneklassene for å forsikre oss om at disse blir håndtert.
            Dette er fordi alle barneklasse-objekter er også objekter av den foreldreklasser, så f.eks. hvis vi i
            stedet sjekker slik...:

                if (personX instanceof Carpenter {...}
                else if (personX instanceof CarpenterApprentice {...}

            ... vil alle CarpenterApprentice-objekter bare bli håndtert som Carpenter, ettersom dette blir sjekket
            først.

            Altså som en tommelfingerregel: Definer if-tester for
            underklasser først, så for mer generelle overklasser.
             */
            else if (personX instanceof CarpenterApprentice) {
                System.out.println(personX.getFirstName() + " " + personX.getLastName() +
                        " is a CarpenterApprentice and starts training: " +
                        ((CarpenterApprentice) personX).getTrainingStartDate());
            }
            else if (personX instanceof Carpenter) {
                System.out.println(personX.getFirstName() + " " + personX.getLastName() +
                        " is a Carpenter and has built " +
                        ((Carpenter)personX).getNumHousesBuilt() + " houses.");
            }
            else {
                System.out.println(personX.getFirstName() + " " + personX.getLastName() +
                        " is a Person.");
            }


        }
    }
}
