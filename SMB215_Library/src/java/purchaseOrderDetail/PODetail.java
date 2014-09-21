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
    private long quantity;
    private float unitcost;
    private float total;

    public long getItem() {
        return item;
    }

    public void setItem(long item) {
        this.item = item;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
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
    
    
    
}
