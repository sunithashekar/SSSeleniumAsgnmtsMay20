package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddCatagProductPage;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCatagProductXLtest {
	
	
	static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	static LoginPOM loginpage;
	static AddCatagProductPage productPage ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		 loginpage = new LoginPOM(driver);
		 loginpage.clickLoginbtn("admin", "admin@123");
		  productPage = new AddCatagProductPage(driver);
		  productPage.doClickCatagory();
		
	}

	// TC UNF_71 - To verify whether application allows Admin to add multiple products-Read test data from XLS sheet.
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class,enabled=false)
    public void verifyAddMultipleProd(String prodName, String metaTitl,String modl,String prices,String quant,String catgry,
    		String quantity,String pricea,String rewardsPonts ) {
		
		productPage.enterProdTab(prodName,metaTitl);
		productPage.dataTab.click();
		productPage.enterDataTab(modl, prices, quant);
		productPage.links.click();
		productPage.enteCataTab(catgry);
		productPage.discountTab.click();
		productPage.addDiscountBtn.click();
		productPage.enteAddDiscntDetTab(quantity, pricea);
		productPage.rewardTab.click();
		productPage.enteRewardTab(rewardsPonts);
		productPage.saveProd.click();
		screenShot.captureScreenShot("AddMultiProduct");
	}
	
	// TC UNF_72 - To verify whether application displays error message upon entering invalid details -Read test data from XLS sheet.
	@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class,enabled=true)
    public void verifyAddMultipleProdNegative(String prodName, String metaTitl,String modl,String prices,String quant,String catgry,
    		String quantity,String pricea,String rewardsPonts ) {
		
		productPage.enterProdTab(prodName,metaTitl);
		productPage.dataTab.click();
		productPage.enterDataTab(modl, prices, quant);
		productPage.links.click();
		productPage.enteCataTab(catgry);
		productPage.discountTab.click();
		productPage.addDiscountBtn.click();
		productPage.enteAddDiscntDetTab(quantity, pricea);
		productPage.rewardTab.click();
		productPage.enteRewardTab(rewardsPonts);
		productPage.saveProd.click();
		screenShot.captureScreenShot("AddMultiProductError");
	}
	
	
	
	//TC- UNF_073 To Verify whether added product details get stored in database,its in LoginDBTest class.Refer it.
	
	
	
	@AfterClass
	public void tearDown() throws InterruptedException  {
		Thread.sleep(1000);
		driver.quit();
	}
	
  
	 

}