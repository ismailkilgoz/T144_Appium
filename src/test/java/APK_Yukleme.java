import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class APK_Yukleme {

    AndroidDriver<AndroidElement>driver;

    @Test
    public void deneme() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");//cihazin adi
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//cihazin android olmasini tanimladik
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");//Android in versiyonunu yazdik
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.APP,
                "C:\\Users\\Administrator\\IdeaProjects\\Appium_144\\App\\Kiwi.com - Book Cheap Flights_2023.14.0_Apkpure.apk");


        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
