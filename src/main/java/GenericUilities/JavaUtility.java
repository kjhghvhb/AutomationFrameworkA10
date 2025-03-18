package GenericUilities;


import java.text.SimpleDateFormat;
import java.util.Date;






/**
 * this class consists of generic methods related to java
 * @author Lavanya.M
 */

public class JavaUtility  
{
	/**
	 * this method will capture the current system date and return to caller
	 * used to name screenshot and reports
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		 String date = f.format(d);
		return date;
		
		
	}
	

}
