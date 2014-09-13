
package Warehouse;

public class Warehouse {
    
    private int id;
      private int quantity;
    private Double salerentprice;
    private int minlimit;
    private int maxlimit;
      private boolean isavailable;
    private boolean isactive;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getSalerentprice() {
        return salerentprice;
    }

    public void setSalerentprice(Double salerentprice) {
        this.salerentprice = salerentprice;
    }

    public int getMinlimit() {
        return minlimit;
    }

    public void setMinlimit(int minlimit) {
        this.minlimit = minlimit;
    }

     public int getMaxlimit() {
        return maxlimit;
    }

    public void setMaxlimit(int maxlimit) {
        this.maxlimit = maxlimit;
    }
    
     public boolean getIsavailable() {
        return isavailable;
    }

    public void setIsavailable(boolean isavailable) {
        this.isavailable = isavailable;
    }
    public boolean IsIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

  
}
