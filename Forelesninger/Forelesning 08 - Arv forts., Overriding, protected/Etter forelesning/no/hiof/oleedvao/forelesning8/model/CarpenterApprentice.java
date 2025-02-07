package no.hiof.oleedvao.forelesning8.model;

import java.time.LocalDate;

/*
Denne klassen representerer konseptuelt en snekkerlærling.

Denne klassen arver fra Carpenter, som igjen arver fra Person. Altså er CarpenterApprentice her en barneklasse av
en annen barneklasse og vil arve alle egenskapene fra Carpenter, men også Person. Altså vil den arve alle egenskapene
fra alle Foreldre klassen over i arv-hierarkiet.
 */
public class CarpenterApprentice extends Carpenter{

    /*
    Vi benytter her en ferdiglaget klasse, LocalDate, for å representere start- og slutt-dato på lærlingens
    opplæringsperiode. Se den kjørbareklassen, Inheritence, for hvordan objekter av dette opprettes.
    Merk også at LocalDate må importeres fra java.time
     */
    private LocalDate trainingStartDate;
    private LocalDate trainingEndDate;

    /*
    Ettersom klassen arver fra Carpenter må CarpenterApprentice sin konstruktør minst ta parameterene som Carpenter
    sin konstruktør og sende disse opp til Carpenter via super().
     */
    public CarpenterApprentice(String firstName, String lastName, int age, int numHousesBuilt,
                               LocalDate trainingStartDate, LocalDate trainingEndDate) {
        super(firstName, lastName, age, numHousesBuilt);

        this.trainingStartDate = trainingStartDate;
        this.trainingEndDate = trainingEndDate;
    }

    /*
    Her overrider vi toString() på nytt slik at den tekslige representasjonen av CarpenterApprentice er mer
    tilpasset for dens egenskaper. Spesifikt trainingStartDate og trainingEndDate.
     */
    @Override
    public String toString() {
        /*
        Vi kan her se at vi til dels gjenbruker foreldreklassens toString() ved å kalle super.toString() og deretter
        legger på det som er unikt for denne klassen (trainingStartDate og trainingEndDate).
         */
        return super.toString() +
                "\nTraining period: " + trainingStartDate + " - " +
                trainingEndDate;
    }

    public LocalDate getTrainingStartDate() {
        return trainingStartDate;
    }

    public void setTrainingStartDate(LocalDate trainingStartDate) {
        this.trainingStartDate = trainingStartDate;
    }

    public LocalDate getTrainingEndDate() {
        return trainingEndDate;
    }

    public void setTrainingEndDate(LocalDate trainingEndDate) {
        this.trainingEndDate = trainingEndDate;
    }
}
