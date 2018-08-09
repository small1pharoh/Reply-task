package relaytask;

import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userInterface.buttonOperation;
import userInterface.inputVerification;



class removeCarhasDemandTest {
	static Logger logger = Logger.getLogger("MyLog");  
    static FileHandler fh; 
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		try {  
	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("removeCarhasDemandTest.log");  
	        logger.addHandler(fh);
	        CustomRecordFormatter formatter = new CustomRecordFormatter();  
	        fh.setFormatter(formatter);

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		inputVerification inpVer = new inputVerification();
		buttonOperation butOp = new buttonOperation();
		
		logger.info("###################################################");
		logger.info("######   Remove car has a demand  ################");
		logger.info("###################################################");
		
		logger.info("I will login with an admin user100");
		String input = "user100";
		String output = inpVer.loginButton(input);
		assertEquals(output,"1");
		output = butOp.loginOperButton(input);
		assertEquals(output,butOp.getUserobj().getUsername()+" is login successfully");
		logger.info("I can login with the user100");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		logger.info("The admin will try to add a new car");
		output = inpVer.newCarButton("modeltest", "enginetest", "infottest", "desgintest", "locationTest");
		assertEquals(output,"1");
		output = butOp.newCarOperButton("modeltest", "enginetest", "infottest", "desgintest", "locationTest");
		assertEquals(output,"New car is added");
		logger.info("I can add a new car");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		logger.info("The admin will try to find the new car");
		output = butOp.search("", "modeltest", "enginetest", "", "", "locationtest", "", "");
		System.out.println(output);
		assertNotEquals(output,"");
		logger.info("I can find all the cars i need");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		logger.info("I will try to book the new car");
		output = inpVer.bookButton(butOp.getCarlist().get(0).getCurloc(), "location2", "2018-09-08", "2018-09-10", Integer.toString(butOp.getCarlist().get(0).getCarid()));
		System.out.println(output);
		assertEquals(output,"1");
		output = butOp.bookOperButton(butOp.getCarlist().get(0).getCurloc(), "location2", "2018-09-08", "2018-09-10", Integer.toString(butOp.getCarlist().get(0).getCarid()));
		System.out.println(output);
		logger.info("I can Book the car");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		logger.info("The admin will try to remove the new car");
		output = inpVer.removeCarButton(Integer.toString(butOp.getCarlist().get(0).getCarid()));
		assertEquals(output,"1");
		output = butOp.removeCarOperButton(Integer.toString(butOp.getCarlist().get(0).getCarid()));
		assertEquals(output,"Can not delet car who has a demand");
		logger.info("Can not delet the new car. Error message ((Can not delet car who has a demand))");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		logger.info("I will try to Now to remove my demand");
		output=butOp.showdemOperButton();
		assertNotEquals(output,"");
		output = inpVer.removedemButton(Integer.toString(butOp.getDemlist().get(0).getDemandid()));
		
		assertEquals(output,"1");
		output = butOp.removedemOperButton(Integer.toString(butOp.getDemlist().get(0).getDemandid()));
		
		assertEquals(output,"Demand removed");
		logger.info("I can removed my demand");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		
		logger.info("The admin will try to remove the new car");
		output = butOp.search("", "modeltest", "enginetest", "", "", "locationtest", "", "");
		assertNotEquals(output,"");
		output = inpVer.removeCarButton(Integer.toString(butOp.getCarlist().get(0).getCarid()));
		assertEquals(output,"1");
		output = butOp.removeCarOperButton(Integer.toString(butOp.getCarlist().get(0).getCarid()));
		assertEquals(output,"A car is removed");
		logger.info("I can delet the cars from the list");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		logger.info("--------------------------------------------------------------------");
	}

	
}
