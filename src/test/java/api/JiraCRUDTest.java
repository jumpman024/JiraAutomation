package api;


import constants.CommonConsts;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import org.testng.annotations.Test;
import pojo.issueWithBuilder.Fields;
import pojo.issueWithBuilder.Issue;
import utils.*;


public class JiraCRUDTest {
    protected static String issueKey;

    @Test(groups = "mainGroup")
    public void createAnIssue(){
        Issue issue = JiraPojoHelper.generateJsonForIssue(
                CommonConsts.PROJECT_ID, CommonConsts.SUMMARY,CommonConsts.ASSIGNEE,
                CommonConsts.ISSUE_TYPE, CommonConsts.PRIORITY_ID,CommonConsts.PRIORITY_NAME,
                CommonConsts.PRIORITY_URL,CommonConsts.REPORTER);
        issueKey = JiraApiActions.createIssue(issue);
        System.out.println(issueKey);
    }

    @Test(groups = "mainGroup")
    public void getIssue(){
        String res = JiraApiActions.getIssue(issueKey);
        Assert.assertTrue(res.contains(issueKey));
    }

    @Test(groups = "mainGroup")
    public void updateIssue(){
        String newSummary = "Test";
        Issue updateIssue = new Issue.Builder().withFields(
                new Fields.Builder().withSummary(newSummary).build()).build();
        JiraApiActions.updateIssue(issueKey,updateIssue);
    }

    @Test(dependsOnGroups = "mainGroup")
    public void deleteIssue(){
        JiraApiActions.deleteIssue(issueKey);
    }

    @Test(dependsOnGroups = "mainGroup")
    public void getDeletedIssue(){
        String str = JiraApiActions.getNonExistingIssue(issueKey);
        Assert.assertTrue(str.contains("Issue does not exist or you do not have permission to see it."));
        System.out.println("Issue " + issueKey +" does not exist!");
    }



}
