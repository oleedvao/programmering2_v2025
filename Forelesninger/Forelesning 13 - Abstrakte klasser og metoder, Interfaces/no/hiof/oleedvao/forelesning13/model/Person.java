package no.hiof.oleedvao.forelesning13.model;

import no.hiof.oleedvao.forelesning13.interfaces.Drawable;

/*
Person implementerer her Drawable, slik at den kan "tegnes"
 */
public class Person implements Drawable {

    @Override
    public void draw() {
        System.out.println(" o ");
        System.out.println("/|\\");
        System.out.println("/ \\");
    }
}
