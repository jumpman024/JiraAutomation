package uiUtils.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiUtils.core.BaseSeleniumPage;

public class IssuePage extends BaseSeleniumPage {

    @FindBy(xpath="//div[@class='pfb8c3-0 eeuplM']//button[@aria-label='Actions']")
    private WebElement threeDotsButton;

    @FindBy(xpath="//span[text()='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[@data-testid='common.components.confirmation-modal.confirm-button']")
    private WebElement deleteConfirmationButton;

    public IssuePage() {
        PageFactory.initElements(driver,this);
    }

    public IssuePage deleteIssue() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
                wait.until(
                driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        Actions actions = new Actions(driver);
        actions.moveToElement(threeDotsButton).click().build().perform();;
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
        deleteConfirmationButton.click();
        return this;
    }

}
