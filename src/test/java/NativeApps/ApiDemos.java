package NativeApps;

import java.net.MalformedURLException;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import NativeCapabilities.APIDemosCapabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
//import io.appium.java_client.touch.LongPressOptions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class ApiDemos extends APIDemosCapabilities {
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void bt() throws MalformedURLException {
		driver = capabilities();
	}
	
	@Test(enabled = false)
	public void test1() throws InterruptedException {
		System.out.println("Api Demos");
		
//		driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();
//		Thread.sleep(2000);
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/checkbox")).click();
//		driver.findElement(MobileBy.xpath("//*[@text='WiFi settings']")).click();
		// 2nd method for using text is AndroidUIAutomator
		// we use AndroidUIAutomator to identify an element using an attribute 
		// for using the attribute we have to use UI selector method 
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/edit")).sendKeys("Sourabh");
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button2")).click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	@Test(enabled = false)
	public void notification() {
		driver.openNotifications();
		
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
	}
	
	@Test(enabled = false)
	public void views() throws InterruptedException {
		
		// if you want to scroll you need 3 things
		// 1> UiAutomator
		// 2> UiScrollable
		// 3> UiSelector
		//
		// If you want to scroll to a particular element then we use scrollIntoView
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(2000);
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))").click();
		//driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		Thread.sleep(2000);
		AndroidElement fishName = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Fish Names\")"));
		Thread.sleep(2000);
		TouchAction tA = new TouchAction(driver);
		tA.longPress(longPressOptions().withElement(element(fishName)).withDuration(ofSeconds(2))).release().perform();

	}
	
	@Test(enabled = false)
	public void dragAndDrop() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		Thread.sleep(2000);
		
		 AndroidElement fromHour = driver.findElement(MobileBy.AccessibilityId("12"));
		
		 AndroidElement toHour = driver.findElement(MobileBy.AccessibilityId("5"));
		 
		 TouchAction tA2 = new TouchAction(driver);
		 
		 tA2.longPress(longPressOptions().withElement(element(fromHour)).withDuration(ofSeconds(2))).moveTo(element(toHour)).release().perform();

//		 AndroidElement fromMinute = driver.findElement(MobileBy.AccessibilityId("00"));
//			
//		 AndroidElement toMinute = driver.findElement(MobileBy.AccessibilityId("25"));
//		 
//		 tA2.longPress(longPressOptions().withElement(element(fromMinute)).withDuration(ofSeconds(2))).moveTo(element(toMinute)).release().perform();

	}
	
	@Test(enabled = true)
	public void dragBalls() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		Thread.sleep(2000);
		
		 AndroidElement target = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
		
		 AndroidElement goal = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
		 
		 TouchAction tA3 = new TouchAction(driver);
		 
		 tA3.longPress(longPressOptions().withElement(element(target)).withDuration(ofSeconds(2)))
		 .moveTo(element(goal)).release().perform();

	}
	
	
	@Test(enabled = true)
	public void sendMessages() {
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		
		driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click();
		
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650) 555-1212");

		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("Hey");
		
		driver.findElement(MobileBy.AccessibilityId("Send")).click();
		
		driver.activateApp("com.google.android.apps.messaging");
		
		String text = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
	
		System.out.println(text);
		
		driver.activateApp("io.appium.android.apis.ApiDemos");
	
	}
	
	
}
















