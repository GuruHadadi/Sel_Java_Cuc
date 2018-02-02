package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by guru on 2/02/18.
 */
public class Elements_Helper1 extends PageObject {

    private WebDriver driver;
    private static WebElement element;

    Elements_Helper1(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public WebElement addBetSlip() {
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
