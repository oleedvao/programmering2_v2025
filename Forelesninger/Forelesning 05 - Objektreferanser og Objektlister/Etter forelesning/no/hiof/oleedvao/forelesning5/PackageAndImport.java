/*
Når vi har en pakkestruktur må den gjeldende klassens lokasjon også spesifiseres med en package-statement.
 */
package no.hiof.oleedvao.forelesning5;

/*
Vi kan her se import-statements for Course og Student. Merk også modell-klassene typisk legges i en egen underpakke,
her kalt model.
 */
import no.hiof.oleedvao.forelesning5.model.Course;
import no.hiof.oleedvao.forelesning5.model.Student;

public class PackageAndImport {
    public static void main(String[] args) {

        /*
        Når vi benytter en pakkestruktur hvor klassene ligger i forskjellige nivåer må vi importere klasser for å gjøre
        det tydelig for Java hvilke vi skal benytte. Se import-statementene over klassedefinisjonen.
         */
        Student student = new Student();
        Course course = new Course();

    }
}
