package WebAppsTest;

import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebTest {
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	
	public void  capabilities() throws MalformedURLException {
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "newPhone");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\91798\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c",false));
	driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	
  }
	
	@Test
	public void Test1() {
		driver.get("https://www.google.com");
		driver.findElement(MobileBy.xpath("//textarea[@class='gLFyf']")).sendKeys("Masai" , Keys.ENTER);

		// Other way to Enter 
		//		Actions act = new Actions(driver);
		//		act.sendKeys(Keys.ENTER).build().perform();

		}
		
}













