/*
Klassedefinisjonen for HelloWorld. Merk at denne MÅ hete akkurat det samme som
filen minus extension. Altså HelloWorld. Heter den noe annet vil ikke programmet kjøre
Merk at navnkonvensjonen er PascalCase (Stor forbokstav på hvert ord, ingen mellomrom eller
skilletegn).
Merk også at klassens kodekropp annoteres med { og }.
 */
public class HelloWorld {
    /*
    Klassens main-metode. Det som defineres i kodekroppen her er det som vil utføres når filen kjøres
    For å kjøre første gang på en enkel måte i intelliJ IDEA høyreklikk på filen i
    filoversikten til venstre i IDE-et og velg "Run 'HelloWorld.main()'"
     */
    public static void main(String[] args) {
        /*
        Skriver ut teksten "Hello World!" til output. I intelliJ IDEA vil resultatet (utskriften)
        poppe opp i et eget run-vindu. Hvor outputen kommer er avhengig av miljøet man jobber fra.
        */
        System.out.println("Hello world!");

    }
}
