package no.hiof.oleedvao.forelesning13;

import no.hiof.oleedvao.forelesning13.interfaces.Drawable;
import no.hiof.oleedvao.forelesning13.model.Circle;
import no.hiof.oleedvao.forelesning13.model.Figure;
import no.hiof.oleedvao.forelesning13.model.Person;
import no.hiof.oleedvao.forelesning13.model.Rectangle;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        /*
        Vi kan ikke opprette objekter av en abstract klasse, men vi kan opprette objekter av en abstract klasse sine
        barneklasser.
         */
        //Figure figure = new Figure();
        Rectangle rectangle = new Rectangle("Blue", 5, 4);
        Circle circle = new Circle("Green", 7);


        rectangle.draw();
        circle.draw();

        Person person = new Person();
        person.draw();

        /*
        Vi kan ikke opprette objekter av interfaces direkte, men vi kan benytte polymorfisme med interfaces.
        Altså kan vi opprette variabler eller lister med et interface som datatype. I slike variabler/lister kan vi bare
        sette inn objekter av klasser som har implementert det gjeldende interfacet, og vi vil bare ha tilgang til
        funksjonalitet som er definert i dette interfacet.
         */
        Drawable drawable = new Circle("Yellow", 3.4);
        drawable.draw();

        ArrayList<Drawable> listOfDrawables = new ArrayList<>();
        listOfDrawables.add(rectangle);
        listOfDrawables.add(circle);
        listOfDrawables.add(person);

        for (Drawable drawableX : listOfDrawables) {
            drawableX.draw();
        }

        /*
        Ettersom Figure har implementert Comparable-interfacet kan vi nå benytte Collections.sort() for å sortere en
        liste med Figure-objekter.
         */
        ArrayList<Figure> listOfFigures = new ArrayList<>();
        listOfFigures.add(rectangle);
        listOfFigures.add(circle);
        listOfFigures.add(new Rectangle("Red", 2, 1));

        System.out.println("Unsorted:");
        for (Figure figureX : listOfFigures) {
            System.out.println(figureX);
        }

        Collections.sort(listOfFigures);

        System.out.println("\nSorted:");
        for (Figure figureX : listOfFigures) {
            System.out.println(figureX);
        }
    }
}
