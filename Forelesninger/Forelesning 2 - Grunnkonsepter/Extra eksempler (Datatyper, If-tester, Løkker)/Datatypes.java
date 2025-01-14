package extra;

public class Datatypes {
    public static void main(String[] args) {
        // ---Whole number datatypes---

        /*
        Byte er den minste av heltallsdatatypene og kan bare holde på små tall (litt over +-100)
        Det er ytterst skjeldent vi benytter denne datatypen.
         */
        byte byteNumber = -100;

        /*
        Short kan holde på litt større heltall (rundt +-32000), men er fremdeles for restriktiv for å brukes til vanlig.
         */
        short shortNumber = 10000;

        /*
        Int er den vanligst benyttede heltallsdatatypen i Java og kan holde på alle de mest benyttede tallverdiene.
         */
        int number = 1_000_000_000;
        System.out.println("Number: " + number);

        /*
        Long benyttes for å håndtere ekstremt store tall. For at Java skal tolke et heltall som en long må man avslutte
        tallet med en L. Det er skjeldent at vi benytter long i praksis, da int er typisk dekkende.
         */
        long longNumber = 1_000_000_000_000_000_000L;

        /*
        Vi kan summere flere heltallsdatatyper fritt, men vil typisk måtte benytte den største benyttede datatypen
        hvis vi vil sette inne resultatet i en variabel.
         */
        long weirdSum = byteNumber + shortNumber + number + longNumber;
        System.out.println("Sum whole numbers: " + weirdSum);


        // ---Decimal number datatypes---

        /*
        Float er i Java den minste desimaltalldatatypen og har en presisjon på ca 5 desimaler. For at Java skal tolke
        et desimaltall som en float må vi avslutte desimaltallet med F. Float er lite brukt i Java.
         */
        float floatDecimal = 5.55555F;

        /*
        Double er den mest benyttede desimaltalldatatypen i Java og har en presisjon på ca 10 desimaler.
         */
        double decimal = 5.68839288;


        /*
        Char er en primitiv datatype som kan holde på ett unicode tegn. Ekstremt lite brukt alene, men benyttes av
        String klassen internt for å sette sammen tegn til tekststrenger.
         */
        char character = 'Æ';

        /*
        String er ikke en primitiv datatype, men en klasse som internt benytter char for å sette sammen tegn til
        konseptuelle tekststrenger.
         */
        String text = "Something!";

    }
}
