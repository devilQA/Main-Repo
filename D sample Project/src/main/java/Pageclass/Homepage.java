package Pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.BaseTest;

public class Homepage extends BaseTest {
	@FindBy (xpath="//a[text()='Your Store']")
	private WebElement YourStoreTitle;

	@FindBy (xpath="//a[text()='Components']")
	private WebElement componentsMenu;

	@FindBy (xpath="//a[contains (text(),'Monitors')]")
	private WebElement monitorsSubMenu;

	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	public ProductPage validateComponents() {
		YourStoreTitle.isDisplayed();
		Actions act= new Actions(driver);
		act.moveToElement(componentsMenu).build().perform();
		act.moveToElement(monitorsSubMenu).click().build().perform();
		return new ProductPage();
	}
}
