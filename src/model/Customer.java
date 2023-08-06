package model;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerSurname;
    private String username;
    private String password;
    private double bankAccountAmount;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerSurname, String username, String password, double bankAccountAmount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.username = username;
        this.password = password;
        this.bankAccountAmount = bankAccountAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBankAccountAmount() {
        return bankAccountAmount;
    }

    public boolean setBankAccountAmount(double bankAccountAmount) {
        this.bankAccountAmount = bankAccountAmount;
        return false;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bankAccountAmount=" + bankAccountAmount +
                '}';
    }
}
