package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class LogIn {
	public static WebDriver driver;
	@Given("^User is on LogIn Page$")
	public void user_is_on_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://backend.evasion.dirox.net/login");
        driver.manage().window().maximize();
	}

	@When("^User input UserName as '(.+)' and Password as '(.+)'$")
	public void user_enters_UserName_and_Password(String userName, String passWord) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("_username")).sendKeys(userName); 	 
		driver.findElement(By.name("_password")).sendKeys(passWord); 	
	}
	
	@When("^User click submit$")
	public void user_click_submit() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.name("login")).click();
	}
	
	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String helloMessage = driver.findElement(By.xpath("//div[@class='mdl-layout__header-row']//span[@class='mdl-layout-title']")).getText();
		System.out.println(helloMessage);
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("nav_profile")).click();
		driver.findElement(By.id("logout")).click();		
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String loginMessage = driver.findElement(By.xpath("//h1")).getText();
		System.out.println(loginMessage);
		driver.quit();
	}
}
