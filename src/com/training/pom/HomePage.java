package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	Actions act;
	
	public HomePage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

		
	@FindBy(xpath = "//li[@id='catalog']")   
	WebElement catalog;
	
	

	public void doClickCatalog() {
		
		act = new Actions(driver);
		act.moveToElement(catalog);
	}
	
	
	
}
