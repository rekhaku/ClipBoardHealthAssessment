package amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import amazon.helper.VerificationHelper;

public class HomePage extends BaseTestPage {

	@FindBy(xpath = "//a[contains(@id,'nav-hamburger-menu')]/span")
	public static WebElement linkHamburgerMenu;

	@FindBy(xpath = "//div[contains(text(),'shop by department')]")
	public static WebElement divShopByDept;

	@FindBy(xpath = "//div[contains(text(),'TV, Appliances, Electronics')]")
	public static WebElement divTVAppliances;

	@FindBy(xpath = "//a[contains(text(),'Televisions')]")
	public static WebElement linkTelevision;

	@FindBy(xpath = "//div[contains(text(),'tv, audio & cameras')]")
	public static WebElement divTVAudioCamera;

	@FindBy(xpath = "//a[contains(text(),'Televisions')]")
	public static WebElement divTelevision;

	@FindBy(xpath = "//span[contains(text(),'Featured')]")
	public static WebElement sortFeatured;

	@FindBy(xpath = "//a[contains(@id,'s-result-sort-select_2')]")
	public static WebElement selectPriceHighToLow;

	@FindBy(xpath = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']")
	public static WebElement divSecondHighestPrice;

	@FindBy(xpath = "//span[contains(text(),'Samsung')]/..//label/i")
	public static WebElement labelSamsung;

	public HomePage()
	{
		
	}
	public HomePage(String title, String currentUrl) {
		super(title, currentUrl);
	}

	public static WebElement getSection(String section) {

		switch (section) {
		case "shop by department":
			return divShopByDept;

		default:
			return null;
		}

	}

	public static WebElement getCategory(String category) {

		switch (category) {
		case "TV, Appliances, Electronics":
			return divTVAppliances;

		default:
			return null;
		}

	}

	public static WebElement getSubSection(String subSection) {

		switch (subSection) {
		case "tv, audio & cameras":
			return divTVAudioCamera;

		default:
			return null;
		}

	}

	public static WebElement getProduct(String product) {

		switch (product) {
		case "Televisions":
			return divTelevision;

		default:
			return null;
		}

	}

}
