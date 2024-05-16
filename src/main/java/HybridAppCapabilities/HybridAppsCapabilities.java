package HybridAppCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class HybridAppsCapabilities {
	public static AndroidDriver<AndroidElement>  capabilitiesHybrid() throws MalformedURLException {
		DesiredCapabilities dc2 = new DesiredCapabilities();
		dc2.setCapability(MobileCapabilityType.DEVICE_NAME, "newPhone");
		dc2.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc2.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		dc2.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
		dc2.setCapability(MobileCapabilityType.NO_RESET, false);
		dc2.setCapability(MobileCapabilityType.AUTOMATION_NAME , AutomationName.ANDROID_UIAUTOMATOR2);
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc2);
		return driver;
	}
}
