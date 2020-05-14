package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePage;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

//	@BeforeMethod
//	public void setUp() throws Exception {
//		driver = DriverFactory.getDriver(DriverNames.CHROME);
//		loginPOM = new LoginPOM(driver); 
//		baseUrl = properties.getProperty("baseURL");
//		screenShot = new ScreenShot(driver); 
//		// open the browser 
//		driver.get(baseUrl);
//	}
	
	
	// To verify TC UNF_010 - Login
	@Test(priority =1)
	public void verifyLoginbtn()  {
		boolean flag1 = loginPOM.clickLoginbtn("admin", "admin@123");
		screenShot.captureScreenShot("LoginPageSS");
		Assert.assertTrue(flag1);
		//loginPOM.doClickCatalog();
			
	}
	// To verify TC UNF_011 - click on catalog and then to categories
	
		@Test(priority =2)	
		 public void verifyCatalog() {
		 String catg = loginPOM .doClickCatalog();
			screenShot.captureScreenShot("CatalogSS");
			Assert.assertEquals(catg, "Categories","If any problem log it");
			
		}

// delete Uniforms item from the catagory list.
		
    @Test (priority =3)
   public void verifyClickingofCatagory() throws Exception {
    loginPOM.doClickCatagoryPage();
    loginPOM.doSelectCheckbox();
    loginPOM.doClickDelete();
    Assert.assertEquals(loginPOM.doAcceptAlert(),"Success: You have modified categories!","log message if fails..");
    screenShot.captureScreenShot("DeleteItem");
  
   }

       
    
	@AfterClass
	public void tearDown() throws Exception {
    Thread.sleep(1000);
    driver.quit();
    }
	
}	
