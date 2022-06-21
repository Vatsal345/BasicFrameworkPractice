package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

public class LoginTest {

	 LoginPage lp = new LoginPage();
	 DataFile df = new DataFile();
	  
	  
	  @BeforeMethod
	  public void beforeMethod() throws IOException {
		  
		 lp.openBrowser();
		 lp.openLoginPage();
	  }

		@AfterMethod
		public void afterMethod() {

		lp.closeBrowser();
		
		}
		
		
	  
	  @Test (priority = 1)
		  public void loginWithWrongEmailPasswordTest() throws InterruptedException {
			lp.login(df.wrongEmail, df.wrongPass);
			String expectedErrMsg = df.globalErr;
			String actualErrMsg = lp.readGlobalError();
			System.out.println(actualErrMsg);
			Assert.assertEquals(actualErrMsg, expectedErrMsg);
		  }
	  
	  @Test (priority = 2)
	  public void LoginWithEmptyEmailTest() throws InterruptedException {
		  
		  lp.login("", df.wrongPass); 
		  String expectedErrorMsg = df.emptyEmailErr;
		  String actualErrorMsg = lp.readError();
		  System.out.println(actualErrorMsg);
			 
		  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		  
		  
	  }
	  
	 @Test (priority = 3)
	  public void LoginWithEmptyPasswordTest() throws InterruptedException {
		  
		  lp.login(df.wrongEmail, "");
			 
		  String expectedErrorMsg = df.emptyPasswordErr;
		  String actualErrorMsg = lp.readError();
		  System.out.println(actualErrorMsg);
			 
		  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		  
		  
	  }

	  @Test (priority = 4)
	  public void LoginWithSpecialCharTest() throws InterruptedException {
		  
		  lp.login(df.emailWithSpecialChar, df.wrongPass);
			 
		  String expectedErrorMsg = df.emailWithSpecialCharErr;
		  String actualErrorMsg = lp.readError();
		  System.out.println(actualErrorMsg);
			 
		  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		  
		  
	}
	}

