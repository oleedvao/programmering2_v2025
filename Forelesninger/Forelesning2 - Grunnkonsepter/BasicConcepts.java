public class BasicConcepts {
    public static void main(String[] args) {

        //---Variables and Datatypes---
        System.out.println("---Variables and Datatypes");

        /*
        int er den mest benyttede datatypen for heltall
        Vi kan bare sette inn heltall i en int variabel
        */
        int number = 10;
        System.out.println("Whole number: " + number);

        /*
        double er den mest benytted datatypen for desimaltall
        Vi kan sette inne både desimaltall og heltall i en double variabel. Heltallene blir automatisk konvertert til
        Det tilsvarende desimaltallet.
        */
        double decimal = 5.5;
        System.out.println("Decimal number: " + decimal);

        /*
        boolean kan bare inneholde true eller false og benytes ofte i forbindelse med if-tester og for å representere
        tilstander i programmet.
         */
        boolean bool = true;
        System.out.println("Boolean value: " + bool);

        /*
        String er en klasse som representerer tekst. Det er viktig å bemerge at String altså ikke er en primitiv
        datatype slik som int, double og boolean, men benyttes typisk like ofte som disse.
         */
        String text = "You shall not pass!";
        System.out.println("Text: " + text);



        //---Calculations---
        System.out.println("\n---Calculations---");

        /*
        Vi kan fint sette inn resultatet av en beregning med to heltall i en int-variabel.
         */
        int sum1 = number + 20;
        System.out.println("Int calculation: " + sum1);

        /*
        Hvis vi gjør en beregning som inkluderer et desimaltall kan dette ikke settes inn i en int-variabel og vi må
        i stedet benytte double.
         */
        double sum2 = number + decimal;
        System.out.println("Int and double calculation: " + sum2);

        /*
        Hvis vi virkelig ønsker å ta vare på resultatet av beregningen som et heltall kan vi benytte typecasting som
        vist under. Typecasting er imidlertid noe som benyttes mest i kontekst av objekter, som vi vil gå gjennom i
        senere forelesninger.
         */
        int sum3 = (int)(number + decimal);
        System.out.println("Type casting from double to int: " + sum3);

        /*
        Vi kan sette inn resultatet av en deling i en int-variabel så lenge verdiene benyttet i delingen bare
        inkluderer heltall. Resultatet vil i så fall forkaste desimalene og i praksis runde ned til nærmeste heltall.
         */
        int division1 = number / 3;
        System.out.println("Division with whole numbers: " + division1);

        /*
        Typisk når vi gjør deling, ønsker vi å ta vare på resultatet som et desimaltall. Dermed er det mest vanlig å
        benytte double når det gjelder deling.
         */
        double division2 = number / 3.0;
        System.out.println("Typical division: " + division2);



        //---Assignment---
        System.out.println("\n---Assignment---");

        /*
        Vi setter her en variabel med en primitiv datatype lik en annen.
         */
        int variable1 = 42;
        int variable2 = variable1;

        System.out.println("Variable 1: " + variable1);
        System.out.println("Variable 2: " + variable2);

        /*
        Hvis vi endrer på én av disse variablene vil ikke dette påvirke den andre. Dette er tilfellet for primitive
        datatyper, men er ikke tilfellet for slikt som objekter, som vi skal diskutere i senere forelesninger.
         */
        variable1 = 123;

        System.out.println("Variable 1 after change: " + variable1);
        System.out.println("Variable 2 after change: " + variable2);

    }
}
