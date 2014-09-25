/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supplierBranchItem;

/**
 *
 * @author eddy
 */
public class SupplierBranchItem {
    
    private long id;
    private long supplierbranch;
    private long item;
    private int shippingdays;
    private float price;
    private String itemname;
    private float secondaryprice;
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSupplierbranch() {
        return supplierbranch;
    }

    public void setSupplierbranch(long supplierbranch) {
        this.supplierbranch = supplierbranch;
    }

    public long getItem() {
        return item;
    }

    public void setItem(long item) {
        this.item = item;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getShippingdays() {
        return shippingdays;
    }

    public void setShippingdays(int shippingdays) {
        this.shippingdays = shippingdays;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public float getSecondaryprice() {
        return secondaryprice;
    }

    public void setSecondaryprice(float secondaryprice) {
        this.secondaryprice = secondaryprice;
    }
    
    
    
}
