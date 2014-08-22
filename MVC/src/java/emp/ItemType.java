/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emp;


/**
 *
 * @author Elie X2
 */
public class ItemType {
      private int id;
    private String label;
    
    
    public int getTypeId(){
        return id;
    }
    
    public void setTypeId(int id){
        this.id = id;
    }
    
    public String getTypeLabel(){
        return label;
    }
    
    public void setTypeLabel(String label){
        this.label=label;
    }
    
    
}
