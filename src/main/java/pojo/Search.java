package pojo;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "expand",
    "jql",
    "maxResults",
    "fieldsByKeys",
    "fields",
    "startAt"
})

public class Search implements Pojo{

    @JsonProperty("expand")
    private List<String> expand = null;
    @JsonProperty("jql")
    private String jql;
    @JsonProperty("maxResults")
    private Integer maxResults;
    @JsonProperty("fieldsByKeys")
    private Boolean fieldsByKeys;
    @JsonProperty("fields")
    private List<String> fields = null;
    @JsonProperty("startAt")
    private Integer startAt;

    @JsonProperty("expand")
    public List<String> getExpand() {
        return expand;
    }

    @JsonProperty("expand")
    public void setExpand(List<String> expand) {
        this.expand = expand;
    }

    public Search withExpand(List<String> expand) {
        this.expand = expand;
        return this;
    }

    @JsonProperty("jql")
    public String getJql() {
        return jql;
    }

    @JsonProperty("jql")
    public void setJql(String jql) {
        this.jql = jql;
    }

    public Search withJql(String jql) {
        this.jql = jql;
        return this;
    }

    @JsonProperty("maxResults")
    public Integer getMaxResults() {
        return maxResults;
    }

    @JsonProperty("maxResults")
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public Search withMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    @JsonProperty("fieldsByKeys")
    public Boolean getFieldsByKeys() {
        return fieldsByKeys;
    }

    @JsonProperty("fieldsByKeys")
    public void setFieldsByKeys(Boolean fieldsByKeys) {
        this.fieldsByKeys = fieldsByKeys;
    }

    public Search withFieldsByKeys(Boolean fieldsByKeys) {
        this.fieldsByKeys = fieldsByKeys;
        return this;
    }

    @JsonProperty("fields")
    public List<String> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public Search withFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    @JsonProperty("startAt")
    public Integer getStartAt() {
        return startAt;
    }

    @JsonProperty("startAt")
    public void setStartAt(Integer startAt) {
        this.startAt = startAt;
    }

    public Search withStartAt(Integer startAt) {
        this.startAt = startAt;
        return this;
    }

}
