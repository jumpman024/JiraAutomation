
package pojo.issueWithBuilder;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "issueUpdates"
})

public class Issues {

    @JsonProperty("issueUpdates")
    private List<IssueUpdate> issueUpdates = null;

    public Issues(Builder builder) {
        this.issueUpdates = builder.issueUpdates;
    }

    @JsonProperty("issueUpdates")
    public List<IssueUpdate> getIssueUpdates() {
        return issueUpdates;
    }

    @JsonProperty("issueUpdates")
    public void setIssueUpdates(List<IssueUpdate> issueUpdates) {
        this.issueUpdates = issueUpdates;
    }


    public static class Builder {
        @JsonProperty("issueUpdates")
        private List<IssueUpdate> issueUpdates = null;

        public Builder withIssues(List<IssueUpdate> issueUpdateList){
            this.issueUpdates = issueUpdateList;
            return this;
        }

        public Issues build(){
            Issues issues = new Issues(this);
            return issues;
        }

    }

}
