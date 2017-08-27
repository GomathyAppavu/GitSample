package snippet;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameterization {
	
	
	public void searchEbayinChrome() throws InterruptedException{
		//1)open browser
		ExcelRead oexread = new ExcelRead("C:\\Gomathy-camunda\\Selenium\\workouts\\ExcelData\\ebay.xls","Search");
		String sdata=oexread.getCellData("SearchFor",1);
		System.setProperty("webdriver.chrome.driver", "C:\\Gomathy-camunda\\Selenium\\Installation\\Drivers\\chromedriver30.exe");
		ChromeDriver oCD = new ChromeDriver();
		//launch browser ===>www.ebay.com
		oCD.get("http://www.ebay.com/");
		//Enter laptop in search box 
		/*a.Recognize the object
		 * b.Enter value to the text box
		 */
		oCD.findElement(By.id("gh-ac")).clear();
		oCD.findElement(By.id("gh-ac")).sendKeys(sdata);
		//Click on search button
		oCD.findElement(By.id("gh-btn")).click();
		//Click on Advance link
		oCD.findElement(By.id("gh-as-a")).click();
		Thread.sleep(5000);
		//select CHECKBOX title and discription

 }

	public void searchEbayinChromeDataDrivenScenario() throws InterruptedException{
		//1)open browser
		ExcelRead oexread = new ExcelRead("C:\\Gomathy-camunda\\Selenium\\workouts\\ExcelData\\ebay.xls","Search");
		for(int i=1;i<oexread.rowCount();i++){
		System.setProperty("webdriver.chrome.driver", "C:\\Gomathy-camunda\\Selenium\\Installation\\Drivers\\chromedriver30.exe");
		ChromeDriver oCD = new ChromeDriver();
		//launch browser ===>www.ebay.com
		oCD.get("http://www.ebay.com/");
		//Enter laptop in search box 
		/*a.Recognize the object
		 * b.Enter value to the text box
		 */
		oCD.findElement(By.id("gh-ac")).clear();
		oCD.findElement(By.id("gh-ac")).sendKeys(oexread.getCellData("SearchFor",i));
		//Click on search button
		oCD.findElement(By.id("gh-btn")).click();
		//Click on Advance link
		oCD.findElement(By.id("gh-as-a")).click();
		Thread.sleep(5000);
		//select CHECKBOX title and discription
		}
 }
	@Test
	public void searchEbayinChromeDataDrivenScenarioInSingleBrowser() throws InterruptedException{
		//1)open browser
		ExcelRead oexread = new ExcelRead("C:\\Gomathy-camunda\\Selenium\\workouts\\ExcelData\\ebay.xls","Search");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Gomathy-camunda\\Selenium\\Installation\\Drivers\\chromedriver30.exe");
		ChromeDriver oCD = new ChromeDriver();
		//launch browser ===>www.ebay.com
		for(int i=1;i<oexread.rowCount();i++){
		oCD.get("http://www.ebay.com/");
		//Enter laptop in search box 
		/*a.Recognize the object
		 * b.Enter value to the text box
		 */
		
		oCD.findElement(By.id("gh-ac")).clear();
		oCD.findElement(By.id("gh-ac")).sendKeys(oexread.getCellData("SearchFor",i));
		//Click on search button
		oCD.findElement(By.id("gh-btn")).click();
		//Click on Advance link
		oCD.findElement(By.id("gh-as-a")).click();
		Thread.sleep(4000);
		//select CHECKBOX title and discription
		}	}
}