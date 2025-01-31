package no.hiof.oleedvao.forelesning8;

import no.hiof.oleedvao.forelesning8.model.BussDriver;
import no.hiof.oleedvao.forelesning8.model.Carpenter;
import no.hiof.oleedvao.forelesning8.model.Person;

public class Inheritance {
    public static void main(String[] args) {


        Person person = new Person("Ola", "Nordmann", 20);
        System.out.println("Person: " + person.getFirstName() + " " + person.getLastName());


        Carpenter carpenter = new Carpenter("Rudolf", "Arnesen", 45, 3);

        System.out.println("Carpenter: " + carpenter.getFirstName() + " " + carpenter.getLastName());

        System.out.println("Carpenter has built " + carpenter.getNumHousesBuilt() + " houses.");


        carpenter.setFirstName("Noldus");
        carpenter.setLastName("Gnoldus");
        System.out.println("Carpenter: " + carpenter.getFirstName() + " " + carpenter.getLastName());

        BussDriver bussDriver = new BussDriver("Bjarne", "Bo", 55, "630 - Moss, Halden");

        System.out.println("Buss driver: " + bussDriver.getFirstName() + " " + bussDriver.getLastName());
        System.out.println("Buss driver has route " + bussDriver.getRoute());


        System.out.println("\n---Print description---");
        person.printDescription();

        System.out.println();
        carpenter.printDescription();

        System.out.println();
        bussDriver.printDescription();
    }
}
