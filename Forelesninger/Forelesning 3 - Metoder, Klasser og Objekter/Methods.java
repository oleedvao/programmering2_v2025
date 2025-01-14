public class Methods {

    /*
    Vi kan se at main metoden er en void-metode, som betyr at det ikke returneres noen verdi.
    Vi kan også se at den har en parameter i form av en String-array (String[] args). Denne parameteren er litt
    spesielle i den forstand at den får sine inneholdte verdier fra utsiden av programmet. Vanligvis kan disse
    argumentene sendes med når programmet kjøres fra en terminal, mens i IntelliJ IDEA kan vi opprette en konfigurasjon
    og sende med argumenter der. Det er imidlertid ytterst skjeldent vi benytter String[] args i praksis.
     */
    public static void main(String[] args) {

        /*
        Når vi kaller en metode vil Java vite hva metoden skal returnere (her boolean) og vil kontrollere at verdier
        som sendes med via parametere stemmer med hva som forventes (her int)
         */
        boolean result = ageIsLegal(20);
        System.out.println("20 is a legal age: " + result);

        boolean result2 = ageIsLegal(15);
        System.out.println("15 is a legal age: " + result2);


        //---void method---
        System.out.println("\n---Void method---");

        /*
        Void-metoder returnerer ingen verdi og kan kalles for seg selv uten å ta imot noe.
         */
        countTo(11);


        System.out.println("\n---main args---");

        /*
        Vi kan hente ut argumenter fra String[] args ved bruk av indexer. Merk at dette kan medføre feil hvis
        antallet argumenter er lavere enn hva vi forventer (ArrayIndexOutOfBoundsException). Dette understreker igjen
        at String[] args typisk ikke benyttes i praksis.
         */
        System.out.println(args[0] + " " + args[1]);

    }

    /*
    En metode som sjekker om en gitt alder er myndig.

    Ikke tenk så mye på hva public og static betyr for nå utenom at static er nødvendig hvis vi skal kjøre metoden
    direkte i en main-metode.
    Merk imidlertid at det er påkrevd å spesifisere datatypen på hva metoden skal returnere, her boolean. Navnet kan
    være hva vi vil. Vi kan også definere så mange parametere vi ønsker innenfor (), men merk at alle parametere må
    være definert med en datatype.
    Hvis returtype ikke er riktig eller metoden kalles med feil type verdier i parameterene vil ikke Java kompliere
    eller kjøre.
     */
    public static boolean ageIsLegal(int age) {
        if (age >= 18) {
            return true;
        }
        return false;
    }

    /*
    En metode som skriver ut tall fra 1 til og med tallet spesifisert som parameter.

    Ikke tenk så mye på hva public og static betyr for nå utenom at static er nødvendig hvis vi skal kjøre metoden
    direkte i en main-metode.
    Merk at når en metode ikke skal returnere noe, benytter vi void som datatype. Java vil da kontrollere at det ikke
    returneres noen verdi. void passer bra for metoder som dette, som bare skriver noe ut uten å returnere noe.
     */
    public static void countTo(int number) {
        for (int x = 1; x <= number; x++) {
            System.out.println(x);
        }
    }
}
