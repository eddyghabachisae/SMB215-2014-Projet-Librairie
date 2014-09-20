package BookStatus;

import Book.Book;
import Book.BookBean;
import branch.Branch;
import branch.BranchBean;




public class BookStatus {

    private long id;
    private int  reservedCopies;
    private String section;
    private String shelf;
    private long branch_id;
    private long book_id;

    @Override
    public String toString() {
        return "BookStatus{" + "id=" + id + ", reservedCopies=" + reservedCopies + ", section=" + section + ", shelf=" + shelf + ", branch_id=" + branch_id + ", book_id=" + book_id + '}';
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public long getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(long branch_id) {
        this.branch_id = branch_id;
    }

   

    public long getId() {
        return id;
    }

    public int getReservedCopies() {
        return reservedCopies;
    }

    public String getSection() {
        return section;
    }

    public String getShelf() {
        return shelf;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setReservedCopies(int reservedCopies) {
        this.reservedCopies = reservedCopies;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

   public Branch getBranch(){
       BranchBean branchBean = new BranchBean();
       Branch branch = branchBean.getBranch(this.branch_id);
       return branch;
   }

   public Book getBook(){
   BookBean bookBean = new BookBean();
   Book book = bookBean.getBook(this.book_id);
   return book;
   }
   

    

}
