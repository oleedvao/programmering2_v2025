package no.hiof.oleedvao.forelesning15csv;

import no.hiof.oleedvao.forelesning15csv.model.SuperHero;

import java.io.*;
import java.util.ArrayList;

public class CSVMain {
    public static void main(String[] args) {
        SuperHero batman = new SuperHero("Batman", "Bruce Wayne");
        SuperHero wolverine = new SuperHero("Wolverine", "Logan");
        SuperHero wonderWoman = new SuperHero("Wonder Woman", "Diana Prince");

        ArrayList<SuperHero> superHeroes = new ArrayList<>();
        superHeroes.add(batman);
        superHeroes.add(wolverine);
        superHeroes.add(wonderWoman);

        File csvFile = new File("superheroes.csv");

        /*
        Skriver SuperHero-objekter til en fil i CSV-format
         */
        writeSuperHeroesToCSV(superHeroes, csvFile);

        /*
        Henter SuperHero-objektene fra CSV-fil og skriver ut en beskrivelse for hver av disse. Dette er altså vanlige
        SuperHero-objekter som vi kan gjøre operasjoner på. Dette understreker også styrken ved å lagre objekter i
        tekstfiler. Altså at vi kan lagre objekter på tvers av kjøringer og eventuelt overføre disse til andre maskiner
        eller systemer.
         */
        ArrayList<SuperHero> superHeroesFromCSV = readSuperHeroesFromCSV(csvFile);
        for (SuperHero superHeroX : superHeroesFromCSV) {
            System.out.println(superHeroX);
        }
    }

    /*
    Metode for å lese SuperHero-objekter fra en csv-fil og returnere disse inneholdt i en ArrayList.
     */
    public static ArrayList<SuperHero> readSuperHeroesFromCSV(File file) {
        // Oppretter listen som skal fylles med SuperHero-objekter
        ArrayList<SuperHero> fetchedSuperHeroes = new ArrayList<>();

        /*
        Vi benytter her buffered reader for å lese fra filen. Denne hjelper med å lese hele linjer
        av gangen.
         */
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            /*
            Leser innholdet av filen linje for linje
             */
            String line;
            while( (line = bufferedReader.readLine()) != null) {

                /*
                Hver linje i CSV-filen representerer et SuperHero objekt ved at de individuelle verdiene som utgjør
                objektet er skilt med et skilletegn (her ;). Det vil si at hvis vi vil hente ut de individuellle
                verdiene må vi splitte linjen basert på skilletegnet. Dette kan vi gjøre ved bruk av String, sin
                .split()-metode. Denne vil så returnere de individuelle verdiene som en String-array.
                 */
                String[] values = line.split(";");

                /*
                Vi kan nå hente ut de individuelle verdiene fra String-arrayen basert på posisjon/index.
                 */
                String name = values[0];
                String secretIdentity = values[1];

                /*
                Deretter kan vi benytte verdiene inneholdt i linjen til å opprette et SuperHero-objekt på vanlig måte
                med konstruktør og legge til dette objektet i listen som skal returneres.
                 */
                SuperHero superHero = new SuperHero(name, secretIdentity);
                fetchedSuperHeroes.add(superHero);
            }
        }
        catch (FileNotFoundException exception) {
            System.err.println(exception.getMessage());
        }
        catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        // Returnerer listen med SuperHeroes som ble hentet fra CSV-fil.
        return fetchedSuperHeroes;
    }

    /*
    Metode for å skrive SuperHero-objekter til fil i CSV-format
     */
    public static void writeSuperHeroesToCSV(ArrayList<SuperHero> listOfSuperHeroes, File file) {
        /*
        Vi benytter her BufferedWriter for å skrive. Denne kan hjelpe med enkelte operasjoner, slik som linjeskift.
         */
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));) {

            /*
            Skriver hvert SuperHero-objekt i listen mottatt som parameter til fil i CSV-format
             */
            for (SuperHero superHeroX : listOfSuperHeroes) {

                String name = superHeroX.getName();
                String secretIdentity = superHeroX.getSecretIdentitiy();

                /*
                Vi skriver her de individuelle verdiene som utgjør SuperHero-objektet til filen og skiller dem med ;.
                Dette er altså CSV-format. Vi velger i utganspunktet skilletegnet selv, men det er viktig å velge et
                skilletegn som er unikt fra verdiene som lagres, og det er viktig at vi benytter samme skilleteng for
                alle linjer.
                 */
                bufferedWriter.write(name + ";" + secretIdentity);
                bufferedWriter.newLine(); // Lager linjeskift
            }
        }
        catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

    }
}
