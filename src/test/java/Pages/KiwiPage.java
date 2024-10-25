package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPage {

    public KiwiPage(){
        PageFactory.initElements((WebDriver)Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath="(//*[@class='android.widget.Button'])[4]")
    public WebElement misafirolarakdevambutonu;

    @FindBy(xpath="//*[@text='Return']")
    public WebElement returnbutonu;

    @FindBy(xpath="//*[@text='One way']")
    public WebElement onewaybutonu;

    @FindBy(xpath="//*[@text='From:']")
    public WebElement frombutonu;

    @FindBy(xpath="//*[@content-desc='Clear All']")
    public WebElement clearbutonu;

    @FindBy(xpath="//*[@class='android.widget.EditText']")
    public WebElement kalkisVarisYazmakutusu;


    @FindBy(xpath="(//*[@content-desc='Add destination'])[1]")
    public WebElement kalkisbutonu;

    @FindBy(xpath="//*[@text='Choose']")
    public WebElement secimbutonu;

    @FindBy(xpath="//*[@text='To:']")
    public WebElement tobutonu;

    @FindBy(xpath="//*[@text='Departure:']")
    public WebElement tarihbutonu;

    @FindBy(xpath="//*[@text='Set date']")
    public WebElement SetDatebutonu;

    @FindBy(xpath="(//*[@text='Search'])[1]")
    public WebElement Seachbutonu;

    @FindBy(xpath="//*[@text='Best']")
    public WebElement bestbutonu;

    @FindBy(xpath="//*[@text='Cheapest']")
    public WebElement enucuzbutonu;

    @FindBy(xpath="(//*[@class='android.widget.TextView'])[12]")
    public WebElement fiyatbutonu;


}