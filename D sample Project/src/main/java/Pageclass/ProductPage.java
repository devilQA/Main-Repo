package Pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Baseclass.BaseTest;

public class ProductPage extends BaseTest {
	
	@FindBy (xpath="//span[@class='price-new']")
	private WebElement productPrice;

	@FindBy (xpath="//a[contains(text(),'Apple Cinema')]")
	private WebElement productName;

	@FindBy (xpath="//h2[contains(text(),'$110.00')]")
	private WebElement sameprice;

	@FindBy (xpath="//label[contains(text(),'Radio')]")
	private WebElement radiobtn;

	@FindBy (xpath="//div[@class='radio']")
	private WebElement largebtn;

	@FindBy (xpath="//div[@class='checkbox']//input[@value='10']")
	private WebElement checkboxbtn3;
	
	@FindBy (xpath="//div/textarea[@placeholder='Textarea']")
	private WebElement textarea;

	@FindBy (xpath="//select[@class='form-control']")
	private WebElement selctbox;

	@FindBy (xpath="//input[@name='quantity']")
	private WebElement Qtyvalue;

	@FindBy (xpath="//button[@id='button-cart']")
	private WebElement addtocartbtn;
	
	@FindBy (xpath="//div[text()='File required!']")
	private WebElement errormsg;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	public void verifyProduct() {
		System.out.println(productPrice.getText());
		productName.click();
		sameprice.isDisplayed();
	}
	public boolean verifyIcons() {
		radiobtn.isDisplayed();
		largebtn.isSelected();
		checkboxbtn3.click();
		return checkboxbtn3.isEnabled();
	}
	public String infoPage(String value) {
		textarea.sendKeys(value);
		
		Select sel= new Select(selctbox);
		sel.selectByValue("3");
		Qtyvalue.clear();
		Qtyvalue.sendKeys("1");
		addtocartbtn.click();
		errormsg.isDisplayed();
		return errormsg.getText();
	}
	
	
	
	
	
	
	
	
	
}
