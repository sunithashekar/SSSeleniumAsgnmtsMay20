package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCatagProductPage {
	
	WebDriver driver;
	Actions act;
	Select select;
	Alert alrt;
	
	public AddCatagProductPage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="i.fa.fa-tags.fa-fw")
	WebElement catalog;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	WebElement product;
	
	@FindBy(css="i.fa.fa-plus")
	WebElement addNewProd;
	
	@FindBy(xpath="//input[@id='input-name1']")
	WebElement productName;
	
	@FindBy(xpath="//input[@id='input-meta-title1']")
	WebElement metatagTitle;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	public WebElement dataTab;
	
	@FindBy(xpath="//input[@id='input-model']")
	WebElement model;
	
	@FindBy(xpath="//input[@id='input-price']")
	WebElement price;

	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement quantity;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	public WebElement links;
	
	@FindBy(xpath="//input[@id='input-category']")
	WebElement catagories;
	
	@FindBy(xpath="//a[contains(text(),'Discount')]")
	public WebElement discountTab;
	
	@FindBy(xpath="//button[@onclick='addDiscount();']")
	public WebElement addDiscountBtn;
	
	@FindBy(xpath="//table//tbody//tr//td/input[@placeholder='Quantity']")
	WebElement quantityAdd;
	
	@FindBy(xpath="//table//tbody//tr//td/input[@placeholder='Price']")
	WebElement priceAdd;
	
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Reward Points')]")
	public WebElement rewardTab;
	

	@FindBy(xpath="//input[@id='input-points']")
	WebElement rePoints;

	
	@FindBy(xpath="//button[@class='btn btn-primary' and @type='submit']")
	public WebElement saveProd;
	
	
	
	public void doClickCatagory()
	{
		act= new Actions(driver);
		act.moveToElement(catalog).build().perform();
		product.click();
		//addNewProd.click();
		
	}
	
	public void enterProdTab(String prodName,String metaTitl) {
		addNewProd.click();
		productName.sendKeys(prodName);
		metatagTitle.sendKeys(metaTitl);
		
	}
	
		
	public void enterDataTab(String modl,String prices,String quant) {
		model.sendKeys(modl);
		price.sendKeys(prices);
		quantity.clear();
		quantity.sendKeys(quant);
	}
	
	public void enteCataTab(String catgry) {
		catagories.sendKeys(catgry);
		
	}
	
	public void enteAddDiscntDetTab(String quantity,String pricea) {
		quantityAdd.sendKeys(quantity);
		priceAdd.sendKeys(pricea);
		
	}
	
	public void enteRewardTab(String rewardsPonts) {
		rePoints.sendKeys(rewardsPonts);
		
	}
	
	//act.keyDown(firstname, Keys.SHIFT). sendKeys("roshan").keyUp(Keys.SHIFT).perform();  for catogy selection try keyborad act or robo
 
	
}