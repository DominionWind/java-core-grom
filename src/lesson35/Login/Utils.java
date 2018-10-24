package lesson35.Login;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.UUID;

public class Utils {

    public long createUniqueId() {
        long id;
        return id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public LocalDate stringToDateConvector(String string) throws ParseException {

        LocalDate date = LocalDate.parse(string);
        return date;
    }


}
