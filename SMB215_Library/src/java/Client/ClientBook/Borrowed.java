package Client.ClientBook;

import Book.*;
import Item.Item;
import Item.ItemBean;
import java.sql.Date;



public class Borrowed {

    private String bok_title;
    private String bok_subtitle;
    private Boolean returned;
    private Date reservation_date;
    

    public String getBok_title() {
        return bok_title;
    }

    public void setBok_title(String bok_title) {
        this.bok_title = bok_title;
    }

    public String getBok_subtitle() {
        return bok_subtitle;
    }

    public void setBok_subtitle(String bok_subtitle) {
        this.bok_subtitle = bok_subtitle;
    }    
    
    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }  
        
    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    } 
}
