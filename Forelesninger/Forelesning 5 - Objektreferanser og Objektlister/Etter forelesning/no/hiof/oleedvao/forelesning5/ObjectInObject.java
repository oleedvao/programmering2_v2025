package no.hiof.oleedvao.forelesning5;

import no.hiof.oleedvao.forelesning5.model.Course;
import no.hiof.oleedvao.forelesning5.model.Student;

public class ObjectInObject {
    public static void main(String[] args) {

        Student student1 = new Student("Ole-Edvard", "Ørebæk",
                27, "123456");

        Course course = new Course("Programmering 2", "ITF10619");

        /*
        Vi setter her Student-objektet sitt "favorittkurs" til å være et Course-objekt. Altså har vi et eksempel på
        hvor et objekt "inneholder" et annet objekt. Men egentlig er det riktigere å si at Student-objektet har en
        "referanse" til et Course-objekt. Vi kan alternativt si at Student-objektet har et forhold til et Course-objekt,
        og mer spesifikt at forholdet er at Course-objektet er "studenten" sitt favorittkurs.
         */
        student1.setFavoriteCourse(course);

        /*
        Vi kan nå aksessere Course-objektet gjennom Student-objektet sine gettere og settere.
         */
        Course studentsFavoriteCourse = student1.getFavoriteCourse();
        System.out.println("Student 1 favorite course object: " + studentsFavoriteCourse);

        /*
        Det følgende henter ut Course-objektet sitt navn gjennom Student-objektet.
        Vi kunne også gjort dette ved å hente ut objektet først, f.eks.
            String favoriteCourseName = studentsFavoriteCourse.getCourseName();
        Men slik som vi gjør under medfører akkurat det samme og gjør at vi slipper å mellomlagre objektet i en
        variabel. Dette er altså en liten optimalisering i forhold til kodelinjer.
         */
        String favoriteCourseName = student1.getFavoriteCourse().getCourseName();
        System.out.println("Student 1 favorite course name: " + favoriteCourseName);

        /*
        Det følgende ender Course-objektet sitt navn gjennom Student-objektet.
         */
        course.setCourseName("Programmering 2077");

        /*
        Merk at en endring på et objekt vil medføre denne endringen for ALLE referanser til objektet, om dette er en
        vanlig variabel eller en instansvariabel.
         */
        System.out.println("\ncourse-variable after change: " + course.getCourseName());
        System.out.println("Student 1 favorite course name after change: "
                + student1.getFavoriteCourse().getCourseName());


    }
}
