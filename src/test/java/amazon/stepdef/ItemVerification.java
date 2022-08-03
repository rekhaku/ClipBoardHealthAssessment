package amazon.stepdef;

import amazon.helper.PageHelper;
import amazon.helper.VerificationHelper;
import amazon.pages.BaseTestPage;
import amazon.pages.HomePage;
import amazon.pages.TelevisionPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Info;



public class ItemVerification {

	private static final org.slf4j.Logger log = 
		    org.slf4j.LoggerFactory.getLogger(ItemVerification.class);
	
	BaseTestPage page = null;
	
	@Before
	public void bf()
	{
		
	}
	@Given("User launches the {string}")
	public void user_launches_the_page(String string) {
		
		page = PageHelper.launchPage(string);
		PageHelper.initPageElements(page);
		assertEquals(VerificationHelper.properties.get("HOME_PAGE_TITLE"), page.getWebPageTitle(), "Page title ");

	}

	@And("User clicks on the hamburger menu in the top left corner")
	public void user_clicks_on_the_hamburger_menu_in_the_top_left_corner() {
		assertTrue("Hamburger Menu is displayed", HomePage.linkHamburgerMenu.isDisplayed());
		HomePage.linkHamburgerMenu.click();

	}

	@And("User scrolls down and clicks on the {string} link under the {string}")
	public void user_scrolls_down_and_clicks_on_the_link_under_the(String category, String section) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue("Section 'Shop by Department'  is displayed", HomePage.getSection(section).isDisplayed());
		PageHelper.scrollToView(HomePage.getSection(section));
		assertTrue("Link 'TV, Appliances, Electronics' is displayed", HomePage.getCategory(category).isDisplayed());
		HomePage.getCategory(category).click();

	}

	@And("User clicks on the {string} under {string}")
	public void user_clicks_on_the_under(String product, String subSection) {
		try {
			Thread.sleep(6000);
			assertTrue("Sub Section 'Tv, Audio & Cameras' is visible", HomePage.getSubSection(subSection).isDisplayed());
			assertTrue("Product 'Televisions' is visible", HomePage.getProduct(product).isDisplayed());
			HomePage.getProduct(product).click();			
			page = PageHelper.launchWindow(product);
			PageHelper.initPageElements(page);
			assertEquals(VerificationHelper.properties.get(product.toUpperCase()+"_PAGE_TITLE"), page.getWebPageTitle(), "Page title ");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@And("user scroll down and filter the results by {string}")
	public void user_scroll_down_and_filter_the_results_by(String brand) {
		try {
			
			
			Thread.sleep(3000);
			PageHelper.scrollToView(TelevisionPage.getBrand(brand));
			assertTrue("Product 'Televisions' is visible", TelevisionPage.getBrand(brand).isDisplayed());
			TelevisionPage.getBrand(brand).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@And("User sort the results with {string}")
	public void user_sort_the_results_with(String string) {
		try {
			Thread.sleep(6000);
			assertTrue("Sort features are visible",HomePage.sortFeatured.isDisplayed());
			HomePage.sortFeatured.click();
			HomePage.selectPriceHighToLow.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User clicks the second highest priced item")
	public void user_clicks_the_second_highest_priced_item() {
		try {
			Thread.sleep(6000);
			HomePage.divSecondHighestPrice.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Then("Application switches the window {string}")
	public void application_switches_the_window(String brand) {		
		PageHelper.getNewWindow(1);
		assertTrue("New window is open ",PageHelper.getNewWindow(1).getWebPageTitle().contains(brand));
		
	}

	@Then("Verify the {string} is present")
	public void verify_the_is_present(String string) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageHelper.scrollToView(TelevisionPage.textAboutThisItem);
		assertTrue("About this item are visible",TelevisionPage.textAboutThisItem.isDisplayed());
		System.out.println(TelevisionPage.spanDescriptionAboutThisItem.size());
		for(WebElement listItem : TelevisionPage.spanDescriptionAboutThisItem)
			log.info(listItem.getText());
		
		
	}
	
	
	@After
	public void af()
	{
		PageHelper.closeAll();
	}
	
	
}
