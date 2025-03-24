package no.hiof.oleedvao.zooregister.controller;

import io.javalin.http.Context;
import no.hiof.oleedvao.zooregister.model.Zoo;
import no.hiof.oleedvao.zooregister.repository.ZooRepository;

public class ZooController {

    private ZooRepository zooRepository;

    public ZooController(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    public void addZoo(Context context) {
        String zooName = context.formParam("zoo-name");

        Zoo createdZoo = new Zoo(zooName);

        zooRepository.addZoo(createdZoo);

        context.redirect("/zoo/" + zooName);
    }

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

    public void getAllZoos(Context context) {
        context.json(zooRepository.getAllZoos());
    }

    public void getMascot(Context context) {
        context.json(zooRepository.getMascot());
    }

}
