package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassPage_PF {
	
	String pageSource = "resetaccess"; 

	WebDriver driver;

	public ForgotPassPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, LoginPage_PF.class);
	}

	public void pageSourceEnd() {

		driver.getPageSource().contains(pageSource);
	}

}
