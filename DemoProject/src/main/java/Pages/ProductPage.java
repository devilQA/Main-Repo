package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.BaseTest;

public class ProductPage  extends BaseTest{
	
	@FindBy (xpath="//a[@id='send_friend_button']")
	private WebElement sendToFrend;
	
	@FindBy (xpath="//input[@id='friend_name']")
	private WebElement frendName;

	@FindBy (xpath="//input[@id='friend_email']")
	private WebElement frendMail;

	@FindBy (xpath="//span[text()='Send']")
	private WebElement sendBtn;

	@FindBy (xpath="//input[@value='OK']")
	private WebElement okbtn;

	@FindBy (xpath="//span[contains(text(),'$0.00')]")
	private WebElement dollarsign;

	@FindBy (xpath="//span[text()='Add to cart']")
	private WebElement addtocartbtn;
	
	@FindBy (xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedTocheckbtn;

public ProductPage() {
	PageFactory.initElements(driver, this);
}
public boolean dollarsignispresent() {
	return dollarsign.isDisplayed();

}


public void sendToFrend() {
	sendToFrend.click();
	frendName.sendKeys("Demofrend");
	frendMail.sendKeys("demofrend@gmail.com");
	sendBtn.click();
	okbtn.click();
}


public ShoppingSummaryPage addTocartFun() {
	addtocartbtn.click();
	proceedTocheckbtn.click();
	return new ShoppingSummaryPage();
	
}

}
