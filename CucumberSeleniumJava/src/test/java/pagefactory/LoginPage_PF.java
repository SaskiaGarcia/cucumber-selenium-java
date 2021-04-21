package pagefactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage_PF {


	@FindBy(id="username-inp")
	WebElement txt_username;

	@FindBy(id="password-inp")
	WebElement txt_password;

	@FindBy(id="forgotPasswordHref")
	WebElement forgot_password;

	@FindBy(className="alert-danger")
	WebElement err_message;

	@FindBy(xpath=("//*[contains(text(),'This field is required')]"))
	WebElement req_message;

	@FindBy(id="signInSubmitButton")
	WebElement btn_signIn;

	WebDriver driver;

	public LoginPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(txt_username));
		txt_username.sendKeys(username);
	}

	public void enterPassword(String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(txt_password));
		txt_password.sendKeys(password);
	}

	public void checkErrIsDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(err_message));
		err_message.isDisplayed();
	}

	public void checkReqFieldDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(req_message));
		req_message.isDisplayed();
	}

	public void clickForgotPass() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(txt_username));
		forgot_password.click();
	}

	public void clickSignIn() {

		btn_signIn.click();
	}

}
