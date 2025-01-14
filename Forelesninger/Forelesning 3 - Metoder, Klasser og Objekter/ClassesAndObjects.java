public class ClassesAndObjects {
    public static void main(String[] args) {

        System.out.println("---Student 1---");
        /*
        Opprettelse av et unikt Student-objekt. Merk at datatypen er satt til klassens navn. Vi benytter nøkkelordet
        new for å opprette objekter, samt KlasseNavn().
         */
        Student student1 = new Student();
        System.out.println(student1); // Gir bare en rar utskrift. Mer om denne senere i kurset.
        System.out.println(student1.firstName); // student1 sin firstName har enda ingen verdi fordi den er tom som standard

        /*
        Vi kan aksessere et objekt sine egenskaper/attributter ved å skrive . etter en objekt-variabel
        (Gjelder bare egenskaper som er public)
        Vi kan for eksempel benytte disse til å sette og endre instansvariabel-verdiene og konseptuelt gi
        Student-objektet vårt et unikt navn, en alder og studentid.
        (Merk likevel at denne måte å håndtere instansvariabler er problematisk over tid og er ikke hvordan vi vil
        håndtere dette videre i kurset. Se Encapsulation og StudentV2.)
         */
        student1.firstName = "Ole-Edvard";
        student1.lastName = "Ørebæk";
        student1.age = 27;
        student1.studentId = "123456";

        // Hvis vi skriver ut instansvariablene vil vi nå se at disse har fått verdiene vi satt over.
        System.out.println(student1.firstName);
        System.out.println(student1.lastName);
        System.out.println(student1.age);
        System.out.println(student1.studentId);


        //---Student 2---
        System.out.println("\n---Student 2---");

        /*
        // Vi kan opprette så mange objekter av en klasse som vi ønsker. Verdiene vi setter vil være unike for
        // hvert objekt. Altså vet java forskjellen på student1 og student1 her og husker hvilke verdier som tilhører
        // hvem. (Tiltenkt: "student1 heter Ole-Edvard, mens student1 heter John")
         */
        Student student2 = new Student();
        System.out.println(student2);
        System.out.println(student2.firstName);

        student2.firstName = "John";
        student2.lastName = "Doe";
        student2.age = 40;
        student2.studentId = "654321";

        System.out.println(student2.firstName);
        System.out.println(student2.lastName);
        System.out.println(student2.age);
        System.out.println(student2.studentId);

        System.out.println();
        System.out.println(student1.firstName + " " +
                student1.lastName);


        //---Course object---
        System.out.println("\n---Course object---");

        /*
        Vi kan også opprette objekter av andre klasser. Det er ingen begrensning for hvor mange klasser vi kan
        definere eller hvor mange objekter vi kan opprette for hver av disse
         */
        Course course1 = new Course();
        course1.courseName = "Programmering 2";
        course1.courseCode = "ITF10619";

        System.out.println(course1.courseName);
        System.out.println(course1.courseCode);

    }
}
