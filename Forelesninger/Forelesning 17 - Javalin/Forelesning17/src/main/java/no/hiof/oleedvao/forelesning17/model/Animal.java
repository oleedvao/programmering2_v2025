package no.hiof.oleedvao.forelesning17.model;

import java.time.LocalDate;

/*
Klasse for å representere dyr.
 */
public abstract class Animal {

    private final int id;
    private String name;
    private LocalDate birthDate;
    /*
    Vi legger her til en egen instansvariabel for dyreart. Dette kan virke litt redundandt da navnet på barneklasser
    egentlig allerede inneholder denne informasjonen. Grunnen til at det kan være fornuftig å ha en egen
    instansvariabel for arten er at frontenden ikke kan tyde slikt som klasse-navn uten videre når vi skal presentere
    dyrene senere.
     */
    protected String species;

    private static int numAnimals = 0;

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;

        numAnimals++;
        this.id = 1000 + numAnimals; // Benytter en statisk teller for å generere en unik id per dyr opprettet.
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
