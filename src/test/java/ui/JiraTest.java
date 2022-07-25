package ui;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import readProperties.ConfigProvider;
import uiUtils.webhelpers.WebHelper;
import uiUtils.webpages.LoginPage;
import uiUtils.core.BaseSeleniumTest;

public class JiraTest extends BaseSeleniumTest {

    private static String issueId;

    @Test
    public void _1_createJiraIssue() throws InterruptedException {

        String summary = "test";
        String description = "super test";

        issueId =  new LoginPage().auth(ConfigProvider.ADMIN_LOGIN,ConfigProvider.ADMIN_PASSWORD)
                .openJiraProjectsPage()
                .clickOnCreateIssueButton()
                .createIssue(summary,description);
//        Assertions.assertTrue(WebHelper.searchForCreatedIssue(issueId));
    }

    @Test
    public void _2_deleteIssue() throws InterruptedException {
        new LoginPage().auth(ConfigProvider.ADMIN_LOGIN,ConfigProvider.ADMIN_PASSWORD)
                .findIssue(issueId)
                .deleteIssue();
        Assertions.assertFalse(WebHelper.searchForCreatedIssue(issueId));
    }



}