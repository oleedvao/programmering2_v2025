package no.hiof.oleedvao.forelesning22;

import no.hiof.oleedvao.forelesning22.model.Album;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {

    /*
    Konstanter benyttet til databasekoblinger
     */
    public final static String DB_URL = "jdbc:mysql://localhost:3306/albumdb";
    public final static String USERNAME = "..."; //Skriv inn brukernavnet for databasen din
    public final static String PASSWORD = "..."; //Skriv inn passordet for databasen din

    public static void main(String[] args) {

        System.out.println("--- All albums from database ---");
        ArrayList<Album> allAlbums = getAllAlbums();
        for (Album album : allAlbums) {
            System.out.println(album);
        }

        Album hybridTheory = new Album("Hybrid Theory", "Linkin Park", 2000);
        //addAlbum(hybridTheory);
    }

    /*
    Henter alle album fra databasen og returnerer disse som en liste med Album-objekter.
     */
    public static ArrayList<Album> getAllAlbums() {

        ArrayList<Album> allAlbums = new ArrayList<>();

        /*
        Oppretter en databasekobling. Merk at dette krever tilgang til en en MySQL-driver. Se pom.xml for tilgang til
        denne, spesifikt mysql.mysql-connector-java. Merk også at Connections kan medføre exceptions og bør lukkes, så
        bruk av try-with-resources er anbefalt.
         */
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            //System.out.println("Connection successful!");

            // SQL som skal kjøres. Her at vi henter alt fra tabellen kalt album.
            String sql = "select * from album";
            /*
            For å gjøre SQL-spørringen kjørbar lager vi et PreparedStatement via Connection-objektet.
            Hvis SQL-spørringen skal returnerer et resultat benytter vi metoden executeQuery() som vil returnere
            et ResultSet-objekt. Merk at både PreparedStatement og Resultset kan gi exceptions som må håndteres og
            bør lukkes etter bruk.
             */
            try (PreparedStatement prepStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = prepStatement.executeQuery()) {

                /*
                Det følgende vil gjennomgå hver rad i resultatet.
                 */
                while (resultSet.next()) {
                    /*
                    For hver rad kan vi hente ut individuelle kolonne-verdier og benytte disse som vi ønsker.
                    For eksempel for å opprette objekter. Her vil hver rad representere et album, så vi henter ut og
                    benytter de individuelle verdiene nøvendig for å opprette et Album-objekt.
                     */
                    String albumTitle = resultSet.getString("Title");
                    String albumArtist = resultSet.getString("Artist");
                    int albumYear = resultSet.getInt("Year");

                    Album fetchedAlbum = new Album(albumTitle, albumArtist, albumYear);
                    allAlbums.add(fetchedAlbum);
                }
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        /*
        Returnerer listen fylt med Album-objekter hentet fra database.
         */
        return allAlbums;
    }

    /*
    Legger til et album i databasen
     */
    public static void addAlbum(Album album) {

        /*
        Oppretter en databasekobling. Merk at dette krever tilgang til en en MySQL-driver. Se pom.xml for tilgang til
        denne, spesifikt mysql.mysql-connector-java. Merk også at Connections kan medføre exceptions og bør lukkes, så
        bruk av try-with-resources er anbefalt.
         */
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {

            /*
            Vi definerer her en SQL for å legge til et nytt album. Merk at verdiene for Title, Artist og Year ikke
            defineres direkte i SQL-strengen, men markes med tegnet ?. Disse må settes inn med egne metoder.
             */
            String sql = "insert into album (Title, Artist, Year) values (?, ?, ?)";
            try (PreparedStatement prepStatement = connection.prepareStatement(sql)) {
                /*
                Vi definerer her verdiene markert med ? basert på posisjon/rekkefølge og datatype. Merk at posisjon med
                PreparedStatements starter på 1 og går oppover. Verdiene vi setter hentes ut fra Album-objektet
                definert som parameter.
                 */
                prepStatement.setString(1, album.getTitle());
                prepStatement.setString(2, album.getArtist());
                prepStatement.setInt(3, album.getYear());

                // Kjører uttrykket. Merk at vi mentter executeUpdate() når vi gjør en handling uten resultat.
                prepStatement.executeUpdate();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
