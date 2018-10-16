package myApplication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailObjectPage extends BasePage {
BasePage bp=new BasePage();
	@FindBy(xpath="//*[@class='btn btn-default btn-twitter']")
	private WebElement Tweet;
	
	public void clicktabTweet() {
		Tweet.click();
		
	}

	public boolean Tweet() {
		
		return bp.display (Tweet);
	}








}
