package no.hiof.oleedvao.zooregister;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
import no.hiof.oleedvao.zooregister.controller.ZooController;
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

        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.staticFiles.enableWebjars();
            javalinConfig.vue.vueInstanceNameInJs = "app";
        }).start();

        ZooRepository zooRepository = new ZooDataRepository();
        /*
        Vi oppretter her et objekt av en ZooController. Dette objektet er det vi nå vil benytte for å utføre logikk i
        applikasjonen, altså typisk ved API kall. Ved å benytte dette objektet unngår vi altså å skrive
        logikk direkte i Application-klassen slik at Application bare er en konfigurasjon av webapplikasjonen.
        Det er typisk lurt å gjøre slike typer "ansvarsskille" i større applikasjoner.
        Merk at vi sender med zooRepository via konstruktør slik at controlleren vil benytte denne for å håndere
        dataene i systemet, slik vi i tidligere forelesninger har gjort direkte i Application-klassen.
         */
        ZooController zooController = new ZooController(zooRepository);

        // --- API ---
        /*
        Vi har her definert et API-endepunkt for å legge til en ny dyrepark. Merk at denne er definert med app.post()
        i stedet for app.get(). Dette betyr at endepunktet bare tar imot POST-forespørsler, som er
        litt forskjellig fra GET-forespørsler. Spesifikt; GET-forespørsler sender med data som path-parameter, altså
        via URL'en, mens POST-forespørsler sender med data som parametere som er "gjemt" inne i forespørselen og kalles
        form-parametere. Så lenge vi vet hva form-parameterene heter kan vi hente dem ut med Context sin
        .formParam()-metode. Form-parameterene blir definert i frontend. Se eventuelt add-zoo.vue for hvordan dette
        blir gjort.
        En tommelfingerregel for bruk av GET vs. POST er: Hvis du bare skal hente data eller en side, bruk GET, hvis
        du skal gjøre noe annet eller mer, for eksempel opprette date, endre data, slette data eller lignende, bruk
        POST.
         */
        app.post("/api/add-zoo", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Vi kaller her ZooController sin metode addZoo() for å utføre API-logikken for dette kallet.
                Se metodedefinisjonen for denne for å se logikken.
                 */
                zooController.addZoo(context);
            }
        });

        app.get("/api/zoo/{zoo-name}", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Vi kaller her ZooController sin metode addZooByName() for å utføre API-logikken for dette kallet.
                Se metodedefinisjonen for denne for å se logikken.
                 */
                zooController.getZooByName(context);
            }
        });

        app.get("/api/all-zoos", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Vi kaller her ZooController sin metode getAllZoos() for å utføre API-logikken for dette kallet.
                Se metodedefinisjonen for denne for å se logikken.
                 */
                zooController.getAllZoos(context);
            }
        });

        app.get("/api/mascot", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Vi kaller her ZooController sin metode getAllZoos() for å utføre API-logikken for dette kallet.
                Se metodedefinisjonen for denne for å se logikken.
                 */
                zooController.getMascot(context);
            }
        });


        // --- Pages ---
        /*
        Binder opp siden for å legge til en ny dyrepark.
         */
        app.get("/add-zoo", new VueComponent("add-zoo"));

        app.get("/", new VueComponent("home-page"));

        app.get("/all-zoos", new VueComponent("zoos-overview"));

        app.get("/zoo/{zoo-name}", new VueComponent("zoo-detail"));

        app.get("/other-page", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {

                context.result("Hello from the other page!");
            }
        });

    }
}
