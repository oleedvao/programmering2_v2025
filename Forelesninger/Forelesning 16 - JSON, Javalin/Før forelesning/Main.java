package no.hiof.oleedvao.forelesning15csv;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SuperHero batman = new SuperHero("Batman", "Bruce Wayne");
        SuperHero wolverine = new SuperHero("Wolverine", "Logan");
        SuperHero wonderWoman = new SuperHero("Wonder Woman", "Diana Prince");

        ArrayList<SuperHero> superHeroes = new ArrayList<>();
        superHeroes.add(batman);
        superHeroes.add(wolverine);
        superHeroes.add(wonderWoman);

        File csvFile = new File("superheroes.csv");

    }
}
