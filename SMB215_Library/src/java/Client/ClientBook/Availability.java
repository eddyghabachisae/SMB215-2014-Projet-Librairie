package Client.ClientBook;

import Book.*;
import Item.Item;
import Item.ItemBean;
import java.sql.Date;



public class Availability {

    private long book_id;
    private long item_id;
    private String item_name;
    private String book_title;
    private String wrh_name;
    private String brh_name;
    private String cty_name;
    private int itm_minlimit;
    private int itm_maxlimit;
    private int itm_quantity;




    

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }   

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getWrh_name() {
        return wrh_name;
    }

    public void setWrh_name(String wrh_name) {
        this.wrh_name = wrh_name;
    }

    public String getBrh_name() {
        return brh_name;
    }

    public void setBrh_name(String brh_name) {
        this.brh_name = brh_name;
    } 

    public String getCty_name() {
        return cty_name;
    }

    public void setCty_name(String cty_name) {
        this.cty_name = cty_name;
    } 
    
    public Integer getItm_minlimit() {
        return itm_minlimit;
    }

    public void setitm_minlimit(Integer itm_minlimit) {
        this.itm_minlimit = itm_minlimit;
    } 
    
    public Integer getItm_maxlimit() {
        return itm_maxlimit;
    }

    public void setItm_maxlimit(Integer itm_maxlimit) {
        this.itm_maxlimit = itm_maxlimit;
    } 
    
    public Integer getItm_quantity() {
        return itm_quantity;
    }

    public void setItm_quantity(Integer itm_quantity) {
        this.itm_quantity = itm_quantity;
    } 
    
}
