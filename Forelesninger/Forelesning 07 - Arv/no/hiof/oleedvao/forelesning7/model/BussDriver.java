package no.hiof.oleedvao.forelesning7.model;

/*
Som Carpenter, arver BussDriver fra Person. Mye er her felles, så les kommentarene i Carpenter for innsikt i
aspektene som inngår ved arv.
 */
public class BussDriver extends Person{

    /*
    Denne instansvariabelen er unik for BussDriver og representerer en bussrute. Gettere og settere er definert som
    tidligere og instansvariabelen initialiseres i konstruktøren.
     */
    private String route;

    public BussDriver(String firstName, String lastName, int age,
                      String route) {
        super(firstName, lastName, age);

        this.route = route;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
