package Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Baseclass.BaseTest;
import Pageclass.Homepage;
import Pageclass.ProductPage;

public class TestCase extends BaseTest {
	Homepage home=null;
	ProductPage product=null;
	@BeforeMethod
	void setup() {
		initialize();
		home= new Homepage();
	}
	
	@Test
	void validateYourStorePage() {
		product=home.validateComponents();
		product.verifyProduct();
		product.verifyIcons();
		String error = product.infoPage("atomsol interview");
		Assert.assertEquals(error, "File required!");
	}
	
	
	@AfterMethod
	void closeall() {
		TearDown();
	}
}
