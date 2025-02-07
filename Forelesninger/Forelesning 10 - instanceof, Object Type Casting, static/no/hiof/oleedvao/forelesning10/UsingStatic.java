package no.hiof.oleedvao.forelesning10;

import no.hiof.oleedvao.forelesning10.model.Carpenter;
import no.hiof.oleedvao.forelesning10.model.Person;

import java.time.LocalDate;

public class UsingStatic {
    public static void main(String[] args) {

        System.out.println("Number of persons created: " + Person.getNumPersons());

        Person ola = new Person("Ola", "Nordmann", 20);
        System.out.println("Number of persons created: " + Person.getNumPersons());

        Carpenter rudolf = new Carpenter("Rudolf", "Arnesen",
                45, 3);
        System.out.println("Number of persons created: " + Person.getNumPersons());

        Person ola2 = new Person("Ola", "Nordmann", 20);
        Person ola3 = new Person("Ola", "Nordmann", 20);
        Person ola4 = new Person("Ola", "Nordmann", 20);

        System.out.println("Number of persons created: " + Person.getNumPersons());

        System.out.println("Ola call: " + ola.getNumPersons());
        System.out.println("Rudolf call: " + rudolf.getNumPersons());

        LocalDate now = LocalDate.now();



    }
}
