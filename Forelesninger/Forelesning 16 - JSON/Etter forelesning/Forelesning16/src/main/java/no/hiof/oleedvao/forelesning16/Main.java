package no.hiof.oleedvao.forelesning16;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import no.hiof.oleedvao.forelesning16.model.SuperHero;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        Oppretter de grunnleggende SuperHero-objektene vi skal skrive/lese til fil.
         */
        SuperHero batman = new SuperHero("Batman", "Bruce Wayne",
                LocalDate.of(1939, 3, 30));
        SuperHero wolverine = new SuperHero("Wolverine", "Logan",
                LocalDate.of(1974, 9, 1));
        SuperHero wonderWoman = new SuperHero("Wonder Woman", "Diana Prince",
                LocalDate.of(1941, 10, 21));

        /*
        Legger til noen sidekicks som en liste i superhelten, batman.
         */
        ArrayList<SuperHero> batmanSidekicks = new ArrayList<>();
        batmanSidekicks.add(new SuperHero("Robin", "Jason Todd"));
        batmanSidekicks.add(new SuperHero("Batgirl", "Barbara Gordon"));
        batman.setSidekicks(batmanSidekicks);

        /*
        Oppretter en liste med objektene som skal skrives til JSON-fil
         */
        ArrayList<SuperHero> superHeroes = new ArrayList<>();
        superHeroes.add(batman);
        superHeroes.add(wolverine);
        superHeroes.add(wonderWoman);


        File jsonFile = new File("superheroes.json");

        /*
        Skriver listen med superhelter til JSON-fil
         */
        writeSuperHeroesToJSON(superHeroes, jsonFile);

        /*
        Leser en liste med SuperHero-objekter fra JSON-fil og skriver ut en beskrivelse for hver av dem.
         */
        ArrayList<SuperHero> superHeroesFromJson = readSuperHeroesFromJSON(jsonFile);
        for (SuperHero superHeroX : superHeroesFromJson) {
            System.out.println(superHeroX);
            System.out.println("Sidekicks: " + superHeroX.getSidekicks());
            System.out.println("First Appearance: " + superHeroX.getFirstAppearance());
            System.out.println();
        }
    }

    /*
    Metode for å lese SuperHero-objekter fra JSON-fil og returnere disse som en ArrayList.
     */
    public static ArrayList<SuperHero> readSuperHeroesFromJSON(File file) {

        /*
        For å skrive til JSON-fil kan vi benytte klassen ObjectMapper. Merk imidlertid at for å kunne benytte denne
        klassen må vi ha lagt til com.fasterxml.jackson.core.jackson-databind som en dependency i pom.xml. Se pom.xml.
         */
        ObjectMapper objectMapper = new ObjectMapper();
        /*
        Hvis vi skal håndtere LocalDate som en del av objektene vi skal skrive/lese JSON må vi legge til JavaTimeModule
        som en modul i ObjectMapper. Vi kan gjøre dette ved bruk av .registerModule() direkte eller
        .findAndRegisterModules().
         */
        objectMapper.registerModule(new JavaTimeModule());
        //objectMapper.findAndRegisterModules();

        try {
            /*
            Når vi skal konvertere JSON til objekter må vi benytte .readValue(), som krever filen vi skal lese og
            hvilken klasse vi skal tolke innholdet som. Her må vi spesifisere SuperHero[].class for å si at vi skal
            tolke innholdet som en array med SuperHero objekter. Vi må først gjøre dette ettersom ObjectMapper ikke
            kan tolke inholdet som en ArrayList<SuperHero>.
             */
            SuperHero[] superHeroArray = objectMapper.readValue(file, SuperHero[].class);

            /*
            Etter å ha hentet ut arrayen med SuperHero-objekter kan vi konvertere denne arrayen til en ArrayList.
            Her returnerer vi ArrayList-en i samme handling.
             */
            return new ArrayList<>(Arrays.asList(superHeroArray));
        }
        catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        /*
        Hvis det skjer noe feil i lesingen, returnerer vi en tom-liste som standard.
         */
        return new ArrayList<>();
    }

    public static void writeSuperHeroesToJSON(ArrayList<SuperHero> listOfSuperHeroes,
                                              File file) {

        /*
        For å skrive til JSON-fil kan vi benytte klassen ObjectMapper. Merk imidlertid at for å kunne benytte denne
        klassen må vi ha lagt til com.fasterxml.jackson.core.jackson-databind som en dependency i pom.xml. Se pom.xml.
         */
        ObjectMapper objectMapper = new ObjectMapper();
        /*
        Hvis vi skal håndtere LocalDate som en del av objektene vi skal skrive/lese JSON må vi legge til JavaTimeModule
        som en modul i ObjectMapper. Vi kan gjøre dette ved bruk av .registerModule() direkte eller
        .findAndRegisterModules().
         */
        objectMapper.registerModule(new JavaTimeModule());
        //objectMapper.findAndRegisterModules();

        try {
            /*
            For å skrive objekter til JSON-fil kan vi benytte .writeValue(). Denne krever en fil den skal skrive til
            som første parameter og hva den skal skrive som andre parameter. Her skriver vi hele listen.
            Vi kan først kalle .writerWithDefaultPrettyPrinter() for å få en pen formatering av JSON-outputen med
            linjeskift og indentering.
             */
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, listOfSuperHeroes);
        }
        catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
