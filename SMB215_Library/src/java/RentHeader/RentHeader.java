package RentHeader;



import Client.ClientBean;
import RentDetails.RentDetails;
import RentDetails.RentDetailsBean;
import java.sql.Date;
import java.util.List;



public class RentHeader {

    private long id;
    private Date submitDate;
    private double total;
    private long customer_id;
    private long employee_id;
    private long branch_id;

    @Override
    public String toString() {
        return "RentHeader{" + "id=" + id + ", submitDate=" + submitDate + ", total=" + total + ", customer_id=" + customer_id + ", employee_id=" + employee_id + ", branch_id=" + branch_id + '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public void setBranch_id(long branch_id) {
        this.branch_id = branch_id;
    }

    public long getId() {
        return id;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public double getTotal() {
        return total;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public long getBranch_id() {
        return branch_id;
    }

    public int getBooksNb(){
    int booksNb = 0;
    RentDetailsBean rentDetBean = new RentDetailsBean();
    List<RentDetails> detailsList = rentDetBean.getRentDetailss(this.id);
    booksNb= detailsList.size();
    return booksNb;
    }
    
     public String getCutomerName(){
    String name = "customer not linked !";
    return name;
    }

 
    

}
