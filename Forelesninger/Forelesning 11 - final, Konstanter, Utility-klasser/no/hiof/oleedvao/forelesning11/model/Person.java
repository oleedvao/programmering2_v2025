package no.hiof.oleedvao.forelesning11.model;

import no.hiof.oleedvao.forelesning11.util.UnitConverter;

/*
Vi kan late som det vi gjør i denne klassen bygger på Person-klassen fra tidligere forelesninger, men for dette
eksemplet gjør vi dette isolert for å slippe følgefeil i slikt som barneklassene sine konstruktører.
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    /*
    Variabelen under er satt til final. Dette vil definere at variabelens verdi bare skal settes én gang.
    Dette vil også bli kontrollert av Java, både at vi ikke setter inn noen ny verdi og at den blir initialisert.
    Fordelen med å gjøre dette overfor å bare restrihere variabelens tilgang via gettere og settere er at vi da
    helt tydelig gir beskjed til Java og eventuelle andre programmerere om at denne variabelen ikke skal modifiseres.
    */
    private final String birthNumber;

    /*
    Hvis vi har en final variabel må disse enten initialiseres direkte ved deklarasjon, eller bli satt i samtlige
    av tilgjengelige konstruktører, enten via parameter eller som en del av kodekroppen.
    */
    public Person(String birthNumber) {
        this.birthNumber = birthNumber;
    }

    /*
    Hvis vi har en final variabel må disse enten initialiseres direkte ved deklarasjon, eller bli satt i samtlige
    av tilgjengelige konstruktører, enten via parameter eller som en del av kodekroppen.
    */
    public Person(String firstName, String lastName, int age, String birthNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthNumber = birthNumber;
    }

    /*
    Vi kan fint hente ut verdien for en final instansvariabel via gettere ...
     */
    public String getBirthNumber() {
        return birthNumber;
    }

    /*
    ... men vi kan ikke opprette eller benytte settere på final variabler ettersom Java ikke tillater at vi oppdaterer
    en final-variablers verdier etter de er blitt satt.

    public void setBirthNumber(String birthNumber) {
        this.birthNumber = birthNumber;
    }
     */


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
