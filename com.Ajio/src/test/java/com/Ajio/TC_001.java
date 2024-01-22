package com.Ajio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.Ajio.generic.pageobjectmodel.HomePage;
import com.Ajio.generic.pageobjectmodel.JeansPage;
import com.Ajio.generic.util.BaseClass;

public class TC_001 extends BaseClass {


	@Test
	public void endtoend() throws FileNotFoundException, IOException
	{
		HomePage homepage=new HomePage(driver);
		homepage.clickonjeans();
		JeansPage jeanspage = new JeansPage(driver);
		jeanspage.FetchJeansData();
		
		
	}
}
