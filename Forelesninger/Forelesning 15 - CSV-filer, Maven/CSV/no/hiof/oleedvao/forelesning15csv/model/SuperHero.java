package no.hiof.oleedvao.forelesning15csv.model;

/*
Klasse som representerer superhelt som en datatype
 */
public class SuperHero {

    private String name;
    private String secretIdentitiy;

    public SuperHero(String name, String secretIdentitiy) {
        this.name = name;
        this.secretIdentitiy = secretIdentitiy;
    }

    @Override
    public String toString() {
        return "Superhero name: " + name + " - Secret identity: " + secretIdentitiy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretIdentitiy() {
        return secretIdentitiy;
    }

    public void setSecretIdentitiy(String secretIdentitiy) {
        this.secretIdentitiy = secretIdentitiy;
    }
}
