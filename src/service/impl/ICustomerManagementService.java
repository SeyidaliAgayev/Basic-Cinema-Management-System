package service.impl;

import enums.ExceptionEnum;
import exceptions.CustomerNotFound;
import exceptions.EmptyList;
import exceptions.FilmNotFound;
import exceptions.InvalidOption;
import service.CustomerManagementService;
import service.CustomerService;

import static util.MenuUtil.customerEntryMenu;

public class ICustomerManagementService implements CustomerManagementService {
    @Override
    public void customerManagement() {
        try {
            int customerManagementOption = customerEntryMenu();
            CustomerService customerService = new ICustomerService();
            switch (customerManagementOption) {
                case 0:
                    System.exit(-1);
                    break;
                case 1:
                    customerService.signUp();
                    break;
                case 2:
                    customerService.logIn();
                    break;
                case 3:
                    customerService.update();
                    break;
                case 4:
                    customerService.delete();
                    break;
                case 5:
                    customerService.search();
                    break;
                case 6:
                    customerService.show();
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
