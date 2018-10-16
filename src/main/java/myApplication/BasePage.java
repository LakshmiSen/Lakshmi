package myApplication;

	import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	
	public class BasePage {

		public static WebDriver driver;
		public String browser = "chrome";

		public BasePage() {
			if (driver == null) 
			
			{
				if (browser.equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver",
							"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
					driver = new ChromeDriver();
				} 
				
				//else if (browser.equals("firefox")) {
				//	System.setProperty("webdriver.gecko.driver", "Firefox Driver Server Path");
					//driver = new FirefoxDriver();
				//}
				
			
			    driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.get("http://automationpractice.com/index.php");
			}
		}

		public boolean display(WebElement element) {
			boolean res = false;
			try{
				res = element. isDisplayed();
			}
			catch(Exception e)
			{	
		
			e.printStackTrace();
			}
			return res;
		}
		
		public void toClick(WebElement e){
			e.click();
			
		}
		public void Navigateback(){
			driver.navigate().back();
		}
		
		public void mouseover (WebElement e)
		{
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0, 900)");
			
			Actions obj= new Actions (driver);
			obj.moveToElement(e).build().perform();
			
		}
		
		public void setText ( WebElement element, String name)
		{
			element.click();
			element.clear();
			element.sendKeys(name);
		}
		public void SelectSortByDropDown(WebElement e, String optionToBeSelected) {
			
			Select obj=new Select(e);
			obj.SelectByDropDown(optionToBeSelected);
		}
		
		public boolean isElementVisible(WebElement element)
			{
			try
				{
					WebDriverWait wait =new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.visibilityOf(element));
					return true;
					
				}
			catch (Exception e)
			{
				return false;				
			}
			}
			public boolean isElementInVisible(WebElement element)
			{
			try
				{
					WebDriverWait wait =new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.invisibilityOf(element));
					return true;
					
				}
			catch (Exception e)
			{
				return false;				
			}
			
			
		}
	}