package tests.day04;

import Pages.KiwiPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class Kiwi {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    KiwiPage page = new KiwiPage();

    @Test
    public void kiwitest() throws InterruptedException {

        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        Thread.sleep(2000);

        //uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(page.misafirolarakdevambutonu.isDisplayed());

        // misafir olarak devam et e tiklanir
        page.misafirolarakdevambutonu.click();
        Thread.sleep(2000);

        // ardindan gelecek olan 3 adimda da yesil butona basilarak devam edilir

        /*TouchAction action = new TouchAction<>(driver);
        Thread.sleep(2000);
        for (int i = 0; i < 3; i++) {
            action.press(PointOption.point(529, 2049)).release().perform();
            Thread.sleep(500);

         */

        for (int i = 0; i < 3; i++) {
            ReusableMethods.koordinatTiklamaMethodu(549, 2049, 500);
        }

        // Trip type,one way olarak secilir
        page.returnbutonu.click();
        Thread.sleep(2000);
        page.onewaybutonu.click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        Thread.sleep(2000);
        page.frombutonu.click();

        Thread.sleep(2000);
        page.clearbutonu.click();
        Thread.sleep(2000);

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        page.kalkisVarisYazmakutusu.click();
        Thread.sleep(2000);
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Ankara");
        }else {
            page.kalkisVarisYazmakutusu.sendKeys("Ankara");
        }
        page.kalkisbutonu.click();
        Thread.sleep(2000);
        page.secimbutonu.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        Thread.sleep(1000);
        page.tobutonu.click();
        Thread.sleep(2000);
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Frankfurt");
        }else {
            page.kalkisVarisYazmakutusu.sendKeys("Frankfurt");
        }
        page.kalkisbutonu.click();
        Thread.sleep(2000);
        page.secimbutonu.click();
        Thread.sleep(2000);

        // gidis tarihi ekim ayinin 30 u olarak secilir ve set date e tiklanir
        page.tarihbutonu.click();
        ReusableMethods.koordinatTiklamaMethodu(545,1458,500);
        page.SetDatebutonu.click();
        Thread.sleep(2000);

        // search butonuna tiklanir
        page.Seachbutonu.click();

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        page.bestbutonu.click();
        page.enucuzbutonu.click();
        Thread.sleep(2000);

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String fiyat=page.fiyatbutonu.getText();

        driver.sendSMS("2222333444","En ucuz ucus fiyati:"+fiyat);
    }
}
