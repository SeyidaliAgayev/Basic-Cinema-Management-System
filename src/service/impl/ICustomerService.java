package service.impl;

import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.CustomerNotFound;
import exceptions.EmptyList;
import exceptions.FilmNotFound;
import exceptions.InvalidOption;
import globalData.GlobalData;
import model.Customer;
import service.CustomerService;
import static util.InputUtil.*;
import static helper.CustomerServiceHelper.*;
import static util.MenuUtil.filmVisionStatusMenu;

public class ICustomerService implements CustomerService {
    @Override
    public boolean signUp() {
        int customerCount = intInput("How many customer will be registered: ");

        if (GlobalData.customers == null) {
            GlobalData.customers = new Customer[customerCount];
            for (int i = 0; i < GlobalData.customers.length; i++) {
                signUpHelper();
            }
            System.out.println(StatusEnum.SIGN_UP_SUCCESSFULLY);
        } else {
            Customer[] tempCustomer = GlobalData.customers;
            GlobalData.customers = new Customer[GlobalData.customers.length + customerCount];
            for (int i = 0; i < GlobalData.customers.length; i++) {
                if (i < tempCustomer.length) {
                    GlobalData.customers[i] = tempCustomer[i];
                } else {
                    signUpHelper();
                }
            }
            System.out.println(StatusEnum.SIGN_UP_SUCCESSFULLY);
        }
        int nullCustomerCount = 0;
        for (Customer customer:GlobalData.customers) {
            if (customer == null) {
                nullCustomerCount++;
            }
        }
        Customer[] customers = GlobalData.customers;
        GlobalData.customers = new Customer[GlobalData.customers.length - nullCustomerCount];
        for (int i = 0; i < GlobalData.customers.length; i++) {
            GlobalData.customers[i] = customers[i];
        }
        return true;
    }

    @Override
    public boolean logIn() {
        String username = stringInput("Enter the username: ");
        String password = stringInput("Enter the password: ");
        Customer foundCustomer = null;

        for (int i = 0; i < GlobalData.customers.length; i++) {
            if (GlobalData.customers[i].getUsername().equals(username) && GlobalData.customers[i].getPassword().equals(password)) {
                foundCustomer = GlobalData.customers[i];
                break;
            }
        }
        if (foundCustomer != null) {
            System.out.println(StatusEnum.LOG_IN_SUCCESSFULLY);
            filmBuyHelper(foundCustomer);
            return true;
        } else {
            throw new CustomerNotFound(ExceptionEnum.CUSTOMER_NOT_FOUND);
        }
    }


