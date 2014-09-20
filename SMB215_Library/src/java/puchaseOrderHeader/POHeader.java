/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puchaseOrderHeader;

import java.sql.Date;

/**
 *
 * @author eddy
 */
public class POHeader {
    
    private long id;
    private Date orderdate;
    private Date shippingdate;
    private Date deliverydate;
    private float total;
    private long branch;
    private long employee;
    private long supplierbranch;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getShippingdate() {
        return shippingdate;
    }

    public void setShippingdate(Date shippingdate) {
        this.shippingdate = shippingdate;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public long getBranch() {
        return branch;
    }

    public void setBranch(long branch) {
        this.branch = branch;
    }

    public long getEmployee() {
        return employee;
    }

    public void setEmployee(long employee) {
        this.employee = employee;
    }

    public long getSupplierbranch() {
        return supplierbranch;
    }

    public void setSupplierbranch(long supplierbranch) {
        this.supplierbranch = supplierbranch;
    }
    
    
}
