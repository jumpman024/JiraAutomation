package uiUtils.webpages;

import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//input[@data-test-id='search-dialog-input']")
    private WebElement searchBar;


    public MyProjectPage() {
        PageFactory.initElements(driver, this);
    }

    public MyProjectPage clickOnCreateIssueButton() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 20, 20);
        wait.until(ExpectedConditions.visibilityOf(createButton));
        createButton.click();
        System.out.println(createButton.getText());
        return this;
    }

    public String createIssue(String issueSummary, String issueDescription) {
        summary.sendKeys(issueSummary);
        description.click();
        description.sendKeys(issueDescription);
        createIssueButton.click();
        String issueId = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(confirmationWindow))
                .getText();
        return issueId.substring(issueId.indexOf("\"") + 1, issueId.lastIndexOf("\""));
    }

    public IssuePage findIssue(String issueId) {
        if(issueId == null){
            throw new IllegalArgumentException("Issue with such ID doesn't exist in Jira");
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-test-id='search-dialog-input']")))
        .sendKeys(issueId);
        searchBar.sendKeys(Keys.ENTER);
        return new IssuePage();
    }

}


