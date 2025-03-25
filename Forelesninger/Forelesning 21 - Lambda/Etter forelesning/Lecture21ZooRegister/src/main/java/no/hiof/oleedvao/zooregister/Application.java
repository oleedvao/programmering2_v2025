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
        ZooController zooController = new ZooController(zooRepository);

        // --- API ---
        /*
        I tidligere forelesninger har vi benyttet anonyme indre klasser for å opprette Handler-logikk for
        API-endepunktene (1):

        1:
        app.post("/api/add-zoo", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                zooController.addZoo(context);
            }
        });

        Et mer smidig alternativ for dette er å benytte lambda-uttrykk (2 eller 3):

        2:
        app.post("/api/add-zoo", context -> {
            zooController.addZoo(context);
        });

        3:
        app.post("/api/add-zoo", context -> zooController.addZoo(context));

        Et lambda-uttrykk er basert på et funksjonelt interface (et interface med bare én abstrakt metode) og kan
        tenkes på som en implementasjon av interfacets éne metode hvor vi bare definerer det vi må; hva vi kaller
        parameterene tilmetoden og hva vi skal gjøre med dem. Resten, slik som metodens returtype, navn og datatyper
        for parametere er underforstått ut ifra interfacet.
        Handler er altså et funksjonelt interface med en metode kalt handle av typen void, og som tar et objekt av
        Context som parameter. Vi fokuserer altså på hva vi skal kalle Context-objektet, her context, og hva vi skal
        gjøre med det, her kalle ZooController sin addZoo()-metode med dette objektet.

        En enda smidigere teknikk er å benytte en metode-referanse. Dette er noe vi kan gjøre hvis vi allerede har en
        eksisterende metode som fyller alle kravene til det funksjonelle interfacet sin metode (returtype void, og
        tar et Context-objekt som parameter). Dette er tilfellet for alle metodene i ZooController, så vi kan egentlig
        si at en av disse metode-implementasjonene skal benyttes. Det under er et eksempel på en slik metode-referanse:
         */
        app.post("/api/add-zoo", zooController::addZoo);

        /*
        app.get("/api/zoo/{zoo-name}", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                zooController.getZooByName(context);
            }
        });

        app.get("/api/zoo/{zoo-name}", context -> zooController.getZooByName(context));
         */
        app.get("/api/zoo/{zoo-name}", zooController::getZooByName);

        /*
        app.get("/api/all-zoos", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                zooController.getAllZoos(context);
            }
        });

        app.get("/api/all-zoos", context -> zooController.getAllZoos(context));
         */
        app.get("/api/all-zoos", zooController::getAllZoos);

        /*
        app.get("/api/mascot", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                zooController.getMascot(context);
            }
        });

        app.get("/api/mascot", context -> zooController.getMascot(context));
         */
        app.get("/api/mascot", zooController::getMascot);


        // --- Pages ---
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
