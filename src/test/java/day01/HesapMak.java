package day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HesapMak {
    AndroidDriver<AndroidElement> driver;

    @Test
    public void deneme() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4");             // cihazin ismi
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");          // cihazin ios android neyse
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");           // cihazin isletim sistemi
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");    // cihazin otomasyonu
        caps.setCapability(MobileCapabilityType.APP,
                "C:\\Users\\Administrator\\IdeaProjects\\Appium_Test\\App\\Calculator_8.6.1 (625857114)_APKPure.apk");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
}
