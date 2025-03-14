package no.hiof.oleedvao.zooregister;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import no.hiof.oleedvao.zooregister.model.Chimp;
import no.hiof.oleedvao.zooregister.model.HoneyBadger;
import no.hiof.oleedvao.zooregister.model.Panda;
import no.hiof.oleedvao.zooregister.model.Zoo;
import no.hiof.oleedvao.zooregister.repository.ZooDataRepository;
import no.hiof.oleedvao.zooregister.repository.ZooRepository;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start();

        /*
        Denne klassen representerer dataene våre og de handlingene vi kan gjøre på dataene. Merk at vi benytter
        polymorfisme for selve variabelen. Fordelen med dette er da at vi enkelt kan bytte ut implementasjonen av
        ZooRepository, altså det konkrete objektet, uten at dette påvirker bruken av objektet.
        For eksempel kunne vi gjort om til ...

            ZooRepository zooRepository = new ZooSQLDatabaseRepository();

        ... dersom vi hadde hatt dette som en alternativ implementasjon. Bruken av dette objektet hadde imidlertid ikke
        endret seg og vi hadde ikke trengt å endre noen andre linjer. Dette er altså et eksempel på løst koblet og
        modulær kode som er enkel å bytte ut senere.
         */
        ZooRepository zooRepository = new ZooDataRepository();

        // --- API ---
        /*
        Dette er en API-path med en parameter. En slik parameter fungerer mye likt som en parameter i en metode.
        Brukeren kan spesifisere en verdi og vi kan hente ut denne verdien når handlignen skal utføres.
         */
        app.get("/api/zoo/{zoo-name}", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Vi henter her ut verdien som brukeren har skrevet for parameteren og sender dette med som resultat.
                Altså hvis brukeren skriver "http://localhost:8080/api/zoo/Kristiansand" vil zooName inneholde
                verdien "Kristiansand"

                Se neste forelesning for hvordan slike parametere kan benyttes for å tilpasse handlingene som skal
                utføres.
                 */
                String zooName = context.pathParam("zoo-name");
                context.result(zooName);
            }
        });

        /*
        Dette er en API-path som returnerer alle Zoo-objektene i registeret.
         */
        app.get("/api/all-zoos", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Linjen under returnerer alle Zoo-objektene i JSON-format.
                Merk at dataene hentes ut fra ZooRepository'et definert lenger opp i klassen.
                Merk også at JSON-konverteringen krever at vi har jackson-databind som en avhengighet i pom.xml og
                også jackson-datatype-jsr310 ettersom Animal-objekter inneholder LocalDate-objekter. Resten av
                konverteringen er imidlertid håndtert for oss.
                 */
                context.json(zooRepository.getAllZoos());
            }
        });

        /*
        Dette er en API-path som returnerer registerets maskot i form at ett Animal-objekt.
         */
        app.get("/api/mascot", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Linjen under returnerer registerets maskot i JSON-format.
                Merk at dataene hentes ut fra ZooRepository'et definert lenger opp i klassen.
                Merk også at JSON-konverteringen krever at vi har jackson-databind som en avhengighet i pom.xml og
                også jackson-datatype-jsr310 ettersom Animal-objekter inneholder LocalDate-objekter. Resten av
                konverteringen er imidlertid håndtert for oss.
                 */
                context.json(zooRepository.getMascot());
            }
        });


        // --- Pages ---
        app.get("/", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {

                context.result("Hello Javalin!");
            }
        });

        app.get("/other-page", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {

                context.result("Hello from the other page!");
            }
        });

    }
}
