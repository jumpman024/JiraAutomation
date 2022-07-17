package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;


import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.issueWithBuilder.Issues;
import pojo.issueWithBuilder.*;
import utils.*;


import java.util.List;

public class JiraBulkCreateIssue {

    String projectId = "10000";
    String issueType = "10001";
    String summary = "Test Summary";
    String assignee = "Artur Piluck";
    String priorityUrl = "https://mytestproject112.atlassian.net/images/icons/priorities/medium.svg";
    String priorityId = "3";
    String priorityName = "Medium";
    String reporter = "70121:67791744-2599-41ba-8deb-d1e279326691";

    protected List<String> listOfIssues;

    @Test(groups = "mainGroup")
    public void bulkCreationIssues() {
        Fields issue1 = JiraPojoHelper.generateJsonForBulkIssues(projectId, summary, assignee, issueType, priorityId, priorityName, priorityUrl, reporter);
        Fields issue2 = JiraPojoHelper.generateJsonForBulkIssues(projectId, summary, assignee, issueType, priorityId, priorityName, priorityUrl, reporter);
        List<Fields> fieldsList = List.of(issue1,issue2);
//        List<IssueUpdate> bulkIssueList = Arrays.asList(new IssueUpdate(issue1),new IssueUpdate(issue2));
//
//        List<IssueUpdate> issues22 = JiraPojoHelper.populateListForIssues(fieldsList);

        Issues issues = JiraPojoHelper.generateJsonForBulkCreateIssue(fieldsList);

        String res = Authorization.loginToJira()
                .header("Content-Type", "application/json")
                .body(issues)
                .when()
                .post(APIPathes.bulkIssue)
                .then()
                .statusCode(201).contentType(ContentType.JSON)
                .extract().asPrettyString();
        JsonPath jsonPath = new JsonPath(res);
        listOfIssues = jsonPath.getList("issues.key");

        for(int i=0;i<listOfIssues.size();i++){
           Assert.assertTrue(res.contains(listOfIssues.get(i)));
        }
        System.out.println("List of issues created: " + listOfIssues);

    }

    @Test(dependsOnGroups = "mainGroup")
    public void bulkDeleteIssues() {
        for (int i = 0; i < listOfIssues.size(); i++) {
            String issueKey = listOfIssues.get(i);

            Authorization.loginToJira()
                    .header("Content-Type", ContentType.JSON)
                    .when()
                    .delete(APIPathes.issue + issueKey)
                    .then()
                    .statusCode(204).contentType(ContentType.JSON);

            System.out.printf("\nIssue " + issueKey + " was deleted");
            System.out.println("\n");
        }
    }


}
