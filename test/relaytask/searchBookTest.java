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
class searchBookTest {
	static Logger logger = Logger.getLogger("MyLog");  
    static FileHandler fh; 
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 try {  

		        // This block configure the logger with handler and formatter  
		        fh = new FileHandler("searchBookTest.log");  
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
		logger.info("##########   search and book Test  ################");
		logger.info("###################################################");
		
		logger.info("I will create a new user for test called testrobot");
		String username = "testrobot";
		String gender = "Male";
		String age = "30";
		String output = inpVer.registerButton(username, gender, age);
		assertEquals(output,"1");
		output = butOp.registerOperButton(username, gender, age);
		assertEquals(output,"New user is added successfully");
		logger.info("A new user is add successfully");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		logger.info("I will try to login with the new user");
		String input = "testrobot";
		output = inpVer.loginButton(input);
		assertEquals(output,"1");
		output = butOp.loginOperButton(input);
		assertEquals(output,butOp.getUserobj().getUsername()+" is login successfully");
		logger.info("I can login with the testrobot");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		logger.info("I will search for avilabel car with model4, engine 1 and current location is location1");
		output = butOp.search("", "model4", "engine1", "", "", "location1", "", "");
		System.out.println(output);
		assertNotEquals(output,"");
		logger.info("I can find all the cars i need");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		logger.info("I will try to book the first car in the list");
		output = inpVer.bookButton(butOp.getCarlist().get(0).getCurloc(), "location2", "2018-09-08", "2018-09-10", Integer.toString(butOp.getCarlist().get(0).getCarid()));
		System.out.println(output);
		assertEquals(output,"1");
		output = butOp.bookOperButton(butOp.getCarlist().get(0).getCurloc(), "location2", "2018-09-08", "2018-09-10", Integer.toString(butOp.getCarlist().get(0).getCarid()));
		System.out.println(output);
		logger.info("I can Book the car");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		logger.info("I will try to update my drop location in my demand");
		output = butOp.showdemOperButton();
		System.out.println(output);
		assertNotEquals(output,"");
		output = inpVer.updatedemButton(Integer.toString(butOp.getDemlist().get(0).getDemandid()), "location3", "2018-09-08", "2018-09-10");
		System.out.println(output);
		assertEquals(output,"1");
		
		output = butOp.updatedemOperButton(Integer.toString(butOp.getDemlist().get(0).getDemandid()), "location3", "2018-09-08", "2018-09-10");
		System.out.println(output);
		assertEquals(output,"Demand updated successfully");
		logger.info("I can update my demand");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		logger.info("I will try to Now to remove my demand");
		output = inpVer.removedemButton(Integer.toString(butOp.getDemlist().get(0).getDemandid()));
		assertEquals(output,"1");
		output = butOp.removedemOperButton(Integer.toString(butOp.getDemlist().get(0).getDemandid()));
		assertEquals(output,"Demand removed");
		logger.info("I can removed my demand");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		logger.info("I will remove my account");
		input = "testrobot";
		output = butOp.deregisterOperButton();
		assertEquals(output,"User removed successfully");
		logger.info("I can remove my account");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		logger.info("--------------------------------------------------------------------");
	}

}
