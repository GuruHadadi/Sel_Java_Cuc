package steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.WilliamHillHomePage_2;

import java.util.concurrent.TimeUnit;

/**
 * Created by guru on 1/02/18.
 */
public class HorseRace {
/*

    static WebDriver driver;
    WilliamHillHomePage_2 objHomePage;
    String baseUrl = "https://www.williamhill.com.au/";

    @cucumber.api.java.Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        WilliamHillHomePage_2.setDriver(driver);
    }

    @Given("^I am on asdf William Hill main page$")
    public void goToHorseRacingPage() throws Throwable {
        objHomePage.addBetSlip.click();
        //objHomePage = new WilliamHillHomePage_2(driver);
        objHomePage.click("asdf");
*/

    ////driver.findElement(By.cssSelector("div[class^=Header_header] h1")).getText()
//    driver.findElement(By.cssSelector("div[class^=EventTypeHeader_eventTypeHeader] span")).getText()

//driver.findElement(By.cssSelector("div[class^=Header_header] h1")).getText()
//"Sports Betting Online & Horse Racing in Australia - William Hill"
        //"Horse Racing Odds & Online Betting at William Hill"

        //driver.findElement(By.linkText("RACING")).click();
        //driver.findElements(By.cssSelector("div[class^=EventTypeHeader]")).get(0).findElement(By.tagName("span")).getText()

    //driver.findElements(By.cssSelector(".Grid_table_1dV")).get(1).findElements(By.tagName("a")).get(0).click();
        //
        //driver.findElements(By.cssSelector("#mystery-bet svg")).get(1).click();
        //driver.findElement(By.cssSelector(".Portal_portal_11Y")).findElements(By.tagName("span")).get(4).click();
//        driver.findElement(By.cssSelector("#mystery-bet")).findElement(By.tagName("input")).clear();
//        driver.findElement(By.cssSelector("#mystery-bet")).findElement(By.tagName("input")).sendKeys("9");


/*
    - set text 10.5

    JavascriptExecutor js = (JavascriptExecutor) driver;
WebElement e = (WebElement)((JavascriptExecutor)driver).executeScript("" +
        "return document.querySelector('#mystery-bet input')"
);
js.executeScript("arguments[0].value = 10.5", e);
 */

        /*
        WebElement e = (WebElement)((JavascriptExecutor)driver).executeScript(
                "{var aTags = document.querySelectorAll('#mystery-bet button');\n" +
                        "    var searchText = \"Add to bet slip\";\n" +
                        "    var found;\n" +
                        "\n" +
                        "    for (var i = 0; i < aTags.length; i++) {\n" +
                        "      if (aTags[i].textContent == searchText) {\n" +
                        "        found = aTags[i];\n" +
                        "        return found;\n" +
                        "        break;\n" +
                        "      }\n" +
                        "    }}"
        );
        e.click();
        */


        //driver.findElement(By.cssSelector("span[class^=SideBar_badge]")).getText()


        /*
        WebElement e = (WebElement)((JavascriptExecutor)driver).executeScript(
                "{var lst = document.querySelectorAll('[class^=SideBar_header] span');\n" +
                        "    var searchText = \"Bet slip\";\n" +
                        "    var found;\n" +
                        "\n" +
                        "    for (var i = 0; i < lst.length; i++) {\n" +
                        "      if (lst[i].textContent == searchText) {\n" +
                        "        found = lst[i];\n" +
                        "        return found;\n" +
                        "        break;\n" +
                        "      }\n" +
                        "    }}"
        );
        e.click();
         */

        //driver.findElement(By.cssSelector("div[class^=ExoticHeader_title]")).getText()

        /*
        WebElement e = (WebElement)((JavascriptExecutor)driver).executeScript(
                "{var lst = document.querySelectorAll('[class^=Betslip_field]');\n" +
                        "    var searchText = 'Total Cost';\n" +
                        "    var found;\n" +
                        "\n" +
                        "    for (var i = 0; i < lst.length; i++) {\n" +
                        "      if (lst[i].textContent == searchText) {\n" +
                        "        found = lst[i].nextElementSibling;\n" +
                        "        return found;\n" +
                        "        break;\n" +
                        "      }\n" +
                        "    }}"
        );
        e.getText();
         */

        /*
        //  This statement returns the first button-element with in the summary-row-class-area-elements.
    driver.findElement(By.cssSelector("[class^=Betslip_summaryRow] button")).click();
         */



    }



