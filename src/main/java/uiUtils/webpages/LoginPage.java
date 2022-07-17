package uiUtils.webpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiUtils.core.BaseSeleniumPage;

public class LoginPage extends BaseSeleniumPage {

    @FindBy(xpath="//input[@id='username']")
    private WebElement loginField;

    @FindBy(xpath="//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[text()='Log in']")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public MainPage auth(String login, String password){
        loginField.sendKeys(login,Keys.ENTER);
        passwordField.sendKeys(password, Keys.ENTER);
        return new MainPage();
    }
}
