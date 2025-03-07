package no.hiof.oleedvao.forelesning16.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class SuperHero {
    private String name;
    private String secretIdentity;
    /*
    Liste med objekter. Dette gjør objekter av SuperHero mer komplekse enn det slikt som CSV er i stand til å
    håndtere på noen god måte. JSON på en annen side er fullstendig i stand til å oppbevare denne kompleksiteten.
     */
    private ArrayList<SuperHero> sidekicks = new ArrayList<>();
    /*
    LocalDate er en litt spesiell datatype for JSON-konvertering med ObjectMapper. Den er ikke støttet som standard
    og må legges til som en modul i ObjectMapper-objektet. Dette krever også at det legges til en dependency for
    com.fasterxml.jackson.datatype.jackson-datatype-jsr310
     */
    private LocalDate firstAppearance;

    /*
    JSON-konvertering med ObjectMapper krever at det må finnes en tom konstruktør av objektenes klasse.
    Dette er fordi ObjectMapper først oppretter et tomt objekt og fyller instansvariablene ved bruk av gettere og
    settere.
     */
    public SuperHero() {

    }

    public SuperHero(String name, String secretIdentity) {
        this.name = name;
        this.secretIdentity = secretIdentity;
    }

    public SuperHero(String name, String secretIdentity, LocalDate firstAppearance) {
        this.name = name;
        this.secretIdentity = secretIdentity;
        this.firstAppearance = firstAppearance;
    }

    @Override
    public String toString() {
        return "Superhero name: " + name + " - Secret identity: " + secretIdentity;
    }

    public LocalDate getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(LocalDate firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public ArrayList<SuperHero> getSidekicks() {
        return sidekicks;
    }

    public void setSidekicks(ArrayList<SuperHero> sidekicks) {
        this.sidekicks = sidekicks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }
}
