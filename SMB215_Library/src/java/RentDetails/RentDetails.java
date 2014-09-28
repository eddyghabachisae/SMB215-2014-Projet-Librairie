package RentDetails;


import Book.Book;
import Book.BookBean;
import RentHeader.RentHeader;
import RentHeader.RentHeaderBean;
import java.sql.Date;



public class RentDetails {

    private long id;
    private Date returnedDate;
    private long book_id;
    private long rentHeader_id;

    @Override
    public String toString() {
        return "RentDetails{" + "id=" + id + ", returnedDate=" + returnedDate + ", book_id=" + book_id + ", rentHeader_id=" + rentHeader_id + '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public void setRentHeader_id(long rentHeader_id) {
        this.rentHeader_id = rentHeader_id;
    }

    public long getId() {
        return id;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public long getBook_id() {
        return book_id;
    }

    public long getRentHeader_id() {
        return rentHeader_id;
    }
    
    public Book getBook(){
        BookBean bookBean = new BookBean();
        Book book = bookBean.getBook(this.book_id);
        return book;
    }
    
    public RentHeader getRentHeader(){
    RentHeaderBean rentHeaderBean = new RentHeaderBean();
    RentHeader rentHeader = rentHeaderBean.getRentHeader(this.getRentHeader_id());
    return rentHeader;
    }
    

    

}
