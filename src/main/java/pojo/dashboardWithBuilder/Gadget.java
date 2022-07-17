
package pojo.dashboardWithBuilder;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "color",
    "ignoreUriAndModuleKeyValidation",
    "position",
    "title",
    "moduleKey"
})

public class Gadget {

    @JsonProperty("color")
    private String color;
    @JsonProperty("ignoreUriAndModuleKeyValidation")
    private Boolean ignoreUriAndModuleKeyValidation;
    @JsonProperty("position")
    private Position position;
    @JsonProperty("title")
    private String title;
    @JsonProperty("moduleKey")
    private String moduleKey;

    public Gadget(Builder builder) {
        this.color = builder.color;
        this.ignoreUriAndModuleKeyValidation= builder.ignoreUriAndModuleKeyValidation;
        this.position = builder.position;
        this.title = builder.title;
        this.moduleKey = builder.moduleKey;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("ignoreUriAndModuleKeyValidation")
    public Boolean getIgnoreUriAndModuleKeyValidation() {
        return ignoreUriAndModuleKeyValidation;
    }

    @JsonProperty("ignoreUriAndModuleKeyValidation")
    public void setIgnoreUriAndModuleKeyValidation(Boolean ignoreUriAndModuleKeyValidation) {
        this.ignoreUriAndModuleKeyValidation = ignoreUriAndModuleKeyValidation;
    }

    @JsonProperty("position")
    public Position getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Position position) {
        this.position = position;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("moduleKey")
    public String getModuleKey() {
        return moduleKey;
    }

    @JsonProperty("moduleKey")
    public void setModuleKey(String moduleKey) {
        this.moduleKey = moduleKey;
    }

    public static class Builder {
        @JsonProperty("color")
        private String color;
        @JsonProperty("ignoreUriAndModuleKeyValidation")
        private Boolean ignoreUriAndModuleKeyValidation;
        @JsonProperty("position")
        private Position position;
        @JsonProperty("title")
        private String title;
        @JsonProperty("moduleKey")
        private String moduleKey;

        public Builder withColor(String color){
            this.color = color;
            return this;
        }

        public Builder withIgnoreUriAndModuleKeyValidation(Boolean bool){
            this.ignoreUriAndModuleKeyValidation = bool;
            return this;
        }

        public Builder withPosition(Integer column,Integer row){
            Position position = new Position.Builder().withColumn(column).withRow(row).build();
            this.position = position;
            return this;
        }

        public Builder withTitle(String title){
            this.title = title;
            return this;
        }

        public Builder withModuleKey(String moduleKey){
            this.moduleKey = moduleKey;
            return this;
        }

        public Gadget build(){
            Gadget gadget = new Gadget(this);
            return gadget;
        }
    }

}
