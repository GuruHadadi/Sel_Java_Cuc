package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.WilliamHillHomePage;

import java.util.concurrent.TimeUnit;

/**
 * Created by guru on 1/02/18.
 */
public class HorseRace {

    WebDriver driver;
    WilliamHillHomePage objHomePage;

    @cucumber.api.java.Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.williamhill.com.au/");
    }

    @Given("^I am on William Hill main page$")
    public void goToHorseRacingPage() throws Throwable {
        objHomePage = new WilliamHillHomePage(driver);
        objHomePage.click("asdf");

        //driver.findElement(By.linkText("RACING")).click();
        //driver.findElements(By.cssSelector("div[class^=EventTypeHeader]")).get(0).findElement(By.tagName("span")).getText()

    }

}

