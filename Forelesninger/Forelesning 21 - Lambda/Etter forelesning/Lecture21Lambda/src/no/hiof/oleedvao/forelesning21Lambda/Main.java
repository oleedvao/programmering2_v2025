package no.hiof.oleedvao.forelesning21Lambda;

import no.hiof.oleedvao.forelesning21Lambda.interfaces.AlbumCondition;
import no.hiof.oleedvao.forelesning21Lambda.model.Album;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        /*
        En alternativ måte å benytte Collections.sort() er å sende med en implementasjon av interfacet Comparator som
        andre parameter hvor vi kan definere sorteringslogikken direkte. En mulighet for å løse dette er å benytte en
        anonym indre klasse, på samme måte som når vi har gjort dette med Handler i dyrepark-prosjektet:

        1:
        Collections.sort(albums, new Comparator<Album>() {
            @Override
            public int compare(Album album1, Album album2) {
                return Integer.compare(album1.getYear(), album2.getYear());
            }
        });

        Men et mer smidig alternativ for dette er å benytte lambda-uttrykk (2 eller 3):

        2:
        Collections.sort(albums, (album1, album2) -> {
            return Integer.compare(album1.getYear(), album2.getYear());
        });

        3:
        Collections.sort(albums, (album1, album2) -> Integer.compare(album1.getYear(), album2.getYear()));

        Et lambda-uttrykk er basert på et funksjonelt interface (et interface med bare én abstrakt metode) og kan
        tenkes på som en implementasjon av interfacets éne metode hvor vi bare definerer det vi må; hva vi kaller
        parameterene tilmetoden og hva vi skal gjøre med dem. Resten, slik som metodens returtype, navn og datatyper
        for parametere er underforstått ut ifra interfacet.
        Comparator er altså et funksjonelt interface med en metode kalt compare av typen int, og som tar to objekter av
        Album (i dette tilfellet) som parameter. Vi fokuserer altså på hva vi skal navngi Album-objektene, her album1
        og album2,  og hva vi skal gjøre med dem, her sammenligne årene med Integer.compare().

        Metode-kallet under vil altså sortere albumlisten basert på år (i stigende rekkefølge) ettersom vi benytter
        lambda-uttrykk for å definere dette som sorteringslogikken.
         */
        Collections.sort(albums, (album1, album2) -> Integer.compare(album1.getYear(), album2.getYear()));
        printAlbums(albums);

        System.out.println();
        System.out.println("--------Albums starting with T---------");
        /*
        Vi benytter her et lambda-uttrykk for å spesifisere betingelsen for utskrift av album og at dette skal være
        at album-navnet starter på T. printAlbumsConditionally() vil altså benytte denne betingelsen når den skriver ut
        albumene og vil i praksis filtrere basert på at første bokstav skal være T. Dette er mulig fordi det som
        forventes er det funksjonelle interfacet AlbumCondition.
         */
        printAlbumsConditionally(albums, album -> album.getTitle().startsWith("T") );

        System.out.println();
        System.out.println("-------Albums after the year 2000------");
        /*
        Vi benytter her et lambda-uttrykk for å spesifisere betingelsen for utskrift av album og at dette skal være at
        albumets år er etter år 2000. printAlbumsConditionally() vil altså benytte denne betingelsen når den skriver ut
        albumene og vil i praksis bare skrive ut album sluppet ut etter år 2000. Merk at vi nå kan benytte samme metode
        for både denne filtreringen og den forrige hvor vi filtrerte basert på navn.
         */
        printAlbumsConditionally(albums, album -> album.getYear() > 2000);

        System.out.println();
        System.out.println("------Print old but gold albums-----------------");
        /*
        Vi benytter igjen den samme metoden men med en annen betingelse definert med lambda uttrykk, her at vi skal
        skrive ut album sluppet ut 1970 eller tidligere.
         */
        printAlbumsConditionally(albums, album -> album.getYear() <= 1970);

    }

    /*
    Vi har er opprettet en metode som krever en implementasjon av det funksjonelle interfacet AlbumCondition.
    AlbumCondition skal her representere en betingelse som skal benyttes til å filtrere hvilke album som skal skrives
    ut, men hva betingelsen er vil være avhengig av implementasjonen som sendes med som parameter. Altså er metoden
    dynamisk i forhold til denne betingelsen.
     */
    public static void printAlbumsConditionally(ArrayList<Album> albums,
                                                AlbumCondition printCondition) {
        for (Album album : albums) {
            // Hvis betingelsen er møtt for det gjeldende albumet
            if (printCondition.isMet(album)) {
                System.out.println(album);
            }
        }
    }

    public static void printAlbums(ArrayList<Album> albums) {
        for (Album album : albums) {
            System.out.println(album);
        }
    }
}
