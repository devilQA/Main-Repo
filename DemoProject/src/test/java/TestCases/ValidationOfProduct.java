package TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Baseclass.BaseTest;
import Pages.FirstPage;
import Pages.ProductPage;
import Pages.ShoppingSummaryPage;

public class ValidationOfProduct extends BaseTest {
	FirstPage first = null;
	ProductPage product = null;
	ShoppingSummaryPage summary = null;

	@BeforeMethod
	void setup() {
		initializ();
		first = new FirstPage();
	}

	@Test
	void validateProductInfo() {
		product = first.searchForProduct("dress");
		product.dollarsignispresent();
		summary = product.addTocartFun();
		summary.verifysummarypage();
		summary.ProductInfo();
		String warningtxt = summary.validateEmptycart();
		Assert.assertEquals(warningtxt, "Your shopping cart is empty.");
	}

	@AfterMethod
	void closeall() {
		TearDown();
	}
}
