package no.hiof.oleedvao.zooregister;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.vue.VueComponent;
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

        /*
        Vi konfigurerer her Javalin slik at den støtter bruken av Vue ved å "skru på" web-jars og gi Vue-applikasjonen
        et navn. Ikke tenk så mye på syntaksen, dette kan i praksis kopieres for alle Javalin-prosjekter hvor vi
        ønsker å benytte Vue.

        Merk også at vi må ha lagt til org.webjars.npm.vue som en dependency i pom.xml for å benytte Vue.
         */
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.staticFiles.enableWebjars();
            javalinConfig.vue.vueInstanceNameInJs = "app";
        }).start();

        ZooRepository zooRepository = new ZooDataRepository();

        // --- API ---
        /*
        Vi har her fullført API-endepunktet for å hente ut en spesifikk dyrepark basert på navn.
         */
        app.get("/api/zoo/{zoo-name}", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Vi henter først ut dyrepark-navnet fra path-parameteren
                 */
                String zooName = context.pathParam("zoo-name");

                /*
                Vi henter deretter ut den gjeldende dyreparken fra repository'et basert på navn. Merk at dette krever
                at repositoriet har en metode for dette. Finnes ikke dette legger vi det til ved å først oppdatere
                ZooRepository-interfacet med den nye metoden og implementere denne i de klassene som implementerer
                ZooRepository, altså ZooDataRepository her.
                 */
                Zoo fetchedZoo = zooRepository.getZooByName(zooName);

                /*
                Vi gjør her en liten feilhåndtering ved at vi sjekker om objektet som returneres faktisk finnes.
                Hvis objektet ikke er null, vet vi at det eksisterer, mens hvis det er null bør vi gi en tilbakemelding
                om at objektet ikke ble funnet.
                 */
                if (fetchedZoo != null) {
                    context.json(fetchedZoo);
                }
                else {
                    context.result("Could not find the zoo " + zooName);
                }
            }
        });

        app.get("/api/all-zoos", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.json(zooRepository.getAllZoos());
            }
        });

        app.get("/api/mascot", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                context.json(zooRepository.getMascot());
            }
        });


        // --- Pages ---
        /*
        Vi binder her opp forskjellige endepunkter som skal representere sider opp mot Vue-komponenter. Disse
        Vue-komponentene ligger under mappen "src/main/resources/vue". Merk at strukturen under "vue"-mappen bør være:

        - "vue"-mappe
            - layout.html
            - "view"-mappe
                - Et vilkårlig antall Vue-komponenter (.vue-filer)

        Men det viktigste er at layout.html ligger direkte under "vue"-mappen, og at Vue-komponentene ligger enten
        direkte under "vue"-mappen eller i en undermappe av denne. Er ikke dette tilfellet vil ikke Vue-komponentene
        laste.

        En annen ting som er viktig å bemerke er at Vue-komponentene er veldig følsomme til forskjeller i variabelnavn
        altså hvis du har navngitt instansvariabler forskjellig fra det Vue-komponentene forventer vil den ikke finne
        disse dataene. Inspiser altså
         */

        /*
        Laster home-page.vue: En statisk definert velkomstside
         */
        app.get("/", new VueComponent("home-page"));

        /*
        Laster zoos-overview.vue: En oversiktside over alle dyreparkene i systemet. Merk at denne Vue-komponenten
        internt benytter API-endepunktet "/api/all-zoos" for å hente dataene den presenterer.
         */
        app.get("/all-zoos", new VueComponent("zoos-overview"));

        /*
        Laster zoos-detail.vue: En detaljside om en dyrepark som vi spesifiserer vet et navn gjennom path-parameter.
        Mark at Vue-komponenten her intern først vil hente ut verdien i path-parameter og så kalle API-endepunktet
        "/api/zoo/{zoo-name}", hvor zoo-name er det hentet ut fra path-parameteren, for å hente dataene den presenterer.
         */
        app.get("/zoo/{zoo-name}", new VueComponent("zoo-detail"));

        app.get("/other-page", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {

                context.result("Hello from the other page!");
            }
        });

    }
}
