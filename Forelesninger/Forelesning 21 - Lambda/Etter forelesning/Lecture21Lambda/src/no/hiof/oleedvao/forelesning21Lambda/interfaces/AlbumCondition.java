package no.hiof.oleedvao.forelesning21Lambda.interfaces;

import no.hiof.oleedvao.forelesning21Lambda.model.Album;

/*
Dette er et funksjonelt interface ettersom det bare har én metode. Interfacet skal representere en betingelse angående
et album er "gyldig" på et eller annet vis.
 */
public interface AlbumCondition {
    /*
    Implementasjonen av denne abstrakte metoden er konkret hva som skal benyttes for å sjekket "gyldigheten" av et
    album. Metoden tar derfor et album som parameter og returnerer en boolean verdi.
     */
    boolean isMet(Album album);
}
