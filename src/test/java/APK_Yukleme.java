import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.Driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class APK_Yukleme {

    AndroidDriver<AndroidElement>androidDriver= Driver.getAndroidDriver();

    @Test
    public void apkSetup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");//cihazin adi
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//cihazin android olmasini tanimladik
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");//Android in versiyonunu yazdik
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.APP,
                "C:\\Users\\Administrator\\IdeaProjects\\Appium_144\\App\\all-currency-converter-3-9-0 (1).apk");


        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
