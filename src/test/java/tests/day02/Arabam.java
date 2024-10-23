package tests.day02;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Arabam {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");             // cihazin ismi
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");          // cihazin ios android neyse
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");           // cihazin isletim sistemi
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");    // cihazin otomasyonu

        //caps.setCapability(MobileCapabilityType.APP,
        //        "C:\\Users\\Administrator\\IdeaProjects\\Appium_144\\App\\arabam-com-5-4-1.apk");

        caps.setCapability("appPackage", "com.dogan.arabam");
        // AppPackage uzerinde calisacak oldugumuz uygulamanin kimlik bilgisidir. Apk infodan kimlik bilgisi bulunur
        caps.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");
        // calisacagimiz sayfaya direkt ulasalim diye bu activity bize gerekiyor

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void test01() throws InterruptedException {

        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // uygulamanin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());

        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("(//android.widget.ImageView[@resource-id=\"com.dogan.arabam:id/navigation_bar_item_icon_view\"])[2]").click();

        // kategori olarak otomobil secilir
        driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.dogan.arabam:id/recyclerViewCategory\"]/android.view.ViewGroup[1]").click();


        // arac olarak Volkswagen secilir

        Thread.sleep(2000);
        TouchAction action = new TouchAction((AndroidDriver) driver);
        action.press(PointOption.point(500, 1800)) // Başlangıç noktası
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .moveTo(PointOption.point(500, 200)) // Hedef nokta
                .release()
                .perform();
        action.press(PointOption.point(500, 1800)) // Başlangıç noktası
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .moveTo(PointOption.point(500, 200)) // Hedef nokta
                .release()
                .perform();

        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();

        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Comfortline']").click();

        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        //driver.findElementById("com.dogan.arabam:id/constraintLayoutSorting").click();

        action.press(PointOption.point(402,406)).release().perform();

        driver.findElementByXPath("(//android.widget.RelativeLayout[@resource-id=\"com.dogan.arabam:id/rlytBottomSheet\"])[2]").click();
        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir


        // driver.findElementByXPath("(//android.view.ViewGroup[@resource-id=\"com.dogan.arabam:id/clItemAdvertList\"])[1]").click();
        Thread.sleep(1000);
        String ilkAracFiyatText = driver.findElementByXPath("(//*[@resource-id=\"com.dogan.arabam:id/tvPrice\"])[1]").getText();

        String ilkAracFiyatDuzenleme = ilkAracFiyatText.replace(".", "").replace(" TL", "");
        // replaceAll(\\D"

        int ilkAracFiyat = Integer.parseInt(ilkAracFiyatDuzenleme);

        int beklenenFiyat = 500000;

        Assert.assertTrue(ilkAracFiyat > beklenenFiyat);
    }
}
