package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PF {
	
	String pageSource = "customer/account"; 

	WebDriver driver;

	public HomePage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, LoginPage_PF.class);
	}

	public void pageSourceEnd() {

		driver.getPageSource().contains(pageSource);
	}

}
