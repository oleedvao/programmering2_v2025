package no.hiof.oleedvao.forelesning10.model;

public class Person {

    /*
    En statisk variabel kan tenkes å tilhøre klassen selv og inneholder alltid den samme verdien for alle objekter.
    Altså skiller statiske variabler seg fra instansvariabler, hvor verdiene i motsetning er unike per objekt.
    Med andre ord, hvis vi eventuelt endrer på verdien for en statisk variabel gjennom et objekt, vil verdien
    samtidig endre seg for alle andre objekter. Igjen, den statiske variabelen er tilhørende klassen som en helhet.

    Under er det definert opp en statisk variabel som skal kunne holde på en oversikt over hvor mange objekter
    av klassen som er blitt opprettet i programmet, og skal oppdateres hver gang ett objekt opprettes.
     */
    private static int numPersons = 0;

    /*
    Hvis vi (humoristisk sett) skulle modelert personer ut ifra kristen religion kunne det vært naturlig å benytte en
    statisk variabel for å holde på Gud (som er den samme og er delt mellom alle personer). Men igjen, dette eksemplet
    er ikke ment som noe seriøst.
     */
    private static Person god = new Person("God", "Almighty", Integer.MAX_VALUE);

    protected String firstName;
    protected String lastName;
    protected int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        numPersons++;
    }

    public static int getNumPersons() {
        return numPersons;
    }

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
