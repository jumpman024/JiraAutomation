
package pojo.issueWithBuilder;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "project",
    "issuetype",
    "summary",
    "reporter",
    "assignee",
    "priority",
    "labels"
})

public class Fields {

    @JsonProperty("project")
    private Project project;
    @JsonProperty("issuetype")
    private Issuetype issuetype;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("reporter")
    private Reporter reporter;
    @JsonProperty("assignee")
    private Assignee assignee;
    @JsonProperty("priority")
    private Priority priority;
    @JsonProperty("labels")
    private List<Object> labels = null;

    public Fields(Builder builder) {
        this.project = builder.project;
        this.issuetype = builder.issuetype;
        this.summary = builder.summary;
        this.reporter = builder.reporter;
        this.assignee = builder.assignee;
        this.priority = builder.priority;
    }

    @JsonProperty("project")
    public Project getProject() {
        return project;
    }

    @JsonProperty("project")
    public void setProject(Project project) {
        this.project = project;
    }

    @JsonProperty("issuetype")
    public Issuetype getIssuetype() {
        return issuetype;
    }

    @JsonProperty("issuetype")
    public void setIssuetype(Issuetype issuetype) {
        this.issuetype = issuetype;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("reporter")
    public Reporter getReporter() {
        return reporter;
    }

    @JsonProperty("reporter")
    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    @JsonProperty("assignee")
    public Assignee getAssignee() {
        return assignee;
    }

    @JsonProperty("assignee")
    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    @JsonProperty("priority")
    public Priority getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @JsonProperty("labels")
    public List<Object> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<Object> labels) {
        this.labels = labels;
    }


    public static class Builder {

        @JsonProperty("project")
        private Project project;
        @JsonProperty("issuetype")
        private Issuetype issuetype;
        @JsonProperty("summary")
        private String summary;
        @JsonProperty("reporter")
        private Reporter reporter;
        @JsonProperty("assignee")
        private Assignee assignee;
        @JsonProperty("priority")
        private Priority priority;
        @JsonProperty("labels")
        private List<Object> labels = null;



        public Builder withProject(String projectId){
            Project project = new Project();
            project.setId(projectId);
            this.project = project;
            return this;
        }

        public Builder withIssueType(String issuetypeId){
            Issuetype issuetype = new Issuetype();
            issuetype.setId(issuetypeId);
            this.issuetype = issuetype;
            return this;
        }

        public Builder withSummary(String summary){
            this.summary = summary;
            return this;
        }

        public Builder withReporter(String reporterId){
            Reporter reporter = new Reporter();
            reporter.setId(reporterId);
            this.reporter = reporter;
            return this;
        }

        public Builder withAssignee(String assigneeName){
            Assignee assignee = new Assignee();
            assignee.setName(assigneeName);
            this.assignee = assignee;
            return this;
        }

        public Builder withPriority(String id,String name, String iconUrl) {
            Priority priority = new Priority();
            priority.setId(id);
            priority.setName(name);
            priority.setIconUrl(iconUrl);
            this.priority = priority;
            return this;
        }

        public Fields build(){
            Fields fields = new Fields(this);
            return fields;
        }

    }

}
