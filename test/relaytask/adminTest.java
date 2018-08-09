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


class adminTest {
	static Logger logger = Logger.getLogger("MyLog");  
    static FileHandler fh; 
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		try {  

	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("logTest.log");  
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
		logger.info("##############    Admin Opeartion  ################");
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
		
		logger.info("The admin will try to remove the new car");
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
