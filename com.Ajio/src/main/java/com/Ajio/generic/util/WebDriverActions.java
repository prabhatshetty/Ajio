package com.Ajio.generic.util;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverActions extends BaseClass {

	/**
	 * Wait untill visibility of element
	 * @param ele
	 */
	public void waitForElementToAppear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}
	/**
	 * This method is used to wait For Element Clickable.
	 * @param ele
	 */
	public void waitForElementClickable(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));   
	}

	/**
	 * method is used to move to the element and click
	 * @param driver
	 * @param ele
	 */
	public void MoveToElementclick(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}
	/**
	 * This method is used to move to the element
	 * @param driver
	 * @param ele
	 */
	public void MoveToElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();

	}
	
	
	/**
	 * this method is used to click by using javascript executer
	 * @param ele
	 */
	public void javascriptClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}

	/**
	 * this method is used to scrollBy the page to given height
	 * @param ele
	 */
	public void javascriptScrollBy(int height)
	{	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,"+height+")", "");
	}

	/**
	 * This method is used to scroll into view
	 * @param ele
	 */
	public void javascriptScrollIntoView(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	/**
	 * This method is used to send the values to textbox by using java script executer
	 * @param ele
	 * @param value
	 */
	public void javascriptSendValue(WebElement ele, String value) {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value="+"'"+value+"'"+";", ele);
	}
	/**
	 * this method is used to click on web Element
	 * @param ele
	 */
	public void clickOnElement(WebElement ele) {
		ele.click();
	}

	/**
	 * this method is used to send the values to textbox
	 * @param ele
	 * @param value
	 */
	public void sendKeysOnElement(WebElement ele,String value)
	{
		ele.clear();
		ele.sendKeys(value);
	}

	/**
	 * This method is used to fetch current date in dd format
	 * @return
	 */
	public static String getCurrentDate()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		String currentdate = sdf.format(date);
		return currentdate;
	}

	/**
	 * This method is used to fetch current year in yyyy format
	 * @return
	 */
	public static String getCurrentYear()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String currentyear = sdf.format(date);
		return currentyear;
	}
	/**
	 * This method is used to refresh the Webpage
	 */
	public void refreshPage()
	{	
		driver.navigate().refresh();

	}
	/**
	 * This method is used to select the dropdown by visual text 
	 * @param element
	 * @param optiontext
	 */

	public void selectByVisibleText(WebElement element,String optiontext) {
		Select select = new Select(element);
		select.selectByVisibleText(optiontext);
	}
	/**
	 * This method is used to switch to the frame by passing webelement. 
	 * @param element
	 */
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch the frame to default content.
	 */
	public void switchTodefaultContent()
	{
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to accept the alert
	 */

	public void acceptAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * This method is used to dismiss the alert
	 */
	public void dismissAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	/**
	 * This method is used to fetch the text of the webelement.
	 * @param ele
	 * @return
	 */
	public String getText(WebElement ele)
	{
		return ele.getText();
	}
	/**
	 * This method is used to fetch the title of the web page. 
	 * @param ele
	 * @return
	 */
	public String getTitle(WebElement ele)
	{
		return driver.getTitle();
	}

	/**
	 * This method is used to fetch the url of the web page.
	 * @param ele
	 * @return
	 */
	public String getcurrentPageUrl(WebElement ele)
	{
		return driver.getCurrentUrl();
	}
	/**
	 *  This method is used to switch the driver control to new tab.
	 */
	public void switchToWindow()
	{
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentWindowId);
		for(String windowId:allWindowIds) {
			driver.switchTo().window(windowId);
		}
	}

	/**
	 * This method is used to switch the driver control to new Tab by using title as refrence.
	 * @param windowTitle
	 */

	public void switchToWindowByTitle(String windowTitle) {
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				if (driver.getTitle().equals(windowTitle)) {
					break;
				}
			}
		}
	}
	
	/**
	 * This method is used to select the dropdown by index.
	 * @param ele
	 * @param indexToSelect
	 */
	public void selectByIndex(WebElement ele ,int indexToSelect )
	{
		Select dropdown = new Select(ele);
		dropdown.selectByIndex(indexToSelect);
	}
	
	
	

	
	
}
