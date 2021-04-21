package Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pagefactory.ForgotPassPage_PF;
import pagefactory.HomePage_PF;
import pagefactory.LoginPage_PF;

public class LoginSteps {

	WebDriver driver = null;
	LoginPage_PF login;
	HomePage_PF home;
	ForgotPassPage_PF resetPass;

	@Before
	public void browserSetup() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver");

		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {

		//System.out.println("Inside Step - user is on login page"); 

		driver.navigate().to("https://secure-sandbox.modulrfinance.com/");

	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {

		//System.out.println("Inside Step - user enters username and password"); 

		login = new LoginPage_PF(driver);

		login.enterUsername(username);
		login.enterPassword(password);


		Thread.sleep(2000);

	}

	@And("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException{

		//System.out.println("Inside Step - clicks on login button"); 

		login.clickSignIn();

		Thread.sleep(10000);

	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page(){

		//System.out.println("Inside Step - user is navigated to the home page"); 

		home = new HomePage_PF(driver);

		home.pageSourceEnd();

	}
	
	@And("clicks on forgotten password")
	public void clicks_on_forgotten_password() throws InterruptedException {
		login = new LoginPage_PF(driver);
		login.clickForgotPass();
		Thread.sleep(10000);
	}

	@Then("user is navigated to the reset access page")
	public void user_is_navigated_to_the_reset_access_page(){

		//System.out.println("Inside Step - user is navigated to the home page"); 

		resetPass = new ForgotPassPage_PF(driver);
		resetPass.pageSourceEnd();

	}

	@Then("user should see error")
	public void user_should_see_error() {

		login.checkErrIsDisplayed();
	}

	@Then("user should see required fields error")
	public void user_should_see_required_fields_error() {

		login.checkReqFieldDisplayed();
	}


}
