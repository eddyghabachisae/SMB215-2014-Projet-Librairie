package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

	
	//str_RemoveLastChar - Removes the last character from a given string 
	public static String str_RemoveLastChar(String str) {
        if (str.length() > 0) {
            str = str.substring(0, str.length()-1);
          }
          return str;
      }
        
        public static Date getDateFromString(String dateStr) throws ParseException {
	if (dateStr == null || dateStr.length() == 0)
	    return null;
        dateStr+=" 00:00";
	Calendar c = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	c.setTime(sdf.parse(dateStr));
	return c.getTime();
    }
}
