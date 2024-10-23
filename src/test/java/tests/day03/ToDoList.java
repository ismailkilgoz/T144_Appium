package tests.day03;

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

public class ToDoList {
    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        caps.setCapability("appPackage", "todolist.scheduleplanner.dailyplanner.todo.reminders");
        caps.setCapability("appActivity", "app.todolist.activity.SplashActivity");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void toDoList() throws InterruptedException {
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("todolist.scheduleplanner.dailyplanner.todo.reminders"));

        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementByXPath("//*[@text='Welcome to To-do List']").isDisplayed());


        // Ileri butonlarina tiklanir ve pop-up lar kapatilir
        TouchAction action = new TouchAction((AndroidDriver) driver);

        action.press(PointOption.point(530,1834)).release().perform();
        Thread.sleep(1000);
        action.press(PointOption.point(530,1834)).release().perform();

        driver.findElementByXPath("(//*[@class=\"android.widget.ImageView\"])[1]").click();
        Thread.sleep(1000);
        action.press(PointOption.point(1000,210)).release().perform();
        driver.findElementByXPath("(//*[@class=\"android.widget.ImageView\"])[1]").click();

        // görev ekleme adimina gecilir
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/iv_task_add").click();

        // görev adi girilir
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_create_input").sendKeys("cayi demle");


        // görev kaydedilir
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_create_btn").click();

        Thread.sleep(2000);

        action.press(PointOption.point(875,1208)).release().perform();
        action.press(PointOption.point(875,1208)).release().perform();
        action.press(PointOption.point(875,1208)).release().perform();

        // görev silinir
        action.press(PointOption.point(700, 520))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(260, 520))
                .release()
                .perform();
        //

        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_delete").click();
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/dialog_confirm").click();

        // Görev olusturma sayfasina geri dönüldügü dogrulanir
        Assert.assertTrue(driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/iv_task_add").isDisplayed());
    }

}
