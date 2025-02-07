package no.hiof.oleedvao.forelesning9.model;

public class Person {

    protected String firstName;
    protected String lastName;
    protected int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /*
    Denne metoden benytter Polymorfisme for å sammenligne the gjeldende Person-objektet med et hvilket som helst annet
    Person-objekt. På grunn av Polymorfisme innebærer dette også at parameteren, som skal ha et Person-objekt, godtar
    både Person-objekter, men også alle objekter av klasser som arver fra Person. Altså objekter av klassen selv
    eller objekter av barneklasser (direkte eller indirekte). Dette er nyttig fordi det tillater oss å håndtere
    mange forskjellige typer objekter på samme måte, i motsetning til å definere en egen slik metode for hvert type
    objekt. Merk likevel at når vi benytter en parmameter for Person-objekt vil vi i utgangspunktet bare kunne
    benytte funksjonalitet tilgjengelig i Person-klassen i koden. Altså må vi håndtere alle objekter som det skulle
    vært et direkte objekt av Person, selv om det egentlig kan være et objekt av en underklasse.
    Metoden under benyttes spesifikt til å sammenligne Person-objekter sine aldre.
     */
    public void compareAgeTo(Person otherPerson) {
        if (this.age > otherPerson.age) {
            System.out.println(this.firstName + " " + this.lastName + " is older.");
        }
        else if (this.age < otherPerson.age) {
            System.out.println(otherPerson.firstName + " " + otherPerson.lastName + " is older.");
        }
        else {
            System.out.println("The persons are the same age");
        }
    }

    @Override
    public String toString() {
        return "First name: " + firstName +
                "\nLast name: " + lastName +
                "\nAge: " + age;
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
