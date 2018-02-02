package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import pages.HorseRacingBettingPage;
import pages.HorseRacingPage;
import pages.WilliamHillHomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by guru on 1/02/18.
 */
public class HorseRaceTests {

    //  required basic variables
    WebDriver driver;
    String baseUrl = "https://www.williamhill.com.au/";
    Wait<WebDriver> wait;
    String browser = System.getProperty("browser");

    //  this is my browser stack credentials :)
    private static final String USERNAME = "guruhadadi1";
    private static  final String AUTOMATE_KEY = "CREdthD9fPLQZUp11qyr";
    private static  final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    //  Pages
    WilliamHillHomePage objHome;
    HorseRacingPage racePage;
    HorseRacingBettingPage bettingPage;

    @cucumber.api.java.Before
    public void setup() throws MalformedURLException {

        if(browser.equals("firefox")){
            System.out.println("Running test in local firefox");
            driver = new FirefoxDriver();
        }
        else if(browser.equals("chrome")){
            System.out.println("Running test in local chrome");
            System.setProperty("webdriver.chrome.driver", "/Users/guru/Documents/Projects/TestAutomation/Sel_Java_Cuc/src/test/resources/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browser.equals("cloud_firefox")){
            System.out.println("Running test in cloud - browserstack - firefox");
            driver = new RemoteWebDriver(new URL(URL), DesiredCapabilities.firefox());
        }
        else{
            //  default
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(3, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

    }

    @BeforeClass
    public void mysetup(){
        System.out.println("set up method");
    }

    @AfterClass
    public void mycleanup(){
        System.out.println("clean up method");
    }

    @cucumber.api.java.After
    public void cleanup() {
        //  clear all betting
        if(bettingPage != null) {
            if (bettingPage.betSlipSummaryClearButton.isDisplayed()) {
                bettingPage.betSlipSummaryClearButton.click();
            }
        }
        driver.close();
    }

    @Given("^I am on William Hill main page$")
    public void goToHorseRacingPage() throws Throwable {
        driver.get(baseUrl);
        objHome = new WilliamHillHomePage(driver);
        Assert.assertTrue(driver.getTitle().equals("Sports Betting Online & Horse Racing in Australia - William Hill"));
    }

    @And("^I click on Racing link$")
    public void iClickOnRacingLink() throws Throwable {
        objHome.lnkRacing.click();
        racePage = new HorseRacingPage(driver);
        wait.until(ExpectedConditions.visibilityOf(racePage.pageTitle));
        Assert.assertTrue(racePage.pageTitle.getText().equals("Racing"));
        Assert.assertTrue(racePage.sectionTitle.getText().equals("Horse Racing"));
    }

    @And("^I click on any available Horse Racking Betting cell$")
    public void iClickOnHorseRackingBettingCell() throws Throwable {
        //driver.findElement(By.linkText("Tomorrow")).click();
        //Thread.sleep(5000);
//        wait.until(ExpectedConditions.elementToBeClickable(racePage.racingGridCell));
        racePage.racingGridCell.click();
        bettingPage = new HorseRacingBettingPage(driver);
        wait.until(ExpectedConditions.visibilityOf(bettingPage.addToBetSlipButton));
        Assert.assertTrue(bettingPage.getTitle().contains("Horse Racing Betting"));
    }

    @When("^I enter (.*?) and (.*?)$")
    public void iEnterAnd(String bettingType, String stake) throws Throwable {
        bettingPage.bettingTypeDropDown().click();
        bettingPage.bettingTypeDropDownOption(bettingType).click();
        bettingPage.enterBettingAmount(stake);
        Assert.assertEquals(bettingPage.addToBetSlipButton.isEnabled(), true);
    }

    @And("^click on Add to Bet slip button$")
    public void clickOnAddToBetSlip() throws Throwable {
        bettingPage.addToBetSlipButton.click();
        //bettingPage.handleLoginDialog(bettingPage.addToBetSlipButton, wait);
    }

    @Then("^the added (.*?) and (.*?) displays correctly in the betslip summary area$")
    public void theBettingTypeAndStakeDisplaysInBetslipSummaryArea(String bettingType, String stake) throws Throwable {
        bettingPage.clickBetSlipButton();
        Assert.assertTrue(bettingPage.betSlipCountText.getText().contains("1"));
        Assert.assertTrue(bettingPage.betSlipSummaryBettingTypeText.getText().contains(bettingType));
        Assert.assertTrue(bettingPage.betSlipSummaryAmountInput.getAttribute("value").contains(stake));
    }

}

