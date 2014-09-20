package branch;

import java.util.Date;
import java.util.logging.Logger;

public class Branch {
    
    private long id;
    private String name;
    private int city;
    private String address;
    private String email;
    private String phone;
    private String fax;
    private String mobile;
    private boolean isActive;
    private Date activeSince;
    private Date deactivatedSince;

    @Override
    public String toString() {
        return "Branch{" + "id=" + id + ", name=" + name + ", city=" + city + ", address=" + address + ", email=" + email + ", phone=" + phone + ", fax=" + fax + ", mobile=" + mobile + ", isActive=" + isActive + ", activeSince=" + activeSince + ", deactivatedSince=" + deactivatedSince + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getActiveSince() {
        return activeSince;
    }

    public void setActiveSince(Date activeSince) {
        this.activeSince = activeSince;
    }

    public Date getDeactivatedSince() {
        return deactivatedSince;
    }

    public void setDeactivatedSince(Date deactivatedSince) {
        this.deactivatedSince = deactivatedSince;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Branch other = (Branch) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
