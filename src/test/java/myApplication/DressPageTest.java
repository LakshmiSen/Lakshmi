package myApplication;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DressPageTest {

	HomePageObject homePage;
	DressPageObject dressPage;

	public DressPageTest() {
		homePage = new HomePageObject();
		dressPage = new DressPageObject();
	}

	@BeforeMethod
	public void Beforemethod() {
		System.out.println("Beforemethod from Testmethod");
	}
	

	@Test
	public void verifyproductcount() {
		homePage.clicktabDresses();
		Assert.assertEquals(dressPage.getheaderproductCount(),
				dressPage.getTotalProducts(), "Failed: count mismatch");
	}

	@Test
	public void verifysizeSMLdispaly() {
		Assert.assertTrue(dressPage.sizedisplay(),
				"Failed:Size SML not displayed");
	}

	@Test
	public void verifyaddtocart() {
		dressPage.AddtoCart();
		Assert.assertTrue(dressPage.addcartdisplay(), "Failed: cart not added");
	}

	@Test
	public void VerifyProductPrices() {
		homePage.clicktabDresses();
		dressPage.lstproductPrices("Price.asc");
		List<Double> ProductPrices = dressPage.getProductPrices();
		for (int i = 0; i < ProductPrices.size() - 1; i++)
			Assert.assertTrue(ProductPrices.get(i) < ProductPrices.get(i + 1),
					"failed:its not in asc order");

	}


	@Test
	public void VerifyProductNames() {
		homePage.clicktabDresses();
		dressPage.SelectSortByDropDown("Name.asc");
		List<String> ProductNames = dressPage.getProductNames();
		for (int i = 0; i < ProductNames.size() - 1; i++)
			Assert.assertTrue(dressPage.ProductNameCompare(ProductNames.get(i),
					ProductNames.get(i + 1)), "failed:its not in asc order");

	}

}
