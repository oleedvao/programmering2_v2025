package no.hiof.oleedvao.zooregister.model;

import java.util.ArrayList;

public class Zoo {

    private String name;
    private ArrayList<Animal> animals = new ArrayList<>();

    public Zoo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
}
