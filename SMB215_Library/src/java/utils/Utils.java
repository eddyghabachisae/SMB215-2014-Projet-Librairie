package utils;

public class Utils {

	
	//str_RemoveLastChar - Removes the last character from a given string 
	public static String str_RemoveLastChar(String str) {
        if (str.length() > 0) {
            str = str.substring(0, str.length()-1);
          }
          return str;
      }
}
