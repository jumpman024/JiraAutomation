package uiUtils.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiUtils.core.BaseSeleniumPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//a//button[@role='presentation']")
    private List<WebElement> jiraProdectsButton;

    @FindBy(xpath = "//input[@data-test-id='search-dialog-input']")
    private WebElement searchBar;

    public MainPage(){
        PageFactory.initElements(driver,this);
    }

    public MyProjectPage openJiraProjectsPage(){
        jiraProdectsButton.stream().findFirst().get().click();
        return new MyProjectPage();
    }

    public IssuePage findIssue(String issueId) throws InterruptedException {
        if(issueId == null){
            throw new IllegalArgumentException("Issue with such ID doesn't exist in Jira");
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchBar))
        .click();
        searchBar.sendKeys(issueId);
        driver.findElement(By.xpath("//div[@role='none']//a[1]")).click();
        return new IssuePage();
    }


}
