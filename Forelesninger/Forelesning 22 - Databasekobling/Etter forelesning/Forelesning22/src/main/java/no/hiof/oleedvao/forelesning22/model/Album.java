package no.hiof.oleedvao.forelesning22.model;

public class Album implements Comparable<Album> {
    private String title;
    private String artist;
    private int year;

    public Album(String title, String artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    @Override
    public int compareTo(Album otherAlbum) {
        return this.title.compareTo(otherAlbum.title);
    }

    @Override
    public String toString() {
        return title + " - " + artist + " - " + year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
