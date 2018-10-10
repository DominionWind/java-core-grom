package gromcode.main.lesson8.ads;

import java.util.Date;

public class Message extends BaseEntity{
    String message;
    User userFrom;
    User userTo;
    Date dateSent;
    Date dateRead;

    public Message(long id, String message, User userFrom, User userTo) {
        super(id);
        this.message = message;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.dateSent = new Date();
    }

    void setDateRead (){
        dateRead = new Date();
    }

    boolean isread(){
        //    if (dateRead == null)
        //        return false;
        //    return true;
        return dateRead == null;
    }
}
