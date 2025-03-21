package no.hiof.oleedvao.zooregister.repository;

import no.hiof.oleedvao.zooregister.model.Animal;
import no.hiof.oleedvao.zooregister.model.Zoo;

import java.util.ArrayList;

public interface ZooRepository {

    Animal getMascot();
    ArrayList<Zoo> getAllZoos();

    /*
    Lagt til for å sørge for at alle implementasjoner av ZooRepository har en metode for å hente én dyrepark basert
    på navn.
     */
    Zoo getZooByName(String name);

}
