package headless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo 
{
	static
	{
		WebDriverManager.chromedriver().setup();
	}
	@Test
	public void Demo() throws IOException
	{

		DesiredCapabilities dc3 = new DesiredCapabilities();
		dc3.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc3.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		
		
		ChromeOptions op = new ChromeOptions();
		op.setHeadless(true);
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/name.png");
		FileUtils.copyFile(src, dest);
		driver.close();
		
	}

}
