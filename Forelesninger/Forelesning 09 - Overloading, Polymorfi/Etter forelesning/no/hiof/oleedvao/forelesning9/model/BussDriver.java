package no.hiof.oleedvao.forelesning9.model;


public class BussDriver extends Person{

    private String route;

    public BussDriver(String firstName, String lastName, int age,
                      String route) {
        super(firstName, lastName, age);

        this.route = route;
    }

    /* (Se Overloading.java for en generell forklaring av overloding.)
    Vi ser her en overloading av BussDriver sin konstruktør basert på at denne krever 3 parametere, mens konstruktøren
    over krever 4. Konseptuelt benytter vi overloading her for å tillate at vi kan opprette objekter av BussDriver på
    forskjellige måter
        Alt 1: sette alle egenskaper
        Alt 2: sette bare de mest essensielle egenskapene (firsnName, lastName, age)
     */
    public BussDriver(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "First name: " + firstName +
                "\nLast name: " + lastName +
                "\nAge: " + age +
                "\nRoute: " + route;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
