package client;

public class Client {
    
    private int id;
    private String name;
    private String website;
    private String remarks;
    private boolean isactive;
    private String deactivationreason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public String getDeactivationreason() {
        return deactivationreason;
    }

    public void setDeactivationreason(String deactivationreason) {
        this.deactivationreason = deactivationreason;
    }
    
}
