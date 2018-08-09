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

class AuthenticationTest {
	static Logger logger = Logger.getLogger("MyLog");  
    static FileHandler fh;  
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	    try {  

	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("AuthenticationTest.log");  
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
		logger.info("###########   AuthenticationTest  #################");
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
		
		logger.info("I will try to update the new user");
		age = "50";
		output = inpVer.updateuserinfoButtom(age);
		assertEquals(output,"1");
		
		output = butOp.updateuserinfo("" ,"",age);
		assertEquals(output,"User information are updated successfully relogin with you new information");
		logger.info("The user information is update successfully");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		
		logger.info("I will try to re login with the new info");
		input = "testrobot";
		output = inpVer.loginButton(input);
		assertEquals(output,"1");
		output = butOp.loginOperButton(input);
		assertEquals(output,butOp.getUserobj().getUsername()+" is login successfully");
		logger.info("I can login with the testrobot");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		
		
		logger.info("I will try to logout from my account");
		input = "testrobot";
		output = butOp.logoutOprButton();
		assertEquals(output,"1");
		logger.info("I can logout from my account");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		
		logger.info("I will try to login and remove my account");
		input = "testrobot";
		output = inpVer.loginButton(input);
		assertEquals(output,"1");
		output = butOp.loginOperButton(input);
		assertEquals(output,butOp.getUserobj().getUsername()+" is login successfully");
		output = butOp.deregisterOperButton();
		assertEquals(output,"User removed successfully");
		logger.info("I can remove my account");
		logger.info("test Pass");
		logger.info("--------------------------------------------------------------------");
		logger.info("--------------------------------------------------------------------");		
			
	}

}
