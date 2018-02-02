package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HorseRacingBettingPage;
import pages.HorseRacingPage;
import pages.WilliamHillHomePage;
import pages.WilliamHillHomePage_2;

import java.util.concurrent.TimeUnit;

/**
 * Created by guru on 1/02/18.
 */
public class HorseRaceTests {

    //  required basic variables
    WebDriver driver;
    String baseUrl = "https://www.williamhill.com.au/";
    Wait<WebDriver> wait;

    //  Pages
    WilliamHillHomePage objHome;
    HorseRacingPage racePage;
    HorseRacingBettingPage bettingPage;

    @cucumber.api.java.Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(20, TimeUnit.SECONDS)
                .pollingEvery(3, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

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

    @When("^I click on Horse Racking Betting cell$")
    public void iClickOnHorseRackingBettingCell() throws Throwable {
        driver.findElement(By.linkText("Tomorrow")).click();
        Thread.sleep(5000);
//        wait.until(ExpectedConditions.elementToBeClickable(racePage.racingGridCell));
        racePage.racingGridCell.click();
        bettingPage = new HorseRacingBettingPage(driver);
        wait.until(ExpectedConditions.visibilityOf(bettingPage.addToBetSlipButton));
        Assert.assertTrue(bettingPage.getTitle().contains("Horse Racing Betting"));
    }

    @When("^I enter betting type and amount$")
    public void iEnterBettingTypeAndAmount() throws Throwable {
        bettingPage.bettingTypeDropDown().click();
        bettingPage.bettingTypeDropDownOption("Quinella").click();
        bettingPage.enterBettingAmount("10.5");
        Assert.assertEquals(bettingPage.addToBetSlipButton.isEnabled(), true);
    }

    @And("^click on Add to Bet slip$")
    public void clickOnAddToBetSlip() throws Throwable {
        bettingPage.addToBetSlipButton.click();
        bettingPage.handleLoginDialog(bettingPage.addToBetSlipButton, wait);
    }

    @Then("^the betting type and stake displays in betslip summary area$")
    public void theBettingTypeAndStakeDisplaysInBetslipSummaryArea() throws Throwable {
        bettingPage.clickBetSlipButton();
        //bettingPage.handleLoginDialog(bettingPage.betSlipTopButtons.get(1), wait);
        //wait.until(ExpectedConditions.visibilityOf(bettingPage.betSlipSummaryClearButton));
//        Assert.assertTrue(bettingPage.betSlipSummaryClearButton.isDisplayed());
        Assert.assertTrue(bettingPage.betSlipCountText.getText().contains("1"));
        Assert.assertTrue(bettingPage.betSlipSummaryBettingTypeText.getText().contains("Quinella"));
        Assert.assertTrue(bettingPage.betSlipSummaryAmountInput.getAttribute("value").contains("10.5"));
    }
}

