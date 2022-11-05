package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.BaseTest;

public class FirstPage extends BaseTest {

	@FindBy(xpath = "//input[@name='search_query']")
	private WebElement searchtab;

	@FindBy(xpath = "//button[@name='submit_search']")
	private WebElement searchbtn;

	@FindBy(xpath = "//span[@class='heading-counter']")
	private WebElement availresults;

	@FindBy(xpath = "//div[@class='product-container']//a[@class='product-name']")
	private WebElement selcproduct;

	@FindBy(xpath = "//span[text()='More']")
	private WebElement morebtn;

	public FirstPage() {
		PageFactory.initElements(driver, this);
	}

	public ProductPage searchForProduct(String product) {
		searchtab.sendKeys(product);
		searchbtn.click();
		availresults.isDisplayed();
		Actions act = new Actions(driver);
		act.moveToElement(selcproduct).build().perform();
		act.moveToElement(morebtn).click().build().perform();
		return new ProductPage();
	}
}
