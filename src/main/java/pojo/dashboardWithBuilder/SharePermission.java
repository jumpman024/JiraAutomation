
package pojo.dashboardWithBuilder;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type"
})

public class SharePermission {

    @JsonProperty("type")
    private String type;

    public SharePermission(Builder builder) {
        this.type = builder.type;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public static class Builder {

        @JsonProperty("type")
        private String type;

        public Builder withType(String type){
            this.type = type;
            return this;
        }

        public SharePermission build(){
            SharePermission sharePermission = new SharePermission(this);
            return sharePermission;
        }

    }

}
