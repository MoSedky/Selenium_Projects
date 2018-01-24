package automated_HLS;


import org.testng.TestNG;

public class Requests {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		create_Voc_request c=new create_Voc_request();
		c.setUp();
		c.testCal();
		
		TestNG testng = new TestNG();
        Class[] classes = new Class[]{create_Voc_request.class};
        testng.setTestClasses(classes);
        testng.run();
		
		

	}

}
