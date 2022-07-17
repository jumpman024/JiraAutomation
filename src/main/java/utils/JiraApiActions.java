package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import pojo.Search;
import pojo.issueWithBuilder.Issue;

public class JiraApiActions {

    public static String createIssue(Issue issuePOJO){
        Response response = HTTPMethods.post(APIPathes.issue,issuePOJO);
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()));
        return response.path("key");
    }

    public static String getIssue(String issueKey){
        Response response = HTTPMethods.get(APIPathes.issue+issueKey);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()));
        return response.asString();
    }

    public static String getNonExistingIssue(String issueKey) {
        Response response = HTTPMethods.get(APIPathes.issue + issueKey);
        Assert.assertEquals(response.statusCode(), 404);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()));
        return response.asString();
    }

    public static void deleteIssue(String issueKey){
        Response response = HTTPMethods.delete(APIPathes.issue+issueKey);
        Assert.assertEquals(response.statusCode(), 204);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()));
    }

    public static Response searchIssue(Search searchPOJO){
        Response response = HTTPMethods.post(APIPathes.searchForIssue,searchPOJO);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()));
        return response;
    }

    public static String searchForNonExistingIssue(Search searchPOJO){
        Response response = HTTPMethods.post(APIPathes.searchForIssue,searchPOJO);
        Assert.assertEquals(response.statusCode(), 404);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()));
        return response.asString();
    }

    public static String updateIssue(String issueKey,Issue updatePojo){
        Response response = HTTPMethods.put(APIPathes.issue+issueKey,updatePojo);
        Assert.assertEquals(response.statusCode(), 204);
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()));
        return response.asString();
    }



}
