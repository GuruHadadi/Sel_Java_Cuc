package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by guru on 1/02/18.
 */
public class CommonOperations {

    WebDriver driver;
    By user99GuruName = By.name("uid");
    By password99Guru = By.name("password");
    By titleText =By.className("barone");
    By login = By.name("btnLogin");


    public CommonOperations(WebDriver driver){
        this.driver = driver;
    }

    //Set user name in textbox
    public void setUserName(String strUserName){
        driver.findElement(user99GuruName).sendKeys(strUserName);
    }

    //Set password in password textbox

    public void setPassword(String strPassword){

        driver.findElement(password99Guru).sendKeys(strPassword);

    }



    //Click on login button

    public void clickLogin(){

        driver.findElement(login).click();

    }



    //Get the title of Login Page

    public String getLoginTitle(){

        return    driver.findElement(titleText).getText();

    }

}
