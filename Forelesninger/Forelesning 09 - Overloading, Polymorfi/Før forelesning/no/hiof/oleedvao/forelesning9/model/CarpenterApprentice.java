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
