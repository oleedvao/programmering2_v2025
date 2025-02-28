package no.hiof.oleedvao.forelesning14;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        /*
        Dette oppretter et objekt som representerer en fil. Merk at denne ikke automatisk oppretter filen, men vi kan
        benytte dette objektet når vi skal håndtere denne filen senere.
         */
        File textFile = new File("textfile.txt");

        /*
        Vi kaller her metodene for å skrive og lese fil.
         */
        writeToFile(textFile);
        readFromFile(textFile);

        /*
        Merk at hvis vi forsøker å lese en fil som ikke eksisterer vil dette kaste en FileNotFoundException, som
        håndteres i en definert catch-blokk i readFromFile. Dette forsikrer at programmet ikke krasjer og
        feilsituasjonen håndteres på en fornuftig måte. Her blir bare en feilmelding skrevet ut, men i mer avanserte
        applikasjoner vil feilen ofte kommuniseres mer direkte til bruker gjennom et GUI.
         */
        File nonexistentfile = new File("blablabla");
        readFromFile(nonexistentfile);

    }

    /*
    Metode for å gjøre en enkel filskriving
     */
    public static void writeToFile(File file) {

        /*
        Dette er en try (with resources) block.
        Denne blokken inneholder kode vi som programmerere, samt Java, vet kan gi en eller flere Exceptions.
        Parantesen knyttet til try blokken, altså 'try (...)', spesifiserer de ressursene vi ønsker å benytte
        for try logikken. Disse ressursene vil automatisk lukkes etter try-blokken er ferdig eller en Exception
        har forekommet. Disse ressursene kan typisk være slikt som stream-objekter.
        Stream objektene vi benytter vil automatisk lokkes ettersom de er definert som ressurser for
        try-blokken.

        FileWriter er en type stream som hjelper oss å skrive til fil. Hvis vi spesifiserer append som
        true
                ... = new FileWriter(file, true);
        vil denne streamen legge til tekst til den gitte filen. Hvis false, eller ikke spesifisert,
        vil filen overskrives.
        Denne oppretter også filen automatisk hvis den ikke finnes fra før av. File-objektet representerer filen vi
        vil skrive til. Et alternativ er å skrive den tekstlige filstien som parameter.
            ... = new FileWriter("textfile.txt");
         */
        try (FileWriter fileWriter = new FileWriter(file)) {
            /*
            Vi kan benytte FileWriter sin .append()-metode for å spesifisere det som skal skrives til fil.
            Vi kan kalle .append() så mange ganger vi vil. Merk likevel at vi manuelt må legge til "\n" for å få
            linjeskift.
             */
            fileWriter.append("Programming is fun!\n");
            fileWriter.append("At least when I don't get errors...\n");
        }
        /*
        Dette er en catch-blokk.
        I denne kan vi spesifisere hva for slags type exception vi ønsker å håndtere (hvilket type Exception-objekt)
        og skrive kode logikk for hvordan vi ønsker å håndtere den.
        I dette tilfellet hånderer vi en IOException som er en checked exception som Java vil påkreve at vi håndterer
        når vi benytter FileWriter.
         */
        catch (IOException exception) {
            /*
            Vi hånderer en IOException i dette tilfellet ved å enkelt skrive ut en error melding til output.
             */
            System.err.println(exception.getMessage());
        }
    }

    /*
    Leser innholdet av en tekst-fil og skriver det ut til output
     */
    public static void readFromFile(File file) {

        /*
        Vi benytter her BufferedReader som en ressurs for å kunne lese innholdet av en fil linje for linje.
        Vi spesifiserer her at BufferedReader spesifikt skal benytte FileReader underliggende for å lese tegnene
        i en fil.
         */
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            /*
            Koden under er logikken for å lese hver linje hver for seg helt til hele filen er gjennomgått.
             */
            String line;
            /*
            Vi skriver her en litt snodig, men smidig while-løkke som i betingelsen både oppdaterer variabelen line
            med den neste linjen i filen og samtidig sjekker at denne linjen ikke er null. Altså vil denne
            while-løkken gjennomgå hver linje. En slik while løkke kan typisk gjenbrukes i alle tilfeller vi ønsker
            å gjøre dette.
             */
            while ( (line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        /*
        FileReader har en checked Exception kalt FileNotFoundException (underklasse av IOException) som må håndteres.
        Merk at exceptions håndteres i rekkefølgen som catch-blokkene er definert. Altså vil det først sjekkes
        om det er en FileNotFoundException før den eventuelt sjekker neste catch-blokk.
         */
        catch (FileNotFoundException exception) {
            System.err.println("Could not find file...");
        }
        /*
        Vi vil fremdeles være påkrevd å håndtere mer generelle former for IOExceptions i dette tilfellet.
         */
        catch (IOException exception) {
            System.err.println("Something went wrong!");
        }

    }


}
