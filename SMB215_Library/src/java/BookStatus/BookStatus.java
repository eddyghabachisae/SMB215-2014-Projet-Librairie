package BookStatus;




public class BookStatus {

    private long id;
    private int  reservedCopies;
    private String section;
    private String shelf;
    private long branch_id;

    @Override
    public String toString() {
        return "BookStatus{" + "id=" + id + ", reservedCopies=" + reservedCopies + ", section=" + section + ", shelf=" + shelf + ", branch_id=" + branch_id + '}';
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

   

   

    

}
