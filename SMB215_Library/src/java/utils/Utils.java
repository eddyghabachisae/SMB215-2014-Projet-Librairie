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
        
        public static Date getNowDateTime() {
		Calendar currentDate = Calendar.getInstance();
		return currentDate.getTime();
	}
        
        public static long getDifferenceBetween(Date date1, Date date2){
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
             cal1.setTime(date1);
             cal2.setTime(date2);
            long milis1 = cal1.getTimeInMillis();
            long milis2 = cal2.getTimeInMillis();
            long diff = milis2 - milis1;
            long diffDays = diff / (24 * 60 * 60 * 1000);
            return diffDays;
        }
}
