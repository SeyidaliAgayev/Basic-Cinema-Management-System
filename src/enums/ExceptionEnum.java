package enums;
public enum ExceptionEnum {
    EMPTY_LIST("Empty List!"),
    FILM_NOT_FOUND("Film Not Found!"),
    INVALID_OPTION("Invalid Option!"),
    CUSTOMER_NOT_FOUND("Customer Not Found!");

    private String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