    @Override
    public boolean update() {
        if (GlobalData.customers == null || GlobalData.customers.length == 0)
            throw new EmptyList(ExceptionEnum.EMPTY_LIST);
        int customerId = intInput("Which customer do you want to update: ");
        boolean isTrue = false;

        for (int i = 0; i < GlobalData.customers.length; i++) {
            if (GlobalData.customers[i].getCustomerId() == customerId){
                String parameter = stringInput("Which information of customer do you want to update: ");
                String[] parameterString = parameter.toLowerCase().split(",");
                for (String str: parameterString) {
                    switch (str) {
                        case "name":
                            GlobalData.customers[i].setCustomerName("Enter the changed name: ");
                            isTrue = true;
                            break;
                        case "surname":
                            GlobalData.customers[i].setCustomerSurname("Enter the changer surname: ");
                            isTrue = true;
                            break;
                        case "username":
                            GlobalData.customers[i].setUsername("Enter the changed username: ");
                            isTrue = true;
                            break;
                        case "password":
                            GlobalData.customers[i].setPassword("Enter the changed password: ");
                            isTrue = true;
                            break;
                        case "bankAccountAmount":
                            GlobalData.customers[i].setBankAccountAmount(Double.parseDouble("Enter the changed amount: "));
                        default:
                            throw new CustomerNotFound(ExceptionEnum.CUSTOMER_NOT_FOUND);
                    }
                }
                if (isTrue){
                    System.out.println(StatusEnum.UPDATE_SUCCESSFULLY);
                } else {
                    throw new CustomerNotFound(ExceptionEnum.CUSTOMER_NOT_FOUND);
                }
            }
        }
        return true;
    }


//    public boolean delete() {
//        if (GlobalData.customers == null || GlobalData.customers.length == 0)
//            throw new EmptyList(ExceptionEnum.EMPTY_LIST);
//        int customerId = intInput("Which customer do you want to delete: ");
//
//        for (int i = 0; i < GlobalData.customers.length; i++) {
//            if (GlobalData.customers[i].getCustomerId() == customerId){
//                Customer[] customers = GlobalData.customers;
//                GlobalData.customers = new Customer[GlobalData.customers.length - 1];
//
//                int k = 0;
//                for (Customer customer:GlobalData.customers) {
//                    if (customer.getCustomerId() == customerId) {
//                        continue;
//                    }
//                    GlobalData.customers[k] = customer;
//                    k++;
//                }
//                System.out.println(StatusEnum.DELETE_SUCCESSFULLY);
//                break;
//            }
//        }
//        return false;
//    }

//    public boolean delete() {
//        if (GlobalData.customers == null || GlobalData.customers.length == 0) {
//            throw new EmptyList(ExceptionEnum.EMPTY_LIST);
//        }
//        int customerId = intInput("Which customer do you want to delete: ");
//
//        for (int i = 0; i < GlobalData.customers.length; i++) {
//            if (GlobalData.customers[i].getCustomerId() == customerId){
//                Customer[] customers = GlobalData.customers;
//                GlobalData.customers = new Customer[GlobalData.customers.length - 1];
//
//                int k = 0;
//                for (Customer customer: GlobalData.customers) {
//                    if (customer.getCustomerId() == customerId) {
//                        continue;
//                    }
//                    GlobalData.customers[k] = customer;
//                    k++;
//                }
//                System.out.println(StatusEnum.DELETE_SUCCESSFULLY);
//                break;
//            }
//        }
//        return false;
//    }

    public Customer deleteById() {
        Customer customer = new Customer();
        if (GlobalData.customers == null) {
            throw new EmptyList(ExceptionEnum.EMPTY_LIST);
        } else {
            int id = intInput("Which customer do you want to delete: ");
            for (int i = 0; i < GlobalData.customers.length; i++) {
                if (GlobalData.customers[i].getCustomerId() == id) {
                    customer = GlobalData.customers[i];
                    break;
                }
            }
        }
        return customer;
    }

    public boolean delete() {
        int id = 0;
        Customer customer = deleteById();
        customer.toString();

        Customer[] tempCustomer = GlobalData.customers;
        GlobalData.customers = new Customer[GlobalData.customers.length - 1];

        for (int i = 0; i < GlobalData.customers.length; i++) {
            if (tempCustomer[i].getCustomerId() < customer.getCustomerId()) {
                GlobalData.customers[i] = tempCustomer[i];
            } else {
                GlobalData.customers[i] = tempCustomer[i+1];
            }
        }
        return true;
    }

    @Override
    public void show() {
        if (GlobalData.customers == null || GlobalData.customers.length == 0){
            throw new EmptyList(ExceptionEnum.EMPTY_LIST);
        }
        for (int i = 0; i < GlobalData.customers.length; i++) {
            System.out.println(GlobalData.customers[i].toString());
        }
    }

    @Override
    public void search() {
        if (GlobalData.customers == null || GlobalData.customers.length == 0){
            throw new EmptyList(ExceptionEnum.EMPTY_LIST);
        }
        String customerSearchName = stringInput("Enter the customer name which you want to search: ");
        for (int i = 0; i < GlobalData.customers.length; i++) {
            if (GlobalData.customers[i].getCustomerName().equals(customerSearchName.toLowerCase())) {
                System.out.println(GlobalData.customers[i].toString());
            } else {
                throw new CustomerNotFound(ExceptionEnum.CUSTOMER_NOT_FOUND);
            }
        }
    }
    }

