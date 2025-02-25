package no.hiof.oleedvao.forelesning13.interfaces;

/*
Dette er et inerface. Merk at vi benytter nøkkelordet interface i stedet for class. Interfaces er litt spesielle i den
forstand at vi ikke kan opprette objekter av interfaces og slike interfaces inneholder typisk BARE abstrakte metoder.
Andre klasser kan implementere slike interfaces for å bli påtvunget å implementere de abstrakte metodene.

Dette interfacet representerer funksjonalitet knyttet til at et objekt skal være tegnbart. Dette kan være "nyttig" for
slikt som figurer, men eventuelt også andre ting slikt som en person, en tiger, en bil eller lignende. Altså kan det
være interessant å "tegne" mange typer objekter urelatert til arv. Interfaces er nyttig i slike tilfeller.
 */
public interface Drawable {

    /*
    draw er her en abstract metode.
    Merk at interfaces som standard forventer at metoder er definert som public abstract, så metode definisjonen under
    er tilsvarende:
        public abstract void draw();
     */
    void draw();

}
