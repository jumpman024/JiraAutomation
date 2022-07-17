package constants;

import java.util.List;

public final class CommonConsts {

    //auth
    public static final String BASE_URI = "https://mytestproject112.atlassian.net";
    public static final String USERNAME = "jumpman024@gmail.com";
    public static final String PASSWORD = "MLeliJRtybOHXjgnIkWv622E";

    //data for issue json generate
    public static String PROJECT_ID = "10000";
    public static String ISSUE_TYPE = "10001";
    public static String SUMMARY = "Test Summary";
    public static String ASSIGNEE = "Artur Piluck";
    public static String PRIORITY_URL = "https://mytestproject112.atlassian.net/images/icons/priorities/medium.svg";
    public static String PRIORITY_ID = "3";
    public static String PRIORITY_NAME = "Medium";
    public static final String REPORTER = "70121:67791744-2599-41ba-8deb-d1e279326691";

    //data for dashboard and gadget json generate
    public static String COLOR = "blue";
    public static Boolean IGNORE_URI_AND_MODULE_KEY_VALIDATION = false;
    public static Integer COLUMN = 1;
    public static Integer ROW = 0;
    public static String TITLE = "Activity Stream";
    public static String MODULE_KEY = "com.atlassian.jira.gadgets:bubble-chart-dashboard-item";
    public static String NAME = "Auditors dashboard";
    public static String DESCRIPTION = "A dashboard to help auditors identify sample of issues to check.";
    public static String TYPE = "private";

    //data for search json generate
    public static List<String> EXPAND = List.of("names","names", "operations");
    public static String JQL = "project = 'FIRST'";
    public static Integer MAX_RESULTS = 15;
    public static Boolean FIELDS_BY_KEY = false;
    public static List<String> FIELDS = List.of("summary","status","assignee");
    public static Integer START_AT = 0;

}
