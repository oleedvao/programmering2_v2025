package no.hiof.oleedvao.forelesning11.util;

/*
Denne klassen er det vi kaller for en utility-klasse og er bare ment til å være en samling med funksjonalitet,
her metoder for å konvertere mellom noen utvalgte enheter. Slike klasser skiller seg litt fra klasser vi har opprettet
tidligere, som typisk har vært enten kjørbare klasser (med en main-metode) eller "datatype"-klasser som representerer
objekter vi ønsker å opprette. Klassen under er på en annen side bare ment som en samling med metoder og variabler som
skal kunne benyttes i andre klasser. Altså kan en slik klasse konseptelt tenkes på som et "verktøy".

Merk at vi definerer klassen til å være final. Dette gjør det slik at det ikke er mulig å arve fra denne klassen.
Vi gjør dette ettersom det ikke vil være noe behov for å lage underklasser eller overstyre de definerte metodene.,
Innholdet av klassen er "endelig".
 */
public final class UnitConverter {

    /*
    Variablene under er det vi kaller for konstanter, basert på at de er både definerte som final og static
    på samme tid. Altså har konstanter både funksjonaliteten tilhørende final og static: Verdiene er
    uavhengige av objekter og de kan ikke endres etter de er satt. Slike konstanter blir ofte benyttet for
    matematiske utregninger, men er absolutt ikke begrenset til dette. Vi oppretter typisk konstanter når vi ser at
    flere forskjellige metoder i en klasse benytter samme verdi (om dette er et tall eller en tekstlig verdi), slik at
    vi i stedet kan kalle konstanten for å benytte verdien. Dette gjør typisk koden enklere å opprettholde og enklere å
    lese, sett at vi navngir konstantene på en god måte.

    Merk at nanvkonvensjonen for konstanter er store bokstaver og _ som mellomrom mellom ord.
    Merk også at det typisk er greit å sette konstanter til public ettersom det uansett ikke er mulig å endre på disse
    verdiene.
     */
    public static final int CM_METER_FACTOR = 100;
    public static final int METER_KM_FACTOR = 1000;

    /*
    Vi setter her konstruktøren til å være private. Dette gjør at det ikke er mulig å opprette objekter av denne
    klassen, som typisk ikke er nødvendig for utility-klaser, som bare er en samling med ferdigdefinerte statiske
    metoder og konstanter.
     */
    private UnitConverter() {

    }

    /*
    Metodene under er definert for å kunne benyttes til å konvertere frem og tilbake mellom forksjellige enheter.
    Disse er uavhengige av slikt som instansvariabler og kan dermed defineres som static, slik at de heller tilhører
    klassen selv. Vi kan også se at disse benytter konstantene definert over i stedet for å skrive verdiene
    manuelt hver gang. Dette er typisk mer ryddig, lesbart og oversiktlig for de som programmerer rundt dette
     */
    public static double cmToMeter(double cm) {
        return cm / CM_METER_FACTOR;
    }

    public static double meterToCm(double meter) {
        return meter * CM_METER_FACTOR;
    }

    public static double meterToKm(double meter) {
        return meter / METER_KM_FACTOR;
    }

    public static double kmToMeter(double km) {
        return km * METER_KM_FACTOR;
    }
}
