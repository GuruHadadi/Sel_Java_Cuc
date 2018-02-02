package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

/**
 * Created by guru on 1/02/18.
 */
public class HorseRacingPage extends PageObject {

    WebElement element;
    JavascriptExecutor js;

    @FindBy(css = "div[class^=Header_header] h1")
    public WebElement pageTitle;

    @FindBy(css = "div[class^=EventTypeHeader_eventTypeHeader] span")
    public WebElement sectionTitle;

    @FindBy(css = "div[class^=Grid_table] div[class^=RacingHome_availableContainer] div[class^=RacingHome_available]:first-child")
    public WebElement racingGridCell;

    @FindBy (linkText = "Tomorrow]")
    public WebElement  tomorrowTab;

    public HorseRacingPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    /*
        -------- Below are the special elements which require identifying by text
        -------- javascript is used to traverse thru dom and retrieve element thru text
     */
    public WebElement bettingGridCell() {
        return driver.findElements(By.cssSelector(".Grid_table_1dV")).get(1).findElements(By.tagName("a")).get(0);
    }


}



