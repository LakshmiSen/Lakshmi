package myApplication;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressPageObject extends BasePage {
	BasePage bp = new BasePage();

	@FindBy(xpath = "//*[@class = 'heading-counter']")
	private WebElement header;

	@FindBy(xpath = "//*[@class = 'cat-name']")
	private WebElement title;

	@FindBy(xpath = "//ul[@class = 'product_list grid row']/li")
	private List<WebElement> lstproduct;

	@FindBy(xpath = "//ul[@class = 'product_list grid row']/li[1]//span[text() = 'Add to cart']")
	private WebElement Addcart;

	@FindBy(xpath = "//ul//a[text() ='S']")
	private WebElement sizeS;

	@FindBy(xpath = "//ul//a[text() ='M']")
	private WebElement sizeM;

	@FindBy(xpath = "//ul//a[text() ='L']")
	private WebElement sizeL;

	@FindBy(xpath = "//div[contains(@class,'layer_cart')]/h2")
	private WebElement Addcartmsg;

	@FindBy(xpath = "//*[@class= 'product_img_link']")
	private List<WebElement> imgInDressesPage;

	@FindBy(xpath = "//*[@class='btn btn-default btn-twitter")
	private WebElement Tweet;

	@FindBy(xpath = "//*[@class='btn btn-default btn-facebook']")
	private WebElement share;

	@FindBy(xpath="//*[@id='short_description_content']")
	private WebElement Description;
	
	@FindBy(xpath="//*[@id='selectProductSort']")
	private WebElement selectSortBy;
	
	@FindBy(xpath="//*[@id='layered_ajax_loader']")
	private WebElement loadingIcon;
	
	@FindBy(xpath="//div[@class='right-block']//*[@class='price product-price']")
	private List<WebElement> lstproductPrices;
	
	@FindBy(xpath="//div[@class='right-block']/h5/a")
	private List<WebElement> sortbyname;
	
	
	public DressPageObject() {
		PageFactory.initElements(driver, this);
	}

	public int getheaderproductCount() {
		return Integer.parseInt(header.getText().split(" ")[2]);

	}

	public int getTotalProducts() {
		return lstproduct.size();
	}

	public boolean sizedisplay() {
		return (bp.display(sizeS) && bp.display(sizeM) && bp.display(sizeL));
	}

	public void AddtoCart() {
		mouseover(lstproduct.get(1));

		Addcart.click();

	}

	public boolean addcartdisplay() {
		return bp.display(Addcartmsg);
	}
		public String getTitle() {
		return title.getText();
	}
	public void ClickfirstProd() {
		lstproduct.get(0).click();
		
	}
			
	public List<WebElement> ListOfProductsinDressesPage(){
		return imgInDressesPage;
	}
	
	public WebElement TweetTab(){
		return Tweet;
	}
	public WebElement ShareTab(){
		return share;
	}
	public WebElement descriptionTab(){
		return Description;
	}

	

	public List<Double>getProductPrices() {
	
		ArrayList<Double>list=new ArrayList<Double>();
			
		for(WebElement element:lstproductPrices){
			
			String text=element.getText();
			text=text.replace("$", "");
			Double Prices=Double.parseDouble(text);
			System.out.println("ProductPrice"+ Prices);
			list.add(Prices);
				}
	return list;
	
	}
	public List<String>getProductNames() {
		
		ArrayList<String>list=new ArrayList<String>();
			
		for(WebElement element:sortbyname){
			
			{
			list.add(element.getText());
				}
			
	return list;
	
		}
		return list;
	}
	public boolean ProductNameCompare(String firstProductName, String secondProductName){
		{
			if(firstProductName.compareTo(secondProductName)<=0)
			{
				return true;
			}
				
			else{
				
				return false;
			}
	}
	
}

}