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
    private String status;
    private String suppliername;
    private String branchname;
    private String employeename;
    private long supplier;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(Date shippingdate, Date deliverydate) {
        if (deliverydate != null){
            this.status = "Delivered";
        } else if (shippingdate != null) {
            this.status = "Shipped";
        } else {
            this.status = "Ordered";
        }
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public long getSupplier() {
        return supplier;
    }

    public void setSupplier(long supplier) {
        this.supplier = supplier;
    }
    
    
    
}
