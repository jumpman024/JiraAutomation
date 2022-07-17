
package pojo.issueWithBuilder;




import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fields"
})

public class IssueUpdate {

    @JsonProperty("fields")
    private Fields fields;

    public IssueUpdate(Fields fields) {
        this.fields = fields;
    }

    public IssueUpdate(Builder builder) {
        this.fields = builder.fields;
    }

    @JsonProperty("fields")
    public Fields getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public static class Builder {

        @JsonProperty("fields")
        private Fields fields;

        public Builder withFields(Fields fields){
            this.fields = fields;
            return this;
        }

        public IssueUpdate build(){
            IssueUpdate issueUpdate = new IssueUpdate(this);
            return issueUpdate;
        }

    }

}
