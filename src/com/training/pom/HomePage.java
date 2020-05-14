package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
	Actions act;
	Select select;
	Alert alrt;
	
	public HomePage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

		
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
	
	@FindBy(name = "filter_order_id")  
	WebElement orderId;
	
	@FindBy(id = "button-filter")  
	WebElement clickFilter;
	
	@FindBy(xpath = "//td[contains(text(),'350'])")  
	WebElement doCheckFilterbasedonOrderid;
	
	@FindBy(id = "input-order-status")  
	WebElement doCheckFilterbasedonOrderStatus;
	
	@FindBy(css = "button.btn.btn-default")  
	WebElement doCheckFilterbasedondateAdded;
	
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	 WebElement cataloglnk;
	
	@FindBy(linkText= "Categories")
	 WebElement clickcatgrylink;
	
	@FindBy(css= "i.fa.fa-plus")
	 WebElement clickAdd;
	
	@FindBy(id = "input-name1")
	 WebElement catgName;
	
	@FindBy(css = "div.note-editable.panel-body")
	 WebElement catgDesc;
	
	@FindBy(id = "input-meta-title1")
	 WebElement metaTag;
	

	@FindBy(id = "input-meta-description1")
	 WebElement metaTagDesc;
	
	@FindBy(css = "i.fa.fa-save")
	 WebElement savecatg;
	
	@FindBy(css = "div.alert.alert-success")
	 WebElement alertMes;
	
	@FindBy(xpath = "//a[contains(text(),'Products')]")
	 WebElement clickProducts;
	
	@FindBy(css = "i.fa.fa-plus")
	 WebElement clickAddProd;
	
	@FindBy(xpath = "//input[@id= 'input-name1']")
	 WebElement prodName;
	
	@FindBy(xpath = "//input[@id= 'input-meta-title1']")
	 WebElement megaTitProd;
	
	@FindBy(xpath = "//a[contains(text(),'Data')]")
	 WebElement dataTab;
	
	@FindBy(xpath = "//input[@name= 'model']")
	 WebElement modeltxt;
	
	@FindBy(xpath = "//a[contains(text(),'Links')]")
	 WebElement linkTab;
	
	@FindBy(xpath = "//input[@name ='category']")
	 WebElement linkCatname;
	
	@FindBy(xpath = "//button/i[@class ='fa fa-save']")
	 WebElement clickSavePord;
	
	@FindBy(css = "div.alert.alert-success")
	 WebElement addSuccess;
	
	@FindBy(xpath = "//li[3]/a[contains(text(),'Returns')]")
	 WebElement clickreturns;
		
	@FindBy(xpath = "//i[@class='fa fa-plus']")
	 WebElement clickAddPrdReturn;
	
	@FindBy(name = "order_id")
	 WebElement retorderId;
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	 WebElement retFirstN;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	 WebElement retLastN;
	
	@FindBy(xpath = "//input[@id='input-email']")
	 WebElement retemail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	 WebElement retephone;
	
	@FindBy(xpath = "//input[@name='product']")
	 WebElement reteProd;
	
	@FindBy(xpath = "//input[@name='model']")
	 WebElement reteModl;
	
	@FindBy(xpath = "//button[@type='submit']")
	 WebElement clickSaveAddProdRet;

	@FindBy(xpath = "//div/i[@class='fa fa-check-circle']")
	 WebElement msgProdRet;
	
	@FindBy(xpath = "//td[contains(text(),'ssad fgg')]/preceding-sibling::td/input[@type='checkbox']")
	 WebElement selectChkRetn;
	
	@FindBy(css = "button.btn.btn-danger")
	 WebElement selectDel;
	
	@FindBy(css = "i.fa.fa-user.fa-fw")
	 WebElement custSection;
	
	@FindBy(xpath = "//li//a[text() ='Customers']")
	 WebElement clickCustomer;
	
	
	@FindBy(xpath = "//td[contains(text(),'Abhi N')]//preceding-sibling::td/input[@type='checkbox']")
	 WebElement clickCustomerName;
	
	@FindBy(css = "i.fa.fa-pencil")
	 WebElement clickCustomerNameEdit;
		
	@FindBy(xpath = "//input[@id='input-firstname']")
	 WebElement custFName;
	
	@FindBy(xpath = "//a[contains(text(),  'Address 1')]")
	 WebElement clickAdd1;
	
	@FindBy(xpath = "//input[@id='input-address-11']")
	 WebElement Addre1;
	 
	@FindBy(xpath = "//input[@id='input-postcode1']")
	 WebElement postCode;
	
	@FindBy(xpath = "//a[contains(text(),'Reward Points') and @href='#tab-reward']")
	 WebElement rewardPointclick;
	
	
	@FindBy(xpath = "//input[@id='input-reward-description']")
	 WebElement rewardDesc;
	
	@FindBy(xpath = "//input[@id='input-points']")
	 WebElement rewardPoints;
	
	@FindBy(xpath = "//button[@id='button-reward']")
	 WebElement rewardButton;
	
	@FindBy(css = "div.alert.alert-success")
	 WebElement succsMesg;
	
	
	
	
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
		String s1 = displayMesg.getText();
		return s1;
		
	}
	
	public boolean doCheckFilterOrderId() {
		act = new Actions(driver);
		act.moveToElement(cart).build().perform();
        orderId.sendKeys("350");
		clickFilter.click();
		boolean b1 = doCheckFilterbasedonOrderid.isDisplayed();
		return b1;
	}
	
	public void doCheckFilterOrderStatus() {
		orderId.clear();
		select = new Select(doCheckFilterbasedonOrderStatus);
		select.selectByVisibleText("Pending");
		clickFilter.click();
		
	}
	
	public String doClickCatalgcatgry() {
		act = new Actions(driver);
		act.moveToElement(cataloglnk).build().perform();
		clickcatgrylink.click();
		clickAdd.click();
		catgName.sendKeys("Sports Uniform");
		catgDesc.sendKeys("This is to place new cataogry");
		metaTag.sendKeys("Sports Uniform");
		metaTagDesc.sendKeys("Uniform for Sports");
		savecatg.click();
		String msg = alertMes.getText();
		return msg;
		
	}
	
	public String doClickProducticon() {
		act = new Actions(driver);
		act.moveToElement(cataloglnk).build().perform();
		clickProducts.click();
		clickAddProd.click();
		prodName.sendKeys("Sports Wear");
		megaTitProd.sendKeys("Sports Wear (8-10)");
		dataTab.click();
		modeltxt.sendKeys("SPU-03");
		linkTab.click();
		linkCatname.sendKeys("Sports Uniform");
		clickSavePord.click();
		String msg2= addSuccess.getText();
		return msg2;
		
	}
	
	public String doCheckReturnProduct() {
		act = new Actions(driver);
		act.moveToElement(cart).build().perform();
		clickreturns.click();
		clickAddPrdReturn.click();
		retorderId.sendKeys("25");
		retFirstN.sendKeys("Renu");
		retLastN.sendKeys("mathur");
		retemail.sendKeys("renu.mathur@gmail.com");
		retephone.sendKeys("9453234554");
		reteProd.sendKeys("Blazer Girls(7-8)");
		reteModl.sendKeys("BLG-112");
		clickSaveAddProdRet.click();
		String msgCheck= msgProdRet.getText();
		System.out.println(msgCheck);
		return msgCheck;
	}
	
	public String doSelectCheckBReturnProduct() {
		selectChkRetn.click();
		selectDel.click();
	    alrt = driver.switchTo().alert();
	    alrt.accept();
        String s5 = msgProdRet.getText();
        return s5;
		
	}
	
	public String doEditCustmDet() {
		act = new Actions(driver);
		act.moveToElement(custSection).build().perform();
		clickCustomer.click();
		clickCustomerName.click();
		clickCustomerNameEdit.click();
		custFName.clear();
		custFName.sendKeys("Chitra");	
		clickAdd1.click();
		Addre1.click();
		postCode.sendKeys("560097");
		rewardPointclick.click();
		rewardDesc.sendKeys("bonus");
		rewardPoints.sendKeys("20");
		rewardButton.click();
		String s7= succsMesg.getText();
		return s7;
		
	}
	
}
