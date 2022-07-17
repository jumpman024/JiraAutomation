package utils;

public interface APIPathes {

    String login = "/rest/auth/1/session/";
    String issue = "/rest/api/3/issue/";
    String bulkIssue = "/rest/api/2/issue/bulk";
    String events = "/rest/api/2/events/";
    String issueMetaData = "/rest/api/2/issue/createmeta/";
    String searchForIssue = "/rest/api/3/search";
    String createDashboard = "/rest/api/3/dashboard";
    String gadget = "/rest/api/3/dashboard/{dashboardId}/gadget";
    String dashboard = "/rest/api/3/dashboard/{id}";
    String getGadget = "/rest/api/3/dashboard/{dashboardId}/gadget";
    String updateGadget = "/rest/api/3/dashboard/{dashboardId}/gadget/{gadgetId}";
    String deleteGadget = "/rest/api/3/dashboard/{dashboardId}/gadget/{gadgetId}";




}
