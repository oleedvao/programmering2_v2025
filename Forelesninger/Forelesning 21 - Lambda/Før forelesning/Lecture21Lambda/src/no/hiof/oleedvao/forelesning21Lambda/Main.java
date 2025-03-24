package no.hiof.oleedvao.forelesning21Lambda;

import no.hiof.oleedvao.forelesning21Lambda.model.Album;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("In Rainbows", "Radiohead", 2007));
        albums.add(new Album("Souvlaki", "Slowdive", 1994));
        albums.add(new Album("SILENT HILL2", "Akira Yamaoka", 2001));
        albums.add(new Album("Pet Sounds", "The Beach Boys", 1966));
        albums.add(new Album("98.12.28", "Fishmans", 1999));
        albums.add(new Album("Blue Rev", "Alvvays", 2022));
        albums.add(new Album("Mercurial World", "Magdalena Bay", 2021));
        albums.add(new Album("The Mollusk", "Ween", 1997));
        albums.add(new Album("In The Court Of The Crimson King", "King Crimson", 1969));
        albums.add(new Album("Knocknarea", "Maruja", 2023));
        albums.add(new Album("The Downward Spiral", "Nine Inch Nails", 1994));
        albums.add(new Album("Emotion", "Carly Rae Jepsen", 2015));
        albums.add(new Album("You Will Never Know Why", "Sweet Trip", 2009));
        albums.add(new Album("EUSEXUA", "FKA Twigs", 2025));
        albums.add(new Album("Violator", "Depeche Mode", 1990));
        albums.add(new Album("Ants From Up There", "Black Country, New Road", 2022));
        albums.add(new Album("Songs Of A Lost World", "The Cure", 2024));


        System.out.println("-----------Unsorted Albums-----------");
        printAlbums(albums);

        System.out.println();
        System.out.println("-----------Standard, name sorted albums----------");
        Collections.sort(albums); // Sorteringen tar her utgangpunkt i Album-klassen sin Comparable-implementasjon
        printAlbums(albums);

        System.out.println();
        System.out.println("----------Albums sorted by year (ascending)--------");

        System.out.println();
        System.out.println("--------Albums starting with T---------");

        System.out.println();
        System.out.println("-------Albums after the year 2000------");

        System.out.println();
        System.out.println("------Print old albums-----------------");

    }

    public static void printAlbums(ArrayList<Album> albums) {
        for (Album album : albums) {
            System.out.println(album);
        }
    }
}
