// WebTimeBean.java
// Bean that enables the JSF page to retrieve the time from the server
package Client;

import java.text.DateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;

@ManagedBean( name="webTimeBean" )
public class webTimeBean 
{
   // return the time on the server at which the request was received
   public String getTime()
   {
      return DateFormat.getTimeInstance( DateFormat.LONG ).format(
         new Date() );
   } // end method getTime
} // end class WebTimeBean