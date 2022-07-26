package uiUtils.webpages;

import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiUtils.core.BaseSeleniumPage;


public class MyProjectPage extends BaseSeleniumPage {

    @FindBy(id = "createGlobalItem")
    private WebElement createButton;

    @FindBy(xpath = "//input[@id='summary-field']")
    private WebElement summary;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement description;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createIssueButton;

    @FindBy(xpath = "//div[@data-testid='jira-issue-create.modal.create-form.success-flag']")
    private WebElement confirmationWindow;



    public MyProjectPage() {
        PageFactory.initElements(driver, this);
    }

    public MyProjectPage clickOnCreateIssueButton() throws InterruptedException {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(createButton).click().build().perform();
//        createButton.click();
        return this;
    }

    public String createIssue(String issueSummary, String issueDescription) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(summary)).sendKeys(issueSummary);
        wait.until(ExpectedConditions.elementToBeClickable(description)).click();
        description.sendKeys(issueDescription);
        createIssueButton.click();
        String issueId = wait.until(ExpectedConditions.visibilityOf(confirmationWindow)).getText();
        return issueId.substring(issueId.indexOf("\"") + 1, issueId.lastIndexOf("\""));
    }


}


