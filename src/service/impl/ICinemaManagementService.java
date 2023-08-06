package service.impl;

import enums.ExceptionEnum;
import exceptions.CustomerNotFound;
import exceptions.EmptyList;
import exceptions.FilmNotFound;
import exceptions.InvalidOption;
import service.CinemaManagementService;
import service.CinemaService;
import service.CustomerService;

import static util.MenuUtil.*;

public class ICinemaManagementService implements CinemaManagementService {
    @Override
    public void cinemaManagement() {
        try {
            int cinemaManagementOption = cinemaEntryMenu();
            CinemaService cinemaService = new ICinemaService();
            switch (cinemaManagementOption) {
                case 0:
                    System.exit(-1);
                    break;
                case 1:
                    cinemaService.addFilm();
                    break;
                case 2:
                    cinemaService.updateFilm();
                    break;
                case 3:
                    cinemaService.deleteFilm();
                    break;
                case 4:
                    cinemaService.showFilm();
                    break;
                case 5:
                    cinemaService.searchFilm();
                    break;
                default:
                    throw new InvalidOption(ExceptionEnum.INVALID_OPTION);
            }
        } catch (FilmNotFound | CustomerNotFound | InvalidOption | EmptyList exception) {
            System.out.println(exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
