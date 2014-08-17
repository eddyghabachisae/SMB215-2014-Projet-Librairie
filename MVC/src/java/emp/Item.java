/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emp;

import java.util.Date;

/**
 *
 * @author Elie X2
 */
public class Item {
      private int id;
    private String name;
    private Date datepb;
    private ItemType type;
    
    
    public int getItemId(){
        return id;
    }
    
    public void setItemId(int id){
        this.id = id;
    }
    
    public String getItemName(){
        return name;
    }
    
    public void setItemName(String name){
        this.name = name;
    }
    
    public Date getItemDatepb(){
        return datepb;
    }
    
    public void setItemDatepb(Date datepb)
    {
    this.datepb=datepb;
    }
    
    public ItemType getItemType()
    {
        return this.type;
    }
    
    public void setItemType(ItemType type){
        this.type=type;
    }
    
}
