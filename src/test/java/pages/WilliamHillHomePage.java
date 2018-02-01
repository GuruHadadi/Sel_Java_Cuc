package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by guru on 1/02/18.
 */
public class WilliamHillHomePage {//extends  CommonOperations{

    WebDriver driver;
    By racingLink = By.cssSelector("uid");

    public WilliamHillHomePage(WebDriver driver){
        this.driver = driver;
    }

    // Click on element
    public void click(String strUserName){
        driver.findElement(racingLink).click();
    }

}
