package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	Actions act;
	Robot robo ;
	Alert alert;
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(id="login")
//	private WebElement userName; 
//	
//	@FindBy(id="password")
//	private WebElement password;
//	
//	@FindBy(id="formLogin_submitAuth")
//	private WebElement loginBtn; 
//	
//	public void sendUserName(String userName) {
//		this.userName.clear();
//		this.userName.sendKeys(userName);
//	}
//	
//	public void sendPassword(String password) {
//		this.password.clear(); 
//		this.password.sendKeys(password); 
//	}
//	
//	public void clickLoginBtn() {
//		this.loginBtn.click(); 
//	}
	
	@FindBy(name="username")
     private WebElement userName; 
	
	@FindBy(name = "password")
	WebElement pwd;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement logbutton;
	
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	 WebElement catalog;
	
	@FindBy(linkText= "Categories")
	 WebElement clickcatlink;
	    
	@FindBy(xpath= "//ul[@class = 'pagination']//following::li[5]") 
	WebElement clickpage;
	
	@FindBy(xpath="//td[text() ='uniforms']//preceding-sibling::td[@class='text-center']")
	WebElement uniform;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement deletebtn;
	
	//new TC
	@FindBy(xpath = "//i[@class ='fa fa-shopping-cart fa-fw']")   
	WebElement cart;
	
	@FindBy(xpath="//a[contains(text(),'Orders')]")
	WebElement doClickOrder;
	

	@FindBy(xpath="//td[contains(text(),'Sujatha Siva')]")
	WebElement doSelectCust;
	
	@FindBy(xpath="//td[contains(text(),'Sujatha Siva')]//preceding-sibling::td[@class='text-center']")
	WebElement doSelectCheckbox;
	
	@FindBy(xpath="//i[@class ='fa fa-pencil']")
	WebElement doSelectEdit;
	
	@FindBy(id = "button-customer")
	WebElement doClickCont;
	
	@FindBy(id = "input-product")
	WebElement chooseProduct;
	
	@FindBy(name = "quantity")
	WebElement enterQuant;
	
	@FindBy(id = "button-cart")
	WebElement clickbtnCart;
	
	@FindBy(id = "button-payment-address")
	WebElement clickbtnCartCont2;
	
	@FindBy(id = "button-save")
	WebElement clicksave;
	
	@FindBy(css = "div.alert.alert-danger")  
	WebElement displayMesg;
	
	
	

	
	public boolean clickLoginbtn(String un,String pd) {
	this.userName.clear();
	this.userName.sendKeys(un);
	this.pwd.clear(); 
	this.pwd.sendKeys(pd); 
	this.logbutton.click(); 
	boolean flag = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).isDisplayed();
	return flag ;	
	
	
	}
	
    public String doClickCatalog() {
     act = new Actions(driver);
	 act.moveToElement(catalog).build().perform();
	 clickcatlink.click();
   	 String catagry = driver.findElement(By.xpath("//h1[contains(text(),'Categories')]")).getText();
   	  
   	  return catagry;
    }
	 
	public void doClickCatagoryPage() throws Exception  {
		
		 robo = new Robot();
		//robo.mouseMove(0, +1000);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyRelease(KeyEvent.VK_DOWN);
		clickpage.click();
	}
	
	public void doSelectCheckbox() {
		uniform.click();
	}
	
	public void doClickDelete() {
		deletebtn.click();
	}
	
	
	public String doAcceptAlert() {
	alert	= driver.switchTo().alert();
	alert.accept();
	String msg= driver.findElement(By.xpath("//div[@class = 'alert alert-success']")).getText();
		return msg;
	}
	
	
	public String doClickCart() {
		act = new Actions(driver);
		act.moveToElement(cart).build().perform();
		doClickOrder.click();
		doSelectCheckbox.click();
		doSelectEdit.click();
		doClickCont.click();
		chooseProduct.sendKeys("Blazer Girls(7-8)");
		enterQuant.sendKeys("2");
		clickbtnCart.click();
		clickbtnCartCont2.click();
		clicksave.click();
	//	robo.keyPress(KeyEvent.VK_UP);
//		robo.keyRelease(KeyEvent.VK_UP);
		String s1 = displayMesg.getText();
		return s1;
		
		
		
		
	}
	
	
	
}
