package no.hiof.oleedvao.forelesning8.model;


public class BussDriver extends Person{

    private String route;

    public BussDriver(String firstName, String lastName, int age,
                      String route) {
        super(firstName, lastName, age);

        this.route = route;
    }

    /*
    Her overrider vi toString() på nytt slik at den tekslige representasjonen av BussDriver er mer
    tilpasset for dens egenskaper. Spesifikt legger vi på informasjon om route. Merk at vi kan benytte
    */
    @Override
    public String toString() {
        /*
        Merk  at vi har dublisert håndteringen av firstName, lastName og age fra foreldreklassen, Person. Det finnes
        en smidigere måte å gjenbruke denne logikken på som du kan se eksempler på i Carpenter og CarpenterApprentice.
        Merk også at vi referer til foreledreklassens instansvariabler direkte. Dette er bare mulig fordi
        instansvariablene er definert som protected (Se Person-definisjonen). Hvis ikke vi benytter protected, må vi
        benytte gettere og settere.
         */
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
