package no.hiof.oleedvao.forelesning9;

import no.hiof.oleedvao.forelesning9.model.BussDriver;
import no.hiof.oleedvao.forelesning9.model.Carpenter;
import no.hiof.oleedvao.forelesning9.model.CarpenterApprentice;
import no.hiof.oleedvao.forelesning9.model.Person;

import java.time.LocalDate;

public class Main {
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
    }
}
