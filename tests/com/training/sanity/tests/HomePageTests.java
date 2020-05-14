package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePage;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class HomePageTests {
	
	
	static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	static LoginPOM loginpage;
	static HomePage homepage ;
	
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
		 loginpage = new LoginPOM(driver);
		 loginpage.clickLoginbtn("admin", "admin@123");
		homepage = new HomePage(driver);
		
	}


	// TC UNF_046 - verify that admin can edit the order placed and save
	
	@Test(priority =1, enabled = true)
	public void verifyCartEdit() {
		String s2 = homepage.doClickCart();
		 screenShot.captureScreenShot("EditAddItem");
		Assert.assertEquals(s2, "Warning: Products marked with *** are not available in the desired quantity or not in stock!" , "Edit order TC failed");
	}
	
	
	/* TC- UNF_048
	 * verify whether application allows admin to create category & add product on the created category
	*/
	
	
	@Test(priority = 2,enabled = true)
	public void verifyCatagoryAddProduct(){
		Assert.assertEquals(homepage.doClickCatalgcatgry(),"Success: You have modified categories!" );  // to verify catagories modified successfully.
		screenShot.captureScreenShot("ModifyCatagory");
		Assert.assertEquals(homepage.doClickProducticon(),"Success: You have modified products!"); // to verify products modified successfully.
		screenShot.captureScreenShot("ModifyProducts");
	}
	
	
	/*
	 *TC UNF_049- Verify that admin can return product of customer & delete from return list
	 */
	@Test(priority=3,enabled= true)
	public void verifyReturnProduct(){
		String msgCheck2 = homepage.doCheckReturnProduct();
		screenShot.captureScreenShot("returnProductSS");
		Assert.assertEquals(msgCheck2, " Success: You have modified returns!", "Save failed on Return product");
		Assert.assertEquals(homepage.doSelectCheckBReturnProduct(), " Success: You have modified returns!", "Delete  failed on Return product");
		screenShot.captureScreenShot("deleteProductSS");
		
	}
	
	
	/*
	 * TC UNF_050- Verify that admin can edit Customer details & add reward points
	 */
	@Test(priority=4)
	public void veridyEditCustDet() {
		Assert.assertEquals(homepage.doEditCustmDet(), "Success: You have modified customers!", "Modify Customer info failed" );
		screenShot.captureScreenShot("ModifyCustDet");
		
	}
	
	
	
	/* 
	 *  TC UNF_047 - verify that admin can filter details of order placed by the user based on Order ID,OrderStatus ,date Added,Customer name,
	 *  date Modified or total amount.
	 */
	 
	
	@Test(priority =5, enabled = false)
	public void verify() {
		Assert.assertTrue(homepage.doCheckFilterOrderId());   // To verify the filter based on OrderId is coming or not
		homepage.doCheckFilterOrderStatus();   // Check how to assert here based on order status ??
		
		// yet to write date added filter - check how to select from calender.
		
	}	
		
		
		
	
	@AfterMethod
		public void tearDown() throws InterruptedException  {
			Thread.sleep(1000);
			driver.quit();
	}
	
  
	 

}