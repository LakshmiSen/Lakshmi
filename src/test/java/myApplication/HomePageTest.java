package myApplication;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest {

	HomePageObject homePage;
	DressPageObject dressPage;
	
	BasePage bp;

	public HomePageTest() {
		
		homePage = new HomePageObject();
		dressPage = new DressPageObject();
	}

	@Test
	public void verifyMenudisplay()
	{
		homePage.MenuDisplay();
		Assert.assertTrue(homePage. MenuDisplay(),"failed: Menu not Dispayed");
			}
		
	@Test
	public void verifypagenavigation()
	{
		homePage.clicktabWomen();
		Assert.assertEquals(dressPage.getTitle(),"WOMEN ");
		
		homePage.clicktabDresses();
		Assert.assertEquals(dressPage.getTitle(),"DRESSES ");
		
		homePage.clicktabTshirt();
		Assert.assertEquals(dressPage.getTitle(),"T-SHIRTS ");
		}
	
	@Test
	public void verifySubcreiption() {
		int value= new Random().nextInt(50000);
		String email="Lakshmi"+ value+"@gmail.com";
				
		homePage.Newsletterset(email);
		Assert.assertTrue(homePage.Subdisplay());
			}
	
	@Test
	public void VerifyAddtocartBtn()
	{
		List<WebElement>products = homePage.getProductList();
		for(WebElement prod : products)
		{   
		Assert.assertTrue(homePage.verifyAddtocart(prod),"Add to cart Button is not present");	
		}
		
	}
	}