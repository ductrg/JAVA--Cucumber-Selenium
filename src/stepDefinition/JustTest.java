package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import cucumber.api.PendingException;
import cucumber.api.java.en.*;

public class JustTest {
	public static WebDriver driver;
	@Given("^a$")
	public void user_is_on_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://backend.evasion.dirox.net/login");
        driver.manage().window().maximize();
	}

	@When("^b as '(.+)' and c as '(.+)'$")
	public void user_enters_UserName_and_Password(String userName, String passWord) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("_username")).sendKeys(userName); 	 
		driver.findElement(By.name("_password")).sendKeys(passWord); 	
	}
	
	@When("^d$")
	public void user_click_submit() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.name("login")).click();
	}
	
	@Then("^e$")
	public void message_displayed_Login_Successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("just test");
		driver.quit();
	}
}
