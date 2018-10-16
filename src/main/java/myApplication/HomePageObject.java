package myApplication;
	
	

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class HomePageObject extends BasePage 
	{

		public boolean printtest()
		{
			System.out.println();
			return true;
		
		}
		@FindBy(xpath = "//ul[contains(@class, 'menu-content')]/li[1]//a[text()='Women']")
		private WebElement Women;
		
		@FindBy(xpath = "//ul[contains(@class, 'menu-content')]/li[2]//a[text()='Dresses']")
		private WebElement Dresses;
		
		@FindBy(xpath = "//ul[contains(@class, 'menu-content')]/li[3]//a[@title='T-shirts']")
		private WebElement Tshirt;
		
		@FindBy(xpath = "//*[@id='newsletter-input']")
		private WebElement Newsletter;
		
		@FindBy(xpath =" //p[@class='alert alert-success']")
		private WebElement Subscription;

		@FindBy(xpath = "//button[@name='submitNewsletter']")
		private WebElement submitNewsletter;


		@FindBy(xpath =" //ul[@id = 'homefeatured']/li")
		private List<WebElement> products;
						
		{
		PageFactory.initElements( driver, this);
		}
		
		public void clicktabWomen(){
			Women.click();
		}
		
		public WebElement clicktabDresses(){
		  return Dresses;
		}
		public void clicktabTshirt(){
			Tshirt.click();
		}	
		
		public boolean MenuDisplay()
		{
			return (display(Dresses) &&  display(Women) && display(Tshirt));
		}
		
public void Newsletterset(String email)
{
	setText (Newsletter, email);
	
	submitNewsletter.click();
}


public boolean Subdisplay()
{
	return(display(Subscription));
		
}

	public boolean verifyAddtocart(WebElement parent)
	{
	return display(parent.findElement(By.xpath(".//*[text()='add to cart']")));
		
	}
	public List<WebElement> getProductList() {
		return products;
	}


		
	}