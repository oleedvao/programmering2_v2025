package no.hiof.oleedvao.forelesning10;

import no.hiof.oleedvao.forelesning10.model.Carpenter;
import no.hiof.oleedvao.forelesning10.model.Person;

import java.time.LocalDate;

public class UsingStatic {
    public static void main(String[] args) {

        /*
        Statiske variabler benyttes for variabler som ikke skal ha unike verdier per objekt, altså variabler som ikke
        skal være instansvariabler. Vi sier da konseptuelt at slike statiske variabler tilhører klassen selv, og
        ikke objektene av klassen.

        For å aksessere en statisk variabel referer vi til dette direkte gjennom klassen (klassen navn)
        Merk også at det kommenterte eksemplet under er basert på at den statiske variabelen er deklarert som public.
        Dette er fremdeles "bad practise" i Java og vi bør heller benytte innkapsling.

            Person.numPersons = 10;
            System.out.println(Person.numPersons);

         */

        /*
        Under benyttes en statisk metode getNumPersons() for å hente ut verdien av den statiske variablen.
        Her bør vi også kalle denne direkte gjennom Klassen.
         */
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

        /*
        Merk at vi også teknisk sett kan aksessere statiske metoder og variabler gjennom objekter, men dette er typisk
        ansett som feil å gjøre da disse variablene og metodene ikke "tilhører" objektene. Men vi kan her gjøre dette
        for å illustrere at verdien for den statiske variabelen numPersons er den samme uansett hvilket objekt.
         */
        System.out.println("Ola call: " + ola.getNumPersons());
        System.out.println("Rudolf call: " + rudolf.getNumPersons());

        /*
        Vi kan også se eksempler på ferdiglagde klasser, slik som LocalDate, som benytter statiske metoder for å
        opprette objekter. Å gjøre det på denne måten er litt spesielt, men det viktigste er at vi ser at disse metodene
        aksesseres direkte gjennom klassen.
         */
        LocalDate now = LocalDate.now();



    }
}
