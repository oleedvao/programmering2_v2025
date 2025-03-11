package no.hiof.oleedvao.forelesning17;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class Application {
    public static void main(String[] args) {

        /*
        Javalin er et rammeverk for å utvikle webapplikasjoner med Java og er overordnet basert på å definere
        sider (URL-er) i webapplikajonen og funksjonalitet for disse.

        Vi starter og definerer funksjonalitet for Javalin-applikasjoner gjennom et Javalin-objekt.
        Javalin-klassen importeres ved bruk av byggeverktøy. Se pom.xml og slides fra forelesning 17.
        Litt spesielt med denne klassen er at den benytter builder-pattern, som blant annet medfører at vi ikke
        benytter konstruktører for å opprette objektet, men i stedet kaller metoder etter hverandre.
         */
        Javalin app = Javalin.create().start();

        /*
        Det følgende er en håndtering av default-siden i applikasjonen. Vi benytter metoden .get() som tar to
        parametere. Første parameter er en String for siden, mens andre parameter er et objekt som må implementere
        Handler-interfacet. Her er det vanlig å definere objektet ved bruk av en anonym-klasse basert på
        Handler-interfacet. Dette betyr enkelt forklart at vi definerer objektets logikk samtidig som vi oppretter
        objektet i stedet for å definere en klasse i en egen fil og opprette objektet basert på denne, som vi
        vanligvis måtte gjort.
        Essensen er at det vi skriver inne i overriden av handle()-metoden er det som vil utføres når den definerte
        path-en blir besøkt/benyttet.
         */
        app.get("/", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Dette er det som vil bli utført når path-en "/" blir benyttet.
                 */
                context.result("Hello Javalin!");
            }
        });

        /*
        Dette er en unik håndtering for en annen side enn default-siden. Vi kan opprette så mange egendefinerte sider
        som vi ønsker.
         */
        app.get("/other-page", new Handler() {
            @Override
            public void handle(@NotNull Context context) throws Exception {
                /*
                Dette er det som vil bli utført når path-en "/other-page" blir benyttet.
                 */
                context.result("Hello from the other page!");
            }
        });

    }
}
