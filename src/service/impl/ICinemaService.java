package service.impl;

import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.EmptyList;
import exceptions.FilmNotFound;
import exceptions.InvalidOption;
import globalData.GlobalData;
import model.Cinema;
import service.CinemaService;

import java.time.LocalDate;
import java.time.LocalTime;

import static util.InputUtil.*;
import static helper.CinemaServiceHelper.*;
import static util.MenuUtil.*;
public class ICinemaService implements CinemaService {
    private static int countIndex = 0;
    @Override
    public boolean addFilm() {
        int filmCount = intInput("How many Film you will add: ");

        if (GlobalData.cinemas == null) {
            GlobalData.cinemas = new Cinema[filmCount];
            for (int i = 0; i < GlobalData.cinemas.length; i++) {
                filmAddHelper();
            }
            System.out.println(StatusEnum.BOOK_ADDED_SUCCESSFULLY);
        } else {
            Cinema[] tempCinema = GlobalData.cinemas;
            GlobalData.cinemas = new Cinema[GlobalData.cinemas.length + filmCount];
            for (int i = 0; i < GlobalData.cinemas.length; i++) {
                if (i < tempCinema.length) {
                    GlobalData.cinemas[i] = tempCinema[i];
                } else  {
                    filmAddHelper();
                }
            }
            System.out.println(StatusEnum.BOOK_ADDED_SUCCESSFULLY);
    }
        int nullCinemaCount = 0;
        for (Cinema cinema: GlobalData.cinemas) {
            if (cinema == null) {
                nullCinemaCount++;
            }
        }
        Cinema[] cinemas = GlobalData.cinemas;
        GlobalData.cinemas = new Cinema[GlobalData.cinemas.length - nullCinemaCount];
        for (int i = 0; i < GlobalData.cinemas.length; i++) {
            GlobalData.cinemas[i] = cinemas[i];
        }
        return true;
}

    @Override
    public boolean updateFilm() {
        if (GlobalData.cinemas == null || GlobalData.cinemas.length == 0){
            throw new EmptyList(ExceptionEnum.EMPTY_LIST);
        }
        int filmId = intInput("Which film do you want to update: ");
        boolean isTrue = false;

        for (int i = 0; i < GlobalData.cinemas.length; i++) {
            if (GlobalData.cinemas[i].getFilmId() == filmId){
                String parameter = stringInput("Which parameter of film do you want to update: ");
                String[] parameterString = parameter.split(",");
                for (String str: parameterString) {
                    switch (str) {
                        case "filmName":
                            GlobalData.cinemas[i].setFilmName("Enter the changed name: ");
                            isTrue = true;
                            break;
                        case "filmDate":
                            GlobalData.cinemas[i].setFilmDate(LocalDate.parse("Enter the changed date: "));
                            isTrue = true;
                            break;
                        case "filmTime":
                            GlobalData.cinemas[i].setFilmTime(LocalTime.parse("Enter the changed time: "));
                            isTrue = true;
                            break;
                        case "ticketPrice":
                            GlobalData.cinemas[i].setTicketPrice(Double.parseDouble("Enter the changed price: "));
                            isTrue = true;
                            break;
                        case "ticketCount":
                            GlobalData.cinemas[i].setTicketCount(Integer.parseInt("Enter the changed count: "));
                            isTrue = true;
                            break;
                        default:
                            throw new FilmNotFound(ExceptionEnum.FILM_NOT_FOUND);
                    }
                }
                if (isTrue){
                    System.out.println(StatusEnum.UPDATE_SUCCESSFULLY);
                } else {
                    throw new FilmNotFound(ExceptionEnum.FILM_NOT_FOUND);
                }
            }
        }
        return true;
    }

    @Override
    public boolean deleteFilm() {
        if (GlobalData.cinemas == null || GlobalData.cinemas.length == 0){
            throw new EmptyList(ExceptionEnum.EMPTY_LIST);
        }
        int filmId = intInput("Which film do you want to delete: ");

        for (int i = 0; i < GlobalData.cinemas.length; i++) {
            if (GlobalData.cinemas[i].getFilmId() == filmId){
                Cinema[] cinemas = GlobalData.cinemas;
                GlobalData.cinemas = new Cinema[GlobalData.cinemas.length - 1];

                int k = 0;
                for (Cinema cinema:GlobalData.cinemas) {
                    if (cinema.getFilmId() == filmId){
                        continue;
                    }
                    GlobalData.cinemas[k] = cinema;
                    k++;
                }
                System.out.println(StatusEnum.DELETE_SUCCESSFULLY);
                break;
            }
        }
        return false;
    }

    @Override
    public void showFilm() {
        if (GlobalData.cinemas == null || GlobalData.cinemas.length == 0){
            throw new EmptyList(ExceptionEnum.EMPTY_LIST);
        }
        byte option = filmVisionStatusMenu();
        for (int i = 0; i < GlobalData.cinemas.length; i++) {
            switch (option) {
                case 1:
                    if (GlobalData.cinemas[i].getVisionStatus() == 1) {
                        System.out.println(GlobalData.cinemas[i].toString());
                    }
                    break;
                case 2:
                    if (GlobalData.cinemas[i].getVisionStatus() == 0) {
                        System.out.println(GlobalData.cinemas[i].toString());
                    }
                    break;
                default:
                    throw new InvalidOption(ExceptionEnum.INVALID_OPTION);
            }
        }
    }

    @Override
    public void searchFilm() {
        if (GlobalData.cinemas == null || GlobalData.cinemas.length == 0){
            throw new EmptyList(ExceptionEnum.EMPTY_LIST);
        }
        String filmSearchName = stringInput("Enter the film name which you want to search: ");
        for (int i = 0; i < GlobalData.cinemas.length; i++) {
            if (GlobalData.cinemas[i].getFilmName().equals(filmSearchName.toLowerCase())) {
                System.out.println(GlobalData.cinemas[i].toString());
            } else {
                throw new FilmNotFound(ExceptionEnum.FILM_NOT_FOUND);
            }
        }
    }
}
