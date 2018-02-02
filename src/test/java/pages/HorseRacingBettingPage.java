package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Created by guru on 1/02/18.
 */
public class HorseRacingBettingPage extends PageObject {

    //  Generic Elements
    WebElement element;
    JavascriptExecutor js;

    //  constructor
    public HorseRacingBettingPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    //  Page elements
    @FindBy(css = "#mystery-bet input")
    public WebElement bettingAmountInput;

    @FindBy(css = "button[class^=MysteryBet_button]")
    public WebElement addToBetSlipButton;

    @FindBy(css = "div[class^=SideBar_header] span[class^=Icon_icon]")
    public List<WebElement> betSlipTopButtons;

    @FindBy(css = "span[class^=SideBar_badge]")
    public WebElement betSlipCountText;

    @FindBy(css = "div[class^=Betslip_betslipContent] div[class^=TicketContainer_container]")
    public WebElement betSlipSummaryBettingTypeText;

    @FindBy(css = "div[class^=TicketContainer_container] div[class^=StakeNew_doubleStakeBlock] input")
    public WebElement betSlipSummaryAmountInput;

    @FindBy(css = "[class^=Betslip_summaryRow] button")
    public WebElement betSlipSummaryClearButton;

    @FindBy (css= "[class^=Modal_body]")
    public List<WebElement>  loginFunnyDialog;


    /*
        -------- Below are the special elements which require identifying slightly special requirement
        -------- javascript is used to traverse thru dom and retrieve element thru text
     */
    public WebElement bettingTypeDropDown() {
        //WebElement element = driver.findElements(By.cssSelector("#mystery-bet svg")).get(1);
        //js.executeScript("arguments[0].scrollIntoView();", element);
        //js.executeScript("scroll(250,300)");// temp solution to make the element visible on screen
        /*
            - clicking on only available bets is slightly tricky (specially given the element structure organised in the dom and highly dynamic nature of elements)
            - this can be approached in multiple ways.
            - for demo, i have just scrolled till the element ... this can be implemented more elegantly
            - i am basically scrolling till the last but 2nd row of the grid to make my desired elements visible
         */
        List<WebElement> elements= driver.findElements(By.cssSelector("div[class^=RaceCardList_gridRow]"));
        element = elements.get(elements.size() - 2);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return driver.findElements(By.cssSelector("#mystery-bet svg")).get(1);
    }

    public WebElement bettingTypeDropDownOption(String option) {
        WebElement e = (WebElement) (js.executeScript(
                "{var lst = document.querySelectorAll('[class^=Options_options] span');\n" +
                        "    var searchText = '" + option + "';\n" +
                        "    var found;\n" +
                        "\n" +
                        "    for (var i = 0; i < lst.length; i++) {\n" +
                        "      if (lst[i].textContent == searchText) {\n" +
                        "        found = lst[i];\n" +
                        "        return found;\n" +
                        "        break;\n" +
                        "      }\n" +
                        "    }}"
        ));
        return e;
    }


    /*
        -------- Below are the action methods
     */

    public void enterBettingAmount(String amt){
        bettingAmountInput.clear();
        js.executeScript("arguments[0].value = "+amt, bettingAmountInput);
        bettingAmountInput.sendKeys(Keys.TAB);
        driver.findElement(By.cssSelector("div[class^=MysteryBet_header]")).click();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickBetSlipButton(){
        if(!betSlipSummaryClearButton.isDisplayed()){
            betSlipTopButtons.get(1).click();
        }
    }

    public void handleLoginDialog(WebElement element, Wait wait) throws InterruptedException {
        if(loginFunnyDialog.size() > 0) {
            loginFunnyDialog.get(0).sendKeys(Keys.ESCAPE);
//            Thread.sleep(1000);//
//            driver.findElements(By.cssSelector("div[class^=Modal_header] svg")).get(1).click();
//            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        }
    }

}



