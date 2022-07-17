package uiUtils.webhelpers;

import constants.CommonConsts;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojo.Search;
import utils.*;

public class WebHelper {


    public static Boolean searchForCreatedIssue(String issueId) {
        String jql = "project = \"FIRST\" and key = "+ "\""+issueId+"\"";


        Search searchForIssue = JiraPojoHelper.generateJsonForSearch(CommonConsts.EXPAND, jql
                ,CommonConsts.MAX_RESULTS, CommonConsts.FIELDS_BY_KEY, CommonConsts.FIELDS, CommonConsts.START_AT);

        Response res = HTTPMethods.post(APIPathes.searchForIssue, searchForIssue);
        if ((res.path("issues.key") == null)) {
            System.out.println("Issue with name " + "\""+ issueId + "\""+" NOT found in Jira");
            return false;
        } if ((res.path("issues.key").toString().contains(issueId)) && (res.statusCode() == 200)) {
            System.out.println("Issue with name " + "\""+ issueId + "\""+" found in Jira");
            return true;
        }
        return false;
    }

    @Test
    public void test1(){
        searchForCreatedIssue("FIRST-1");
        int a= 0;

    }

//    @Test
//    public void test2(){
//        HTTPMethods.getIssue(APIPathes.issue +"FIRST-1");
//        int a= 0;
//
//    }

}
