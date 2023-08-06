package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cinema {
    private int filmId;
    private String filmName;
    private String genre;
    private String description;
    private LocalDate filmDate;
    private LocalTime filmTime;
    private int ticketCount;
    private double ticketPrice;
    private String language;
    private byte visionStatus;

    public Cinema(int filmId, String filmName, String genre, String description, LocalDate filmDate, LocalTime filmTime, int ticketCount, double ticketPrice, String language, byte visionStatus) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.genre = genre;
        this.description = description;
        this.filmDate = filmDate;
        this.filmTime = filmTime;
        this.ticketCount = ticketCount;
        this.ticketPrice = ticketPrice;
        this.language = language;
        this.visionStatus = visionStatus;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(LocalDate filmDate) {
        this.filmDate = filmDate;
    }

    public LocalTime getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(LocalTime filmTime) {
        this.filmTime = filmTime;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public byte getVisionStatus() {
        return visionStatus;
    }

    public void setVisionStatus(byte visionStatus) {
        this.visionStatus = visionStatus;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", filmDate=" + filmDate +
                ", filmTime=" + filmTime +
                ", ticketCount=" + ticketCount +
                ", ticketPrice=" + ticketPrice +
                ", language='" + language + '\'' +
                ", visionStatus=" + visionStatus +
                '}';
    }
}
