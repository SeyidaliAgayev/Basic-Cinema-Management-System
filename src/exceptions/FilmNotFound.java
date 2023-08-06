package exceptions;

import enums.ExceptionEnum;

public class FilmNotFound extends RuntimeException{
    private String message;

    public FilmNotFound(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.message = exceptionEnum.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}