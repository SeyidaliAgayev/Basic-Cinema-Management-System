package service;

public interface CustomerService {
    boolean signUp();
    boolean logIn();
    boolean update();
    boolean delete();
    void show();
    void search();
}
