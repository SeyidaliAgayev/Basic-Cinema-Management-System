package helper;

import globalData.GlobalData;
import model.Cinema;

import java.time.LocalDate;
import java.time.LocalTime;

import static util.InputUtil.*;

public class CinemaServiceHelper {
    static int countIndex = 0;
    private static int filmId = 0;
    public static void filmAddHelper() {
        Cinema cinema = fillCinema();
        if (cinema != null) {
            GlobalData.cinemas[countIndex] = cinema;
            countIndex++;
        }
    }
    public static Cinema fillCinema(){
        try {
            String filmName = stringInput("Enter the film name: ");
            String genre = stringInput("Enter the genre: ");
            String description = stringInput("Enter the description: ");
            LocalDate filmDate = dateServiceHelper();
            LocalTime filmTime = timeServiceHelper();
            int ticketCount = intInput("Enter the number of ticket: ");
            double ticketPrice = doubleInput("Enter the price: ");
            String language = stringInput("Enter the language: ");
            byte visionStatus = byteInput("Enter the vision status(if film in vision status is 1, else status is 0): ");
            return new Cinema(++filmId,filmName,genre,description,filmDate,filmTime,ticketCount,ticketPrice,language,visionStatus);
        } catch (RuntimeException exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
    public static LocalDate dateServiceHelper() {
        try {
            String str1 = stringInput("Enter the film Date(day-month-years): ");
            String[] str2 = str1.split("-");
            int day = Integer.parseInt(str2[0]);
            int month = Integer.parseInt(str2[1]);
            int years = Integer.parseInt(str2[2]);
            return LocalDate.of(day, month, years);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
    public static LocalTime timeServiceHelper() {
        try {
            String str1 = stringInput("Enter the film time(hours:minutes): ");
            String[] str2 = str1.split("-");
            int hours = Integer.parseInt(str2[0]);
            int minutes = Integer.parseInt(str2[1]);
            return LocalTime.of(hours, minutes);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
