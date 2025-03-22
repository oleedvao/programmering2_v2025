package no.hiof.oleedvao.zooregister.repository;

import no.hiof.oleedvao.zooregister.model.Animal;
import no.hiof.oleedvao.zooregister.model.Zoo;

import java.util.ArrayList;

public interface ZooRepository {

    Animal getMascot();
    ArrayList<Zoo> getAllZoos();
    Zoo getZooByName(String name);
    void addZoo(Zoo zoo);

}
