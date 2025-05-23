package no.hiof.oleedvao.zooregister.repository;

import no.hiof.oleedvao.zooregister.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class ZooDataRepository implements ZooRepository{

    private ArrayList<Zoo> zoos = new ArrayList<>();
    private Animal mascot;

    public ZooDataRepository() {
        Zoo kristiansand = new Zoo("Kristiansand");

        Chimp julius = new Chimp("Julius", LocalDate.of(1979, 12, 26),
                80);
        HoneyBadger nils = new HoneyBadger("Nils", LocalDate.now());
        Panda po = new Panda("Po", LocalDate.now(), "Black");
        kristiansand.addAnimal(julius);
        kristiansand.addAnimal(nils);
        kristiansand.addAnimal(po);

        Zoo noahsArk = new Zoo("Noahs Ark");
        noahsArk.addAnimal(new Chimp("Monke", LocalDate.now(), 60));

        zoos.add(kristiansand);
        zoos.add(noahsArk);
        mascot = julius;
    }

    @Override
    public Animal getMascot() {
        return mascot;
    }

    @Override
    public ArrayList<Zoo> getAllZoos() {
        return zoos;
    }
}
