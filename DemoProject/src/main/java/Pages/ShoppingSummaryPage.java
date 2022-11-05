package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.BaseTest;

public class ShoppingSummaryPage extends BaseTest {
	
	@FindBy (xpath="//h1[@id='cart_title']")
	private WebElement  shoppingcartsummarytxt;
	
	@FindBy (xpath="//span[@class='heading-counter']")
	private WebElement itomaddedtocart;

	@FindBy (xpath="//p[@class='product-name']")
	private WebElement productname;

	@FindBy (xpath="//span[@id='total_price']")
	private WebElement productprice;

	@FindBy (xpath="//a[@title='View my shopping cart']")
	private WebElement shoppingcart;

	@FindBy (xpath="//a[@title='remove this product from my cart']")
	private WebElement removeproduct;

	@FindBy (xpath="//p[@class='alert alert-warning']")
	private WebElement emptycartTxt;
	
	public ShoppingSummaryPage() {
		PageFactory.initElements(driver, this);
	}
public boolean verifysummarypage() {

	return 	shoppingcartsummarytxt.isDisplayed();

}

public String ProductInfo() {
	System.out.println("+++++++Product Details+++++++++");
	itomaddedtocart.isDisplayed();
	System.out.println(productname.getText());
	System.out.println(productprice.getText());
	return productprice.getText();
}
public String validateEmptycart() {
	Actions act= new Actions(driver);
	act.moveToElement(shoppingcart).build().perform();
	removeproduct.click();
	shoppingcart.click();
	System.out.println(emptycartTxt.getText());
	return emptycartTxt.getText();
}

}
