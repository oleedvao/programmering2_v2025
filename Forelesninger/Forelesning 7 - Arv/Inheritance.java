package no.hiof.oleedvao.forelesning7;

import no.hiof.oleedvao.forelesning7.model.BussDriver;
import no.hiof.oleedvao.forelesning7.model.Carpenter;
import no.hiof.oleedvao.forelesning7.model.Person;

public class Inheritance {
    public static void main(String[] args) {

        // Opprettelse av et Person-objekt. Dette fungerer som vi er vant til fra før.
        Person person = new Person("Ola", "Nordmann", 20);
        System.out.println("Person: " + person.getFirstName() + " " + person.getLastName());

        /*
        Her oppretter vi et objekt av Carpenter. Merk at konstruktøren her tar verdier for firstName, lastName og
        age, i tillegg til numHousesBuilt.
         */
        Carpenter carpenter = new Carpenter("Rudolf", "Arnesen", 45, 3);
        /*
        Ettersom Carpenter-klassen aver fra Person har tilgang til all funksjonalitet vi vanligvis har
        i Person-objekter og verdiene for instansvariablene arvet fra Person har blitt satt av konstruktøren over.
         */
        System.out.println("Carpenter: " + carpenter.getFirstName() + " " + carpenter.getLastName());
        /*
        I tillegg til funksjonalitet som er arvet har vi selvfølgelig også tilgang til det som er unikt for denne
        klassen, altså det relatert til numHousesBuilt.
         */
        System.out.println("Carpenter has built " + carpenter.getNumHousesBuilt() + " houses.");

        /*
        Vi kan også endre på instansvariabler med settere som vanlig, inkludert de som er arvet.
         */
        carpenter.setFirstName("Noldus");
        carpenter.setLastName("Gnoldus");
        System.out.println("Carpenter: " + carpenter.getFirstName() + " " + carpenter.getLastName());

        /*
        Arv forholdet går bare en vei. Carpenter arver fra Person og vil dermed også få Person sine egenskaper, men
        Person vil ikke få noen av egenskapene definert sine barne-klasser. Linjen under er derfor ikke gyldig og vil
        føre til en kompileringsfeil.
         */
        //person.getNumHousesBuilt()

        /*
        Opprettelse av BussDriver-objekter, som også arver fra Person, er noe likt som ved Carpenter (firstName,
        , lastName og age), men skiller seg med en unik fjerde paramter, route.
         */
        BussDriver bussDriver = new BussDriver("Bjarne", "Bo", 55, "630 - Moss, Halden");
        /*
        Som med Carpenter har vi tilgang til alt et Person-objekt ville hatt, i tillegg til funksjonalitet rundt
        sin unike instansvariabel. Merk også at Carpenter- og BussDriver-objekter har ikke tilgang på hverandres
        unike instansvariabler og Person-objekter har heller ikke tilgang på disse. Arv er en enveisforhold
        hvor egenskaper arves fra foreldreklassen til barneklassen. Foreldreklassen vet ingenting om sine barne-klasser
        og barneklassene vet ingenting om hverandre.
         */
        System.out.println("Buss driver: " + bussDriver.getFirstName() + " " + bussDriver.getLastName());
        System.out.println("Buss driver has route " + bussDriver.getRoute());


        /*
        Se på hvordan metoden printDescription() er definert i Person. Ettersom både Carpenter og BussDriver arver
        fra Person, får alle barneklasser tilgang til denne metoden og dens funksjonalitet. En av hovedfordelene med å
        benytte arv er at vi kan gjenbruke funksjonalitet. Altså bare definere noe én gang, men gjenbruke det i andre
        klasser. Denne printDescription()-metoden ble definert i etterkant av at Carpenter og BussDriver ble definert
        og at disse arver fra Person. Likevel får begge tilgang til den nye metoden ved at vi definerer denne i
        foreldreklassen.
         */
        System.out.println("\n---Print description---");
        person.printDescription();

        System.out.println();
        carpenter.printDescription();

        System.out.println();
        bussDriver.printDescription();
    }
}
