package no.hiof.oleedvao.forelesning8.model;


public class Carpenter extends Person {

    private int numHousesBuilt;

    public Carpenter(String firstName, String lastName, int age,
                     int numHousesBuilt) {
        super(firstName, lastName, age);

        this.numHousesBuilt = numHousesBuilt;
    }

    // Her overrider vi toString() på nytt slik at den tekslige representasjonen av Carpenter er mer
    // tilpasset for dens egenskaper. Spesifikt num houses built.
    @Override
    public String toString() {
        /*
        Vi kan her se at vi til dels gjenbruker foreldreklassens toString() ved å kalle super.toString() og deretter
        legger på det som er unikt for denne klassen (numHousesBuilt).
         */
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
