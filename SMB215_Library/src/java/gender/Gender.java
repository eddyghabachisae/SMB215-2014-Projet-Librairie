/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gender;


import gender.*;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class Gender {
    
    private int id;
    private String gender_desc;


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGender(String genderdesc) {
        this.gender_desc = genderdesc;
    }
    public String getGender() {
        return gender_desc;
    }

   
    
}
