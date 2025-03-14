package no.hiof.oleedvao.zooregister.model;

import java.time.LocalDate;


public abstract class Animal {

    private final int id;
    private String name;
    private LocalDate birthDate;
    protected String species;

    private static int numAnimals = 0;

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;

        numAnimals++;
        this.id = 1000 + numAnimals;
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
