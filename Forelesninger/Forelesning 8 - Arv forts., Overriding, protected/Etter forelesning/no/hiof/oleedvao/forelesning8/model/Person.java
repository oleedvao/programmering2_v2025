package no.hiof.oleedvao.forelesning8.model;

public class Person {

    /*
    Merk at tilgangsmodifikatoren for instansvariablene er blitt endret fra private til protected.
    Dette gjør at disse variablene vil være direkte tilgjengelig i alle direkte og indirekte Barneklasser av
    Person, samt for klasser innenfor samme pakke, men vil ellers ikke være tilgjengelig utenfor arv-hierarkiet til
    Person. Altså vil innkapslingsprinsippet (for det meste) fremdeles gjelde utenfor dette og gettere og settere må i
    så fall benyttes.
     */
    protected String firstName;
    protected String lastName;
    protected int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /*
   Overriding er å omdefinere en arvet metode slik at den kan tilpasses den aktuelle klassen.
   Dette kan vi gjøre ved å definere den arvede metoden på nytt med samme datatype og navn. Vi kan også benytte
   @Override for å kontrollere at metoden overrides på riktig måte.

   Her overrider vi metoden toString(), som tilhører og er arvet fra Object-klassen. Alle klasser i Java arver
   underforstått fra denne Object-klassen.
   toString() benyttes til å få en tekstlig representasjon av et objekt, så når vi overrider toString() i en klasse
   kan vi konseptuelt si at vi tilpasser hvordan objekter av denne klassen skal bli representert i tekstlig format.
   Under benytter vi dette til å definere en generell beskrivelse av en "person".
   Merk også at alle Barneklasser av Person vil arve denne implementasjonen som utgangspunkt, med mindre de igjen
   overrider den (Noe som gjøres i samtlige barneklasser i dette eksemplet).
    */
    @Override
    public String toString() {
        return "First name: " + firstName +
                "\nLast name: " + lastName +
                "\nAge: " + age;
    }

    /*
    Etter å ha definert toString() kan vi set at en egen metode for å skrive ut beskrivelser er ganske unødvendig og
    vi kan dermed fjerne denne.

    public void printDescription() {
        System.out.println(
                "First name: " + firstName +
                "\nLast name: " + lastName +
                "\nAge: " + age);
    }
     */

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
