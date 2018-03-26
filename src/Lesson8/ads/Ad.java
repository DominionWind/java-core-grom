package Lesson8.ads;

import java.util.Date;

public class Ad extends BaseEntity {
    int price;
    Date dateCreated;

    public Ad(long id, int price) {
        super(id);
        this.price = this.price;
        this.dateCreated = new Date();
    }

    void publichAd(){
        //some logic
    }
}
