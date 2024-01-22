package com.Ajio.generic.pageobjectmodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ajio.generic.util.ExcelUtil;
import com.Ajio.generic.util.Ipath;
import com.Ajio.generic.util.WebDriverActions;

public class JeansPage {

	WebDriver driver;
	WebDriverActions webDriverActions=new WebDriverActions();

	ExcelUtil excelutil=new ExcelUtil();
	public JeansPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	//Means hyperlink in L1 section
	@FindBy(xpath="//a[text()='MEN']")
	private WebElement menlink;
	
	@FindBy(xpath ="//div[@class='nameCls']")
	private List<WebElement> jeansname;

	@FindBy(xpath ="//span[@class='price  ']")
	private List<WebElement> jeansprice;
	

public void FetchJeansData() throws FileNotFoundException, IOException
{
	List<String> headers = List.of("Name", "Price");
	//Ipath.excelfolderPath;
	excelutil.WriteDataFromExcel(headers, Ipath.excelfolderPath,jeansname ,jeansprice);
	
}

}