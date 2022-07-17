package uiUtils.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiUtils.core.BaseSeleniumPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//a//button[@role='presentation']")
    private List<WebElement> jiraProdectsButton;

    public MainPage(){
        PageFactory.initElements(driver,this);
    }

    public MyProjectPage openJiraProjectsPage(){
        jiraProdectsButton.stream().findFirst().get().click();
        return new MyProjectPage();
    }


}
