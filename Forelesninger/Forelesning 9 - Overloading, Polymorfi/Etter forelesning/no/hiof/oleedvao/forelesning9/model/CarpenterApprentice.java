package no.hiof.oleedvao.forelesning9.model;

import java.time.LocalDate;

public class CarpenterApprentice extends Carpenter{

    private LocalDate trainingStartDate;
    private LocalDate trainingEndDate;

    public CarpenterApprentice(String firstName, String lastName, int age, int numHousesBuilt,
                               LocalDate trainingStartDate, LocalDate trainingEndDate) {
        super(firstName, lastName, age, numHousesBuilt);

        this.trainingStartDate = trainingStartDate;
        this.trainingEndDate = trainingEndDate;
    }

    /* (Se Overloading.java for en generell forklaring av overloding.)
    Vi ser her en overloading av CarpenterApprentice sin konstruktør basert på at denne krever 3 parametere, mens
    konstruktøren over krever 4. Konseptuelt benytter vi overloading her for å tillate at vi kan opprette objekter av
    CarpenterApprentice på forskjellige måter
        Alt 1: sette alle egenskaper
        Alt 2: sette bare de mest essensielle egenskapene (firsnName, lastName, age)
     */
    public CarpenterApprentice(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    /* (Se Overloading.java for en generell forklaring av overloding.)
    Dette er et eksempel på en overloadet metode ettersom denne og metoden definert under denne har nøyaktig samme
    navn (extendTrainingPeriod()). Dette er ok ettersom parameterene på disse metodene er forskjellige. Spesifikt
    krever denne en LocalDate, mens den andre krever en int.
     */
    public void extendTrainingPeriod(LocalDate newEndDate) {
        /*
        Hvis den nye datoen er etter den originale overskriver vi den.
         */
        if (newEndDate.isAfter(trainingEndDate)) {
            trainingEndDate = newEndDate;
        }
    }

    /* (Se Overloading.java for en generell forklaring av overloding.)
    Dette er et eksempel på en overloadet metode ettersom denne og metoden definert over denne har nøyaktig samme
    navn (extendTrainingPeriod()). Dette er ok ettersom parameterene på disse metodene er forskjellige. Spesifikt
    krever denne en int, mens den andre krever en LocalDate.
     */
    public void extendTrainingPeriod(int daysToExtend) {
        trainingEndDate = trainingEndDate.plusDays(daysToExtend);
    }

    @Override
    public String toString() {
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
