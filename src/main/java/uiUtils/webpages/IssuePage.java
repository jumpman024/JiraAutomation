package uiUtils.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiUtils.core.BaseSeleniumPage;

public class IssuePage extends BaseSeleniumPage {

    @FindBy(xpath="//button[@data-testid='issue-meatball-menu.ui.dropdown-trigger.button']")
    private WebElement threeDotsButton;

    @FindBy(xpath="//span[text()='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[@data-testid='common.components.confirmation-modal.confirm-button']")
    private WebElement deleteConfirmationButton;

    public IssuePage() {
        PageFactory.initElements(driver,this);
    }

    public IssuePage deleteIssue(){
        String str = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='issue-meatball-menu.ui.dropdown-trigger.button']")))
                .getText();
        System.out.println(str);
        threeDotsButton.click();
        deleteButton.click();
        deleteConfirmationButton.click();
        return this;
    }

}
