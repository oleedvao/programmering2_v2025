package no.hiof.oleedvao.forelesning17.model;

import java.time.LocalDate;

/*
En klasse som representerer chimpanser.
 */
public class Chimp extends Animal{

    private int iq;

    public Chimp(String name, LocalDate birthDate, int iq) {
        super(name, birthDate);
        this.species = "Chimp"; // Vi lar Chimp klassen definere species på en standardisert måte.

        this.iq = iq;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
