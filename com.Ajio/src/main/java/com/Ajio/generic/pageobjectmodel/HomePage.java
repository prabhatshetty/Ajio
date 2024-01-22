package com.Ajio.generic.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ajio.generic.util.WebDriverActions;

public class HomePage {

	WebDriver driver;
	WebDriverActions webDriverActions=new WebDriverActions();

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
  
	//Means hyperlink in L1 section
	@FindBy(xpath="//a[text()='MEN']")
	private WebElement menlink;
	
	@FindBy(xpath="//a[text()='Jeans']")
	private WebElement jeans;
	
	
	 public WebElement getMenlink() {
			return menlink;
		}

		public WebElement getJeans() {
			return jeans;
		}
	
		public void clickonjeans()
		{
			webDriverActions.MoveToElement(driver, menlink);
			webDriverActions.waitForElementToAppear(jeans);
			webDriverActions.clickOnElement(jeans);
		}
}
