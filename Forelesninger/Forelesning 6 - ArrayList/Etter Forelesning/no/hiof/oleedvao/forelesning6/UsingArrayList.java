package no.hiof.oleedvao.forelesning6;

import no.hiof.oleedvao.forelesning6.model.Student;

import java.util.ArrayList;

public class UsingArrayList {
    public static void main(String[] args) {

        System.out.println("---Integer ArrayList---");

        /*
        Vi oppretter her en ArrayList for å holde på heltall. Merk at vi ikke kan benytte den primitive datatypen (int)
        direkte, men er tvunget til å benytte wrapper-klassen Integer ettersom ArrayList bare kan håndtere klasser som
        datatype.
        De vanligste wrapper klassene å benytte er
            int -> Integer
            double -> Double
            boolean -> Boolean
         */
        ArrayList<Integer> numberList = new ArrayList<>();
        System.out.println("List size: " + numberList.size()); // Etter opprettelse er listen tom.

        /*
        Vi kan legge til så mange elementer i listen som vi ønsker. For hvert element vil listen dynamisk endre
        størrelse.
         */
        numberList.add(42);
        System.out.println("List size: " + numberList.size());
        numberList.add(500);
        numberList.add(35);
        numberList.add(89);
        System.out.println("List size: " + numberList.size());

        /*
        Vi kan referere til elementer ved å benytt .get() med index som parameter. Under skriver vi ut andre element
        fra listen. Merk at .get() ikke endrer noe på listen, den tillater oss bare å refere til elementet på en
        posisjon. Merk også at programmet vil krasje hvis vi forsøker å refere til en posisjon som er utenfor listens
        størrelse.
         */
        System.out.println("\nSecond number in list: " + numberList.get(1));
        System.out.println("Second number in list: " + numberList.get(1));

        /*
        .remove() fjerner et element basert på posisjon (index). Dette medfører at listen krymper i størrelse.
        Under ser vi at fjerner andre element i listen. Dette medfører at tallet på denne posisjonen forsvinner og
        blir erstattet med elementet som kommer etter. Vi kan konseptuelt tenke på dette som at listen automatisk
        fyller hullet vi etterlater når vi fjerner elementet.
         */
        numberList.remove(1);
        System.out.println("\nSecond number in list after removal: " + numberList.get(1));
        System.out.println("List size: " + numberList.size());

        /*
        Vi benytter her en for each løkke for å utføre en handling for hvert element i listen.
        Syntaksen kan konseptuelt leses/tenkes på som:
        for (<...hver Integer, som vi kaller number...> : <...i listen numberList,...>) {
            <...gjør det det følgende med number>;
        }
         */
        System.out.println("\nFor each loop:");
        for (Integer number : numberList) {
            System.out.println(number);
        }

        /*
        Vi lager her en for each løkke som går gjennom liste-elementene baklengs. Den eneste forskjellen fra den over
        er at vi kaller listen sin .reversed() metode, som returneren en reverert kopi av den orginale listen.
        .reversed() modifiserer altså ikke listen.
         */
        System.out.println("\nFor each loop of reversed list:");
        for (Integer number : numberList.reversed()) {
            System.out.println(number);
        }


        System.out.println("\n---Student ArrayList---");

        /*
        Vi oppretter her en ArrayList som kan holde på objekter av Student-klassen.
         */
        ArrayList<Student> studentList = new ArrayList<>();

        Student ole = new Student("Ole-E", "Ørebæk", 27,
                "123456");
        Student john = new Student("John", "Doe", 40, "654321");

        /*
        Vi kan legge til så mange Student-objekter som vi ønsker og listen vil dynamisk oppdatere seg.
         */
        studentList.add(ole);
        studentList.add(john);
        System.out.println("Student list size: " + studentList.size());

        /*
        Denne for each løkken skriver ut fornavnet på alle Student-objektene i listen studentList.
         */
        System.out.println("\nFor each in student list:");
        for (Student student : studentList) {
            System.out.println(student.getFirstName());
        }





    }
}
