package HybridAppTest;

import java.net.MalformedURLException;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HybridAppCapabilities.HybridAppsCapabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HybridAppsTesting extends HybridAppsCapabilities {
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		
		driver = capabilitiesHybrid();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled = true)
	public void loginGeneralStore() throws InterruptedException {
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sourabh Mishra");

		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();

		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(2000);
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(2000);
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))").click();
//		Thread.sleep(2000);
//		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(1).click();

		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(2000);
		 String first = driver.findElement(MobileBy.xpath("//*[@text='$160.97']")).getText();
		 //System.out.println(first);
		 String p1 = first.substring(1);
		 System.out.println(p1);
		
		 Thread.sleep(2000);
		 String second = driver.findElement(MobileBy.xpath("//*[@text='$120.0']")).getText();
		 //System.out.println(second);
		 String p2 = second.substring(1);
		 System.out.println(p2);
		
		 Thread.sleep(2000);
		 String tS = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		 //System.out.println(tS);
		 String tP = tS.substring(2);
		 System.out.println(tP);
		 
		 Double firstProduct = Double.parseDouble(p1);
		 Double secondProduct = Double.parseDouble(p2);
		 Double Totalprice = Double.parseDouble(tP);
			
			
		 Double num = firstProduct + secondProduct;
			if(num.equals(Totalprice)) {
				System.out.println("Cost Matched");
			}else {
				System.out.println("Cost Not Matched");
			}
			
			
		 driver.findElement(MobileBy.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']")).click();
			
			
	}
		
}






















