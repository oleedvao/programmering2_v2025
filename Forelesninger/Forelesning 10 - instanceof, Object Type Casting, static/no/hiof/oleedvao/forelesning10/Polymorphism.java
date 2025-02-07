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
            if (personX instanceof BussDriver) {
                System.out.println(personX.getFirstName() + " " + personX.getLastName() +
                        " is a BussDriver and has route " + ((BussDriver) personX).getRoute());
            }
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
