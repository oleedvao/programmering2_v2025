package extra;

public class OtherBasicConcepts {
    public static void main(String[] args) {
        //If-tests
        // Forklaring: if-tester fungerer likt som i andre programmeringsspråk men noen minimale forskjeller i
        // syntaks. Betingelsene må spesifikt defineres innen for () og kode-kroppen for hver if-test
        // defineres på innsiden av {}
        // I java skriver vi else if i stedet for foreksempel elif.
        int number = 10;
        if (number < 5) {
            System.out.println("The number is less than 5.");
        }
        else if (number > 15) {
            System.out.println("The number is greater than 15.");
        }
        else {
            System.out.println("Bingus");
        }

        // While-loops
        // Forklaring: Fungerer likt som i andre programmersspråk, men som med if-tester defineres betingelsen innenfor
        // () og kode-kroppen innen {}
        System.out.println();
        int iteration = 0;
        while (iteration < 5) {
            System.out.println(iteration);
            // operatoren ++ oppdaterer variabelen ved å øke verdien med 1.
            iteration++;
        }

        //For-loops
        // Forklaring: For-løkker har litt flere syntaks-forskjeller enn de tidligere konseptene.
        // Mer spesifikt må vi i Java være veldig tydelige på intereringslogikken og definere denne ganske så manuelt.
        // Dette kan konseptuelt deles i tre kompoentent som alle skrives på innsiden av () og er sepparert med ;
        // Første komponent er "iterasjonsreferansen/-variabelen" som er en lokal variabel vi definerer for å holde
        // styr på hvilken iterasjon vi er i. Under er denne definert som int x = 0 og betyr at vi starter denne på 0.
        // Andre komponent er sluttbetingelsen og fungerer likt som en betingelse i en while-løkke gjør. Her er denne
        // definiert som x < 5. Altså vil løkken kjøre så lenge x er mindre enn 5.
        // Tredje og siste komponent er oppdateringslogikken som skal utføres for "iterasjonsreferansen" x per
        // iterasjon. Her venytter vi ++ for å øke x med en hver iterasjon.
        // Når alt kommer sammen vil denne løkken i praksis kjøre 5 ganger og skrive ut tallene 0 til 4. Altså
        // tilsvarende som while-løkken definert over.
        // Som en liten ting å nevne: Det er mulig å definere løkker som itererer gjennom liste-elementer, men vi
        // sparer dette til senere i kurset.
        System.out.println();
        for (int x = 0; x < 5; x++) {
            System.out.println(x);
        }

        // Vi kan også være kreative med iterasjonslogikken. For eksempel kan vi starte x på 5 og iterere nedover ved
        // å benytte --. Men da må vi i så fall også passe på at sluttbetingelsen samsvarer med at det itereres nedover.
        System.out.println();
        for (int x = 5; x > 0; x--) {
            System.out.println(x);
        }

        // Vi kan også iterere med større sted ved å oppdatere ved bruk av +=, -=, *= eller lignende. Vi kan være
        // kreative her.
        System.out.println();
        for (int x = 0; x < 10; x += 3) {
            System.out.println(x);
        }
    }
}
