package helper;
import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.FilmNotFound;
import globalData.GlobalData;
import model.Cinema;
import model.Customer;
import model.Customer.*;

import java.time.LocalDate;
import java.time.LocalTime;

import static helper.CinemaServiceHelper.*;
import static util.InputUtil.*;

public class CustomerServiceHelper {
    static int countIndex = 0;
    private static int customerId = 0;

    public static void signUpHelper(){
        Customer customer = fillCustomer();
        if (customer != null) {
            GlobalData.customers[countIndex] = customer;
            countIndex++;
        }
    }

    public static Customer fillCustomer(){
        try {
            String name = stringInput("Enter the name: ");
            String surname = stringInput("Enter the surname: ");
            String username = stringInput("Enter the username: ");
            String password = stringInput("Enter the password: ");
            double bankAccountAmount = doubleInput("Enter the amount: ");
            return new Customer(++customerId,name,surname,username,password,bankAccountAmount);
        } catch (RuntimeException exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
    public static void filmBuyHelper(Customer customer) {
        String filmName = stringInput("Which film do you want to buy: ");
        boolean isTrue = false;

        for (int i = 0; i < GlobalData.cinemas.length; i++) {
            Cinema cinema = GlobalData.cinemas[i];
            if (cinema.getFilmName().equals(filmName) && cinema.getTicketCount() > 0 && cinema.getVisionStatus() == 1){
                cinema.setTicketCount(cinema.getTicketCount() - 1);
                customer.setCustomerId(cinema.getFilmId());
                isTrue = true;
                System.out.println(StatusEnum.TICKET_TO_FILM_HAVE_BOUGHT_SUCCESSFULLY);
                break;
            }
        }
        if (!isTrue) {
            throw new FilmNotFound(ExceptionEnum.FILM_NOT_FOUND);
        }
//        for (int i = 0; i < GlobalData.cinemas.length; i++) {
//            if (GlobalData.cinemas[i].getFilmName().equals(filmName)
//            && GlobalData.cinemas[i].getTicketCount() != 0
//            && GlobalData.cinemas[i].getVisionStatus() == 1){
//                GlobalData.cinemas[i].setTicketCount(GlobalData.cinemas[i].getTicketCount() - 1);
//                GlobalData.customers[count].setCustomerId((GlobalData.cinemas[i].getFilmId()));
//                isTrue = true;
//                System.out.println(StatusEnum.TICKET_TO_FILM_HAVE_BOUGHT_SUCCESSFULLY);
//            }
//        }
        if (!isTrue) {
            throw new FilmNotFound(ExceptionEnum.FILM_NOT_FOUND);
        }
    }
}
