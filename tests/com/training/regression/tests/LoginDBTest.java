package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AddCatagProductPage;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginDBTest {
	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static GenericMethods genericMethods; 
	static LoginPOM loginpage;
	static AddCatagProductPage productPage ;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		 driver = DriverFactory.getDriver(DriverNames.CHROME);
		 loginPOM = new LoginPOM(driver);
		 baseUrl = properties.getProperty("baseURL");
		 screenShot = new ScreenShot(driver);
	     genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
		loginpage = new LoginPOM(driver);
		 loginpage.clickLoginbtn("admin", "admin@123");
		  productPage = new AddCatagProductPage(driver);
		  productPage.doClickCatagory();
		
	}


	// TC-UNF_073 - To Verify whether added product details get stored in database
	
	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String productName, String model, String price, String quantity, String metatag) {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
				
		productPage.enterProdTab(productName,metatag);
		productPage.dataTab.click();
		productPage.enterDataTab(model, price, quantity);
		productPage.saveProd.click();
		screenShot.captureScreenShot("AddMultiProductDBreadTCM");
		
	
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	

}