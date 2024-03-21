package scenarios;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultOptions {

	@Test
	public void multipOpts() throws InterruptedException
	{
		ArrayList<String> exp_data=new ArrayList<String>();
		exp_data.add("Volvo");
		exp_data.add("Saab");
		exp_data.add("Opel");
		exp_data.add("Audi");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		WebElement ele=driver.findElement(By.id("cars"));
		Select opts=new Select(ele);
		opts.selectByIndex(0);
		opts.selectByValue("saab");
		opts.selectByVisibleText("Audi");
		List<WebElement> allItems=opts.getOptions();
		System.out.println("total items="+allItems.size());
		System.out.println("Items in a Listbox");
		for(int i=0;i<allItems.size();i++)
		{
			System.out.println(allItems.get(i).getText());
			if(exp_data.get(i).equals(allItems.get(i).getText()))
			{
				System.out.println("Passed");
			}
			else
			{
				System.out.println("Failed");
			}
		}
		
		driver.findElement(By.xpath("/html/body/form/input")).click();
		Thread.sleep(5000);
		String selCars=driver.findElement(By.xpath("/html/body/div[1]")).getText();
		System.out.println("Selected Cars="+selCars);
		driver.quit();
	}

}
