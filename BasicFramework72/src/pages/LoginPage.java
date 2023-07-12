package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	/*WebElement email = driver.findElement(By.name("usernameInput"));
	WebElement password = driver.findElement(By.name("password"));
	WebElement signInButton = driver.findElement(By.id("signIn"));
	WebElement emailErr = driver.findElement(By.id("UsernameTextField__errors-usernameInput"));
	WebElement passwordErr = driver.findElement(By.id("PasswordTextField__errors-password"));
	WebElement globalErr = driver.findElement(By.id("globalError"));
	*/
	
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement signInButton;
	
	@FindBy(id = "globalError")
    public WebElement globalErr;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
    public WebElement emailErr;
	
	@FindBy(id = "PasswordTextField__errors-password")
    public WebElement passwordErr;
	
	public void openBrowser() throws IOException {

		FileInputStream fi = new FileInputStream("C:\\QA\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(fi);
		
		String browser = prop.getProperty("browser");
		
		//String browser = "Chrome"; //Chrome, Safari //Read browser value from data file, excel or Properties
		//WebDriver driver;
		
		if(browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}else {
			driver = new SafariDriver();
		}
		PageFactory.initElements(driver, this);
		
	}
	
	public void openLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=Zb_MB93Zrho&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5nb29nbGUuY29tXC8iLCJvYXV0aF9rZXkiOiJaYl9NQjkzWnJobyIsImNvbnNlbnRfcmVxdWlyZWQiOmZhbHNlLCJyZWRpcmVjdF91cmkiOiJodHRwczpcL1wvd3d3LnNjb3RpYW9ubGluZS5zY290aWFiYW5rLmNvbVwvb25saW5lXC9sYW5kaW5nXC9vYXV0aGxhbmRpbmcuYm5zIiwiZXhwIjoxNjgxMDcxMzcwLCJpYXQiOjE2ODEwNzAxNzAsImp0aSI6IjJjNWE2Mzc4LTY3ZGYtNGQ1Yi04MmU3LTUwOWViZDViNmE0NSIsImNsaWVudF9pZCI6IjhlZTkwYzM5LTFjNTItNGZmNC04YWU2LWE3YjU0YzUzOTkzMyIsImNsaWVudF9tZXRhZGF0YSI6eyJDaGFubmVsSUQiOiJTT0wiLCJBcHBsaWNhdGlvbkNvZGUiOiJINyJ9LCJpc3N1ZXIiOiJodHRwczpcL1wvcGFzc3BvcnQuc2NvdGlhYmFuay5jb20ifQ.GnbcuYLzviuZ8mIigIx-bhSrxmazR0EqRAqKqshHZE6imihrKgrFhg2rmBUhE-d9y1SDSP-AVlxQvCmL3_pvda_pQMzxZ7jEt-CwZgcg5g9a5snCO9kzsw64VxAplVBSfW3jE5YdN-3PnsqcZeMeC_Sr-6Q3a1b1o_YlmdlP7mLH6e-g9u2HPRGv22vS6OHh9piMvPuz3TgfZ0LTB0FdUZpj9vY0g0L4C46-18GfPndWfZ0zK-F0aO3jjxr62vUo5sRv90Dw8W83Zq4MZmoi2LI_aJUfoGj5oi3Hr9HKlz1piqC8M0KH4bPdbzl4OW_iquhBRcJuHMdZoat_FiCLbA&preferred_environment="); 

	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void login(String a, String b) throws InterruptedException {

		email.sendKeys(a);
		password.sendKeys(b);
		signInButton.click();
		Thread.sleep(3000);
	}
	
	public String readEmailErr() {
		String actualErr = emailErr.getText();
		System.out.println(actualErr);
		return actualErr;
		
	}
	
	public String readPasswordErr() {
		String actualErr = passwordErr.getText();
		System.out.println(actualErr);
		return actualErr;
		
	}
	
	public String readGlobalErr() {
		String actualErr = globalErr.getText();
		System.out.println(actualErr);
		return actualErr;
		
	}

}
