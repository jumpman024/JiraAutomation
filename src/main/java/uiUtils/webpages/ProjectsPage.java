package uiUtils.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiUtils.core.BaseSeleniumPage;

import java.util.concurrent.TimeUnit;

public class ProjectsPage extends BaseSeleniumPage {

    @FindBy(xpath = "//a[contains(@href,'browse')]")
    private WebElement projectButton;

    public ProjectsPage(){
        PageFactory.initElements(driver,this);
    }

    public MyProjectPage clickOnProjectButton(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(projectButton));
        projectButton.click();
        return new MyProjectPage();
    }
}
