
package Bran;
import java.util.Date;
/**
 *
 * @author Roukaya
 */
public class Branch {
     
 private int  brhid;
 private String  brhname;
private int brhcity;
private String brhaddress;
private String brhemail;
private String brhphone;
private String brhfax;
private String brhmobile;
private Boolean brhisactive;
 
private Date brhdeactivatesince;
private Date brhactivatedsince;
    
    public int getbrhid(){
        return brhid;
    }
    public void setbrhid(int brhid){
        this.brhid = brhid;
    }
    
    public String getbrhname(){
        return brhname;
    }
    public void setbrhname(String brhname){
        this.brhname = brhname;
    }
    
     public int getbrhcity(){
        return brhcity;
    }    
    public void setbrhcity(int brhcity){
        this.brhcity = brhcity;
    }
    
     public String getbrhaddress(){
        return brhaddress;
    }   
    public void setbrhaddress(String brhaddress){
        this.brhaddress = brhaddress;
    }
    
     public String getbrhemail(){
        return brhemail;
    }    
    public void setbrhemail(String brhemail){
        this.brhemail = brhemail;
    }
    
     public String getbrhphone(){
        return brhphone;
    }    
    public void setbrhphone(String brhphone){
        this.brhphone = brhphone;
    }
    
     public String getbrhfax(){
        return brhfax;
    }   
    public void setbrhfax(String brhfax){
        this.brhfax = brhfax;
    }
    
     public String getbrhmobile(){
        return brhmobile;
    }
    
    public void setbrhmobile(String brhmobile){
        this.brhmobile = brhmobile;
    }
        public Boolean getbrhisactive(){
        return brhisactive;
    }
        
    public void setbrhisactive(Boolean brhisactive){
        this.brhisactive = brhisactive;
    }
      public Date getbrhactivatedsince(){
        return brhactivatedsince;
    }
    
    public void setbrhactivatesince(Date brhactivatedsince){
        this.brhactivatedsince = brhactivatedsince;
    }
    
        public Date getbrhdeactivatedsince(){
        return brhdeactivatedsince;
    }
    
    public void setbrhdeactivatedsince(Date brhdeactivatedsince){
        this.brhdeactivatedsince = brhdeactivatedsince;
    }
   
}
