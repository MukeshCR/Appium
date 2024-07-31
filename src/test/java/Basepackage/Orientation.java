package Basepackage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Orientation extends BaseClass {

	@Test
	public void MissActionsOrientation() throws MalformedURLException {

		// locators in Appium Xapth, id, accessibilityid, classname, androidUIAutomator

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();

		// device rotation to landscape mode
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alerttitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alerttitle, "WiFi settings");

		// copy the text to clipboard
		driver.setClipboardText("Mukesh Wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys("Mukesh Wifi");

		driver.findElement(By.id("android:id/button1")).click();

		// keyboard events like home button, back button,
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
}
