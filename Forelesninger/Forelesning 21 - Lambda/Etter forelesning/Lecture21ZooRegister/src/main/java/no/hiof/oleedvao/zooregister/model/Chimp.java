package no.hiof.oleedvao.zooregister.model;

import java.time.LocalDate;

public class Chimp extends Animal{

    private int iq;

    public Chimp(String name, LocalDate birthDate, int iq) {
        super(name, birthDate);
        this.species = "Chimp";

        this.iq = iq;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
