/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package purchaseOrderDetail;

/**
 *
 * @author eddy
 */
public class PODetail {
    
    private long item;
    private int quantity;
    private float unitcost;
    private float total;
    private String itemname;
    private long pohid;
    private long id;
    

    public long getItem() {
        return item;
    }

    public void setItem(long item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(float unitcost) {
        this.unitcost = unitcost;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public long getPohid() {
        return pohid;
    }

    public void setPohid(long pohid) {
        this.pohid = pohid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
}
