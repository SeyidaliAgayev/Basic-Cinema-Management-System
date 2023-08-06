package service.impl;

import enums.ExceptionEnum;
import exceptions.CustomerNotFound;
import exceptions.EmptyList;
import exceptions.FilmNotFound;
import exceptions.InvalidOption;
import service.BaseManagementService;

import static util.MenuUtil.firstEntryMenu;

public class IBaseManagementService implements BaseManagementService {
    @Override
    public void baseManagement() {
        while (true) {
            try {
                int baseManagementOption = firstEntryMenu();
                ICinemaManagementService cinemaService = new ICinemaManagementService();
                ICustomerManagementService customerService = new ICustomerManagementService();
                switch (baseManagementOption) {
                    case 1:
                        cinemaService.cinemaManagement();
                        break;
                    case 2:
                        customerService.customerManagement();
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
}
