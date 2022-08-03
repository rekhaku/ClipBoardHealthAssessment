package amazon.helper;

import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.collections.Predicate;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;
import com.typesafe.config.Config;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.pages.BaseTestPage;
import amazon.pages.HomePage;
import amazon.pages.TelevisionPage;

public class PageHelper {

	private static Config config = EnvFactory.getInstance().getConfig();
	static WebDriver driver = DriverFactory.getDriver();

	public static BaseTestPage launchPage(String text) {

		switch (text) {
		case "Home":
			String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
			driver.get(HOME_PAGE_URL);
			driver.manage().window().maximize();
			return new HomePage(driver.getTitle(), driver.getCurrentUrl());

		default:
			String DEFAULT_PAGE_URL = config.getString("HOME_PAGE_URL");
			driver.get(DEFAULT_PAGE_URL);
			return new HomePage(driver.getTitle(), driver.getCurrentUrl());
		}

	}

	public static void initPageElements(BaseTestPage page) {

		PageFactory.initElements(driver, page);

	}
	
	

	public static void scrollToView(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static BaseTestPage getNewWindow(int windowCount) {
		List<String> widget = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(widget.get(windowCount));		
		BaseTestPage newWindow = new BaseTestPage(driver.getTitle(), driver.getCurrentUrl());
		return newWindow;
	}

	public static BaseTestPage launchWindow(String product) {

		switch (product) {
		case "Televisions":
			return new TelevisionPage(driver.getTitle(), driver.getCurrentUrl());

		default:
			return new HomePage(driver.getTitle(), driver.getCurrentUrl());
		}
	}
	
	public static void closeAll()
	{
		driver.quit();
	}
}
