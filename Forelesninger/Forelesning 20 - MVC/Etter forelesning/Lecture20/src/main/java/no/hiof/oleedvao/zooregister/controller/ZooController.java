package no.hiof.oleedvao.zooregister.controller;

import io.javalin.http.Context;
import no.hiof.oleedvao.zooregister.model.Zoo;
import no.hiof.oleedvao.zooregister.repository.ZooRepository;

/*
Dette er en Controller-klasse, altså en klasse som er dedikert til å samle logikk mellom Views og Modell-klassene.
Å lage slike Controller-klasser er basert på Design Pattern'et MVC (Model View Controller) og er ganske konvensjonelt
å gjøre i mange typer applikasjoner.
 */
public class ZooController {

    /*
    Vi oppretter her en instansvariabel av ZooRepository. Merk at datatypen er av interfacet, slik at vi kan benytte
    polymorfisme til å være fleksibel på hvilken imlementasjon av ZooRepository som skal gjelde.
     */
    private ZooRepository zooRepository;

    public ZooController(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    /*
    API-logikk for å legge til en dyrepark. Se API-endepunktet for "/api/add-zoo" i Application-klassen for hvor denne
    benyttes i praksis.
     */
    public void addZoo(Context context) {
        // Vi henter her ut navnet på dyreparken via form-parameter. Form-parameter kan være hentes ut ved POST-kall.
        String zooName = context.formParam("zoo-name");

        // Vi benytter det uthentede navnet til å opprette en ny dyrepark.
        Zoo createdZoo = new Zoo(zooName);

        /*
        Vi legger til det nye Zoo-objektet i repository'et for å sørge for at objektet vil kunne hentes ved senere
        kall. Merk at siden vi i Application benytter ZooDataRepository, som er hardkodet, vil ikke objektet bli
        ivaretatt mellom kjøringer, men vil være tilgjengelig innenfor samme kjøring
         */
        zooRepository.addZoo(createdZoo);

        // Etter å ha opprettet objektet så redirigerer vi brukeren til detalj-siden for den nylig opprettede dyreparken
        context.redirect("/zoo/" + zooName);
    }

    /*
    API-logikk for å hente en dyrepark basert på navn. Se API-endepunktet "/api/zoo/{zoo-name}" i Application-klassen
    for hvor denne benyttes i praksis.
     */
    public void getZooByName(Context context) {
        String zooName = context.pathParam("zoo-name");

        Zoo fetchedZoo = zooRepository.getZooByName(zooName);

        if (fetchedZoo != null) {
            context.json(fetchedZoo);
        }
        else {
            context.result("Could not find the zoo " + zooName);
        }
    }

    /*
    API-logikk for å hente alle dyreparker. Se API-endepunktet "/api/all-zoos" i Application-klassen
    for hvor denne benyttes i praksis.
     */
    public void getAllZoos(Context context) {
        context.json(zooRepository.getAllZoos());
    }

    /*
    API-logikk for å hente systemets maskot. Se API-endepunktet "/api/mascot" i Application-klassen
    for hvor denne benyttes i praksis.
     */
    public void getMascot(Context context) {
        context.json(zooRepository.getMascot());
    }

}
