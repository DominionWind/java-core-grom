package gromcode.main.lesson20.task2.exeption;

public class LimitExceeded extends BadRequestException{

    public LimitExceeded(String message) {
        super(message);
    }
}
