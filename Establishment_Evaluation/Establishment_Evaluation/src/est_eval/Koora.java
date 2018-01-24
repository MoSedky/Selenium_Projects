package est_eval;

import java.util.Calendar;
import java.util.Timer;

public class Koora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer t=new Timer();
	    Calendar date = Calendar.getInstance();
	    date.set(
	      Calendar.DAY_OF_WEEK,
	      Calendar.SUNDAY
	    );
	    date.set(Calendar.HOUR, 0);
	    date.set(Calendar.MINUTE, 0);
	    date.set(Calendar.SECOND, 0);
	    date.set(Calendar.MILLISECOND, 0);
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	    // Schedule to run every Sunday in midnight
	    Login_Page L=new Login_Page();
	   // t.schedule
	 //   t.scheduleAtFixedRate(L, 0, 900000);

	}

}
