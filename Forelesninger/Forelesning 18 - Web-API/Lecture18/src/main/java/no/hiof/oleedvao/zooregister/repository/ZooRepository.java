package no.hiof.oleedvao.zooregister.repository;

import no.hiof.oleedvao.zooregister.model.Animal;
import no.hiof.oleedvao.zooregister.model.Zoo;

import java.util.ArrayList;

/*
Dette interfacet beskriver generelt de handlingene vi skal kunne gjøre på Zoo-objektene i systemet. Grunnen til at
vi definerer dette som et interface er at selve implementasjonenene av datahåndteringene (metodene) kan variere
avhengig av hvilke lagringsmedier vi benytter. For eksempel vil vi ofte hardkode data når vi tester (såkalt dummy-data),
og benytte en database-kommunikasjon når applikasjonen er i publisert og i produksjon.
 */
public interface ZooRepository {

    Animal getMascot();
    ArrayList<Zoo> getAllZoos();

}
