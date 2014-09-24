/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client;

import java.text.DateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="webTimeBean")
/**
 *
 * @author dany.wazen
 */
public class webTimeBean {
    public String getTime(){
    return DateFormat.getTimeInstance(DateFormat.LONG).format(new Date());
}
}