package no.hiof.oleedvao.forelesning10;

import no.hiof.oleedvao.forelesning10.model.BussDriver;
import no.hiof.oleedvao.forelesning10.model.Carpenter;
import no.hiof.oleedvao.forelesning10.model.CarpenterApprentice;

import java.time.LocalDate;

public class Overloading {
    public static void main(String[] args) {

        BussDriver bussDriver = new BussDriver("Buss", "Driver", 30);
        System.out.println(bussDriver);

        Carpenter carpenter = new Carpenter("John", "Carpenter", 60);
        System.out.println();
        System.out.println(carpenter);

        CarpenterApprentice apprentice = new CarpenterApprentice("Carpenter", "Apprentice", 20);
        System.out.println();
        System.out.println(apprentice);

        CarpenterApprentice apprentice2 = new CarpenterApprentice(
                "Jon", "Då", 21, 0,
                LocalDate.now(), LocalDate.of(2026, 6, 15));

        System.out.println("\n---Apprentice with training period---");
        System.out.println(apprentice2);

        apprentice2.extendTrainingPeriod(LocalDate.of(2026, 12, 24));
        System.out.println();
        System.out.println(apprentice2);

        apprentice2.extendTrainingPeriod(65);
        System.out.println();
        System.out.println(apprentice2);

    }
}
