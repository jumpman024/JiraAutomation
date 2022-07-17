package api;

import constants.CommonConsts;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Search;
import utils.*;

import java.util.List;

public class JiraSearchOperation {


    @Test
    public void searchIssue(){
        Search searchForIssue = JiraPojoHelper.generateJsonForSearch(CommonConsts.EXPAND,CommonConsts.JQL
                ,CommonConsts.MAX_RESULTS,CommonConsts.FIELDS_BY_KEY,CommonConsts.FIELDS,CommonConsts.START_AT);

        String res = JiraApiActions.searchIssue(searchForIssue).asString();
        System.out.println("Result of issues: "+ res);
        Assert.assertTrue(res.contains("\"key\":\"FIRST"));
    }
}
