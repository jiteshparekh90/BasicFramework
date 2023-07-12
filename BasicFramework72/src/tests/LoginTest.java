package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import data.DataFile;
import utilities.Xls_Reader;



public class LoginTest {
	
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
	//String wrongEmail = "dsjhhjdshj";
	//String emailWithSpecialChar = "dsjhhdjshjdh@$#";
	//String wrongPassword = "dgsgdsjhdhsa";
	//String specialCharErr = "Please enter a username or card number without special characters.";
	//String emptyEmailErr = "Please enter your username or card number.";
	//String emptyPasswordErr = "Please enter your password.";
	//String globalErr = "Please check your card number / username or password and try again.";
	
	
	 
	 
 
  @BeforeMethod
  public void beforeMethod() throws IOException {
	 
	  lp.openBrowser();
	  lp.openLoginPage();
	  
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  lp.closeBrowser();
  }
  
  @Test (priority =1)
  public void loginWithSpecialCharEmailTest() throws InterruptedException {
	  
	 
	  	lp.login(df.emailWithSpecialChar, df.wrongPassword);
	    String expectedErr = df.specialCharErr;
		String actualErr = lp.readEmailErr();
		Assert.assertEquals(actualErr, expectedErr);
		
	/*  System.out.println(wrongEmail);
	  System.out.println(emailWithSpecialChar);
	  System.out.println(wrongPassword);
	  System.out.println(specialCharErr);
	  System.out.println(emptyEmailErr);
	  System.out.println(emptyPasswordErr);
	  System.out.println(globalErr);
	  */
	}
  
  @Test (priority =2)
  public void loginWithEmptyEmailTest() throws InterruptedException {
	  
	 
	  	lp.login("", df.wrongPassword);
	  //  String expectedErr = df.emptyEmailErr;
	//	String actualErr = lp.readEmailErr();
		Assert.assertEquals(lp.readEmailErr(), df.emptyEmailErr);
		
	}
  
  @Test (priority =3)
  public void loginWithEmptyPasswordEmailTest() throws InterruptedException {
	  
	 
	  	lp.login(df.wrongEmail, "");
	   // String expectedErr = df.emptyPasswordErr;
	    
		//String actualErr = lp.readPasswordErr();
		Assert.assertEquals(lp.readPasswordErr(), df.emptyPasswordErr);
		
	}
  
  @Test (priority =4)
  public void loginWithWrongEmailidandpasswordTest() throws InterruptedException {
	  
	 
	  	lp.login(df.wrongEmail, df.wrongPassword);
	    //String expectedErr = df.globalErr;
		//String actualErr = lp.readGlobalErr();
		Assert.assertEquals(lp.readGlobalErr(), df.globalErr);
		
	}

}
