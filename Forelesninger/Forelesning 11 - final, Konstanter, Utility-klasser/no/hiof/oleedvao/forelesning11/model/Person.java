package no.hiof.oleedvao.forelesning11.model;

import no.hiof.oleedvao.forelesning11.util.UnitConverter;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private final String birthNumber;

    public Person(String birthNumber) {
        this.birthNumber = birthNumber;
    }

    public Person(String firstName, String lastName, int age, String birthNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthNumber = birthNumber;
    }

    /*
    public void setBirthNumber(String birthNumber) {
        this.birthNumber = birthNumber;
    }
     */

    public String getBirthNumber() {
        return birthNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
