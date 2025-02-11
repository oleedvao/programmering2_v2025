package no.hiof.oleedvao.forelesning11;

import no.hiof.oleedvao.forelesning11.model.Person;
import no.hiof.oleedvao.forelesning11.util.UnitConverter;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("---final instance variable---");
        /*
        Vi ser at uansett hvordan vi oppretter ett objekt av Person-klassen, må i initialisere birthNumber ettersom
        dette er påkrevd av java. Altså at birthNumber må bli satt som en del av alle alternative konstruktører som
        klassen har. Det samme vil i effekt gjelde for eventuelle barneklasser som må benytte foreldreklassens
        konstruktør.

        Vi ser også at vi bare kan hente verdien for final variabelen, da java ikke tillater at vi setter en ny verdi
        for slike variabler og dermed ikke har lov til å opprette noen setter.
         */
        Person person = new Person("12345678910");
        System.out.println("Birth number: " + person.getBirthNumber());

        Person person2 = new Person("Ola", "Nordmann", 5, "10987654321");
        System.out.println("Birth number 2: " + person2.getBirthNumber());


        System.out.println("\n---Utility class---");
        /*
        Under ser vi bruk av en egenlaget utility-klasse. Vi kan se at vi aksesserer statiske metoder gjennom klassen
        selv. Dette er i motsetning til å opprette et objekt, som ikke er nødvendig for utility-klasser. Klassen
        fungerer så og si som en samling med metoder og konstanter og har ikke noen objektspesifikk funksjonalitet.
         */
        double result = UnitConverter.cmToMeter(600);
        System.out.println("600 cm is " + result + " meter");

        double result2 = UnitConverter.meterToCm(250);
        System.out.println("250 meter is " + result2 + " cm");

        double result3 = UnitConverter.meterToKm(3400);
        System.out.println("3400 meter is " + result3 + " km");

        double result4 = UnitConverter.kmToMeter(6.845);
        System.out.println("6.845 km is " + result4 + " meter");

        /*
        Vi ser her at vi aksesserer en konstant. Vi kan gjøre dette direkte da denne er final og ikke kan endres om vi
        så hadde forsøkt dette. Innkapsling er altså ikke nødvendig her.
         */
        System.out.println("Cm/meter conversion factor: " +
                UnitConverter.CM_METER_FACTOR);

        System.out.println("\n---Math and LocalDate");
        /*
        Under ser vi bruk av den ferdiglagde utility-klassen Math, som fungerer som en samling med metoder som kan
        benyttes til å utføre og assistere matematiske utregninger. I tillegg har den en samling med matematiske
        konstanter, slik som PI og E.

        Vi du inspiserer definisjonen av Math, vil du se at denne klassen følger de samme trekkene som beskrevet i vår
        egen Utility-klasse, UnitConverter.
         */
        System.out.println();
        System.out.println("Pi is " + Math.PI);
        System.out.println("the square root of 25: " + Math.sqrt(25));
        System.out.println("5 to the power of 2 is " + Math.pow(5, 2));

        /*
        LocalDate er en interessant klasse som har mange av de samme trekken som en vanlig utility-klasse, men denne
        er litt ekstra spesiell i at de statiske metodene faktisk returnerer objekter av klassen selv. Altså er denne
        klassen en type hybrid mellom en modell-klasse og en utility-klasse. Dette eksemplifiserer at selv om vi
        konseptuelt kan skille modell-klasser, utility-klasser og kjørbare klasser er det veldig fleksibelt hvordan
        man faktisk definerer klasser, og man kan blande trekk fra hver av dem, hvis det anses fornuftig.
         */
        System.out.println("Today: " + LocalDate.now());
    }
}
