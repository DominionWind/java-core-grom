package gromcode.main.lesson20.task1.exeption;

public class BadRequestException extends Exception{

    public BadRequestException(String message) {
        super(message);
    }
}
