package utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.dashboardWithBuilder.Dashboard;
import pojo.dashboardWithBuilder.Gadget;
import pojo.dashboardWithBuilder.SharePermission;
import pojo.issueWithBuilder.Fields;
import pojo.issueWithBuilder.Issue;
import pojo.Search;
import pojo.issueWithBuilder.IssueUpdate;
import pojo.issueWithBuilder.Issues;

import java.util.List;
import java.util.stream.Collectors;

public class JiraPojoHelper {

    public static Issue generateJsonForIssue(String projectId, String summary, String assignee, String issueTypeId,
                                                      String priorityId, String priorityName, String priorityUrl, String reporter){
        Issue issue = new Issue.Builder().withFields(new Fields.Builder()
                .withProject(projectId)
                .withAssignee(assignee)
                .withPriority(priorityId,priorityName,priorityUrl)
                .withReporter(reporter)
                .withIssueType(issueTypeId)
                .withSummary(summary)
                .build()).build();
        return issue;

    }

    public static Search generateJsonForSearch(List<String> expand, String jql, Integer maxResults, Boolean fieldsByKeys,
                                               List<String> fields, Integer startAt){
        Search search = new Search()
                .withExpand(expand)
                .withJql(jql)
                .withMaxResults(maxResults)
                .withFieldsByKeys(fieldsByKeys)
                .withFields(fields)
                .withStartAt(startAt);
        return search;
    }

    public static Fields generateJsonForBulkIssues(String projectId, String summary, String assignee, String issueTypeId,
                                        String priorityId, String priorityName, String priorityUrl, String reporter){
        Fields fields = new Fields.Builder()
                .withProject(projectId)
                .withAssignee(assignee)
                .withPriority(priorityId,priorityName,priorityUrl)
                .withReporter(reporter)
                .withIssueType(issueTypeId)
                .withSummary(summary)
                .build();
        return fields;
    }

    public static Issues generateJsonForBulkCreateIssue(List<Fields> fieldsList) {
        List<IssueUpdate> issueUpdateList = fieldsList.stream().map(x->{
            IssueUpdate n = new IssueUpdate(x);
            return n;
        }).collect(Collectors.toList());
        return new Issues.Builder().withIssues(issueUpdateList).build();
    }

    public static Dashboard generateJsonForDashboardCreation(String description, String name, List<SharePermission> sharePermissionList){
        Dashboard dashboard = new Dashboard.Builder()
                .withDescription(description)
                .withName(name)
                .withSharePermissions(sharePermissionList).build();
        return dashboard;
    }

    public static Gadget generateJsonForAddGadget(String color,Boolean bool,String moduleKey,
                                                  String title,Integer column,Integer row){
        Gadget gadget = new Gadget.Builder()
                .withColor(color)
                .withIgnoreUriAndModuleKeyValidation(bool)
                .withModuleKey(moduleKey)
                .withPosition(column, row)
                .withTitle(title)
                .build();
        return gadget;
    }


    public static String extractPOJO(Issue issue) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String result = null;
        try {
            result = mapper.writeValueAsString(issue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }


}
