package Proj002.Mavenlabs;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchingWindows {

	// public static void main(String[] args) {
	@Test
		public void switchwin()
		{
		// TODO Auto-generated method stub
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("/html/body/button")).click();
        driver.getWindowHandles();
        Set<String> allWinIds=driver.getWindowHandles();
        System.out.println("Total windows="+allWinIds.size());
        String win1=null;
        String win2=null;
        Iterator<String> itr=allWinIds.iterator();
        if(itr.hasNext())
        {
        	win1=itr.next();
        	win2=itr.next();
         }
        System.out.println(win1);
        System.out.println("Window1title="+driver.getTitle());
        System.out.println(win2);
        driver.switchTo().window(win2);
        System.out.println("Window2 title="+driver.getTitle());
        driver.quit();
        


	}

}
