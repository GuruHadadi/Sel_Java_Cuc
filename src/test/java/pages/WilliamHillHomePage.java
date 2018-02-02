package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by guru on 1/02/18.
 */
public class WilliamHillHomePage extends PageObject {

    WebElement element;

    @FindBy(css = "title")
    public WebElement title;

    @FindBy(linkText = "RACING")
    public WebElement lnkRacing;


    public WilliamHillHomePage(WebDriver driver) {
        super(driver);
    }

    /*
        -------- Below are the special elements which require identifying by text
        -------- javascript is used to traverse thru dom and retrieve element thru text
     */
    public WebElement btnAddBetSlip() {
        element = (WebElement)((JavascriptExecutor)driver).executeScript(
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
        return element;
    }
}
