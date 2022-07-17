
package pojo.issueWithBuilder;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import pojo.Pojo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fields",
    "update"
})

public class Issue implements Pojo {

    @JsonProperty("fields")
    private Fields fields;
    @JsonProperty("update")
    private Update update;

    @JsonProperty("fields")
    public Fields getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(Fields fields) {
        this.fields = fields;
    }

    @JsonProperty("update")
    public Update getUpdate() {
        return update;
    }

    @JsonProperty("update")
    public void setUpdate(Update update) {
        this.update = update;
    }

    public Issue(Builder builder) {
        this.fields = builder.fields;

    }

    public static class Builder {

        @JsonProperty("fields")
        private Fields fields;
        @JsonProperty("update")
        private Update update;


        public Builder withFields(Fields fields){

            this.fields = fields;
            return this;
        }

        public Issue build(){
            Issue issue = new Issue(this);
            return issue;
        }

    }

}
