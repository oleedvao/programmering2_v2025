package no.hiof.oleedvao.forelesning13.model;

public class Circle extends Figure {

    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    /*
    draw() må implementeres her ettersom denne klassens foreldreklasse, Figure, implementerer interfacet Drawable
    som inneholder denne metoden som en abstrakt metode.
     */
    @Override
    public void draw() {
        System.out.println("o");
    }

    /*
    circumference() og area() må her implementeres ettersom denne klassens foreldreklasse, Figure, har definert disse
    som abstrakte metoder.
     */
    @Override
    public double circumference() {
        return 2 * radius * Math.PI;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
