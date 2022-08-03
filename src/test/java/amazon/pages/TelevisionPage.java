package amazon.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import amazon.helper.VerificationHelper;

public class TelevisionPage extends BaseTestPage {
	
	@FindBy(xpath = "//span[contains(text(),'Samsung')]/..//label/i")
	public static WebElement labelSamsung;
	
	@FindBy(xpath = "//h1[contains(text(),'About this item')]")
	public static WebElement textAboutThisItem;
	
	@FindBy(xpath="//h1[contains(text(),'About this item')]/following::ul[contains(@class,'a-unordered-list a-vertical')]/li/span")
	public static List <WebElement> spanDescriptionAboutThisItem;
	
	public TelevisionPage()
	{
		
	}
	
	public TelevisionPage(String title, String currentUrl) {
		super(title,currentUrl);
	}


	public static WebElement getBrand(String brand) {
		
		switch (brand) {
		case "Samsung":
			return labelSamsung;
				
		default:
			return null;
		}	

	}
	
	
	

}
