package no.hiof.oleedvao.forelesning10.model;


public class Carpenter extends Person {

    private int numHousesBuilt;

    public Carpenter(String firstName, String lastName, int age,
                     int numHousesBuilt) {
        super(firstName, lastName, age);

        this.numHousesBuilt = numHousesBuilt;
    }

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
