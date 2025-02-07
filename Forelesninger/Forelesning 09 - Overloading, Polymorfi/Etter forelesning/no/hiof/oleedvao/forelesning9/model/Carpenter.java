package no.hiof.oleedvao.forelesning9.model;


public class Carpenter extends Person {

    private int numHousesBuilt;

    public Carpenter(String firstName, String lastName, int age,
                     int numHousesBuilt) {
        super(firstName, lastName, age);

        this.numHousesBuilt = numHousesBuilt;
    }

    /* (Se Overloading.java for en generell forklaring av overloding.)
    Vi ser her en overloading av Carpenter sin konstruktør basert på at denne krever 3 parametere, mens konstruktøren
    over krever 4. Konseptuelt benytter vi overloading her for å tillate at vi kan opprette objekter av Carpenter på
    forskjellige måter
        Alt 1: sette alle egenskaper
        Alt 2: sette bare de mest essensielle egenskapene (firsnName, lastName, age)
     */
    public Carpenter(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nNum houses built: " + numHousesBuilt;
    }

    public int getNumHousesBuilt() {
        return numHousesBuilt;
    }

    public void setNumHousesBuilt(int numHousesBuilt) {
        this.numHousesBuilt = numHousesBuilt;
    }
}
