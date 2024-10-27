package tests.day05;

import Pages.AllCurrencyPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class AllCurrency {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    AllCurrencyPage page=new AllCurrencyPage();

    @Test
    public void allcurrencyTest() throws InterruptedException, IOException {

        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));
        // uygulamanin acildigi dogrulanir
        Assert.assertTrue(driver.findElementByXPath("//*[@text='CURRENCY CONVERTER']").isDisplayed());

        // cevirmek istedigimiz para birimi japon yen'i olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(393,463,500);
        ReusableMethods.scrollWithUiScrollableAndClick("JPY");

        // cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(384,642,500);
        ReusableMethods.scrollWithUiScrollableAndClick("Turkish Lira");
        page.bir.click();
        page.ikisifir.click();

        // cevrilen tutar screenShot olarak kaydedilir

        // File screenshot=driver.getScreenshotAs(OutputType.FILE);
        //  FileUtils.copyFile(screenshot,new File("ssreenshot.jpg"));

        ReusableMethods.getScreenshot("SonucEkranGoruntusu");

        // Ardindan japon yeni nin tl karsiligi olan tl degeri kaydedilir
        String cevrilenpara=page.sonucalani.getText();

        // kullaniciya sms olarak bildirilir
        driver.sendSMS("11111111111","Paranizin cevrilmis tutari: " +cevrilenpara);

    }
}
