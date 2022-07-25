package uiUtils.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiUtils.core.BaseSeleniumPage;

public class IssuePage extends BaseSeleniumPage {

    @FindBy(xpath="//div[@role='presentation']//button[@data-testid='issue-meatball-menu.ui.dropdown-trigger.button']")
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
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(
                driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        threeDotsButton.click();
        deleteButton.click();
        deleteConfirmationButton.click();
        return this;
    }

}
