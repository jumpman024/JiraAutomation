
package pojo.dashboardWithBuilder;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;




@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "editPermissions",
    "name",
    "description",
    "sharePermissions"
})

public class Dashboard {

    @JsonProperty("editPermissions")
    private List<Object> editPermissions = null;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("sharePermissions")
    private List<SharePermission> sharePermissions = null;

    public Dashboard(Builder builder) {
        this.editPermissions = builder.editPermissions;
        this.name = builder.name;
        this.description = builder.description;
        this.sharePermissions = builder.sharePermissions;
    }

    @JsonProperty("editPermissions")
    public List<Object> getEditPermissions() {
        return editPermissions;
    }

    @JsonProperty("editPermissions")
    public void setEditPermissions(List<Object> editPermissions) {
        this.editPermissions = editPermissions;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("sharePermissions")
    public List<SharePermission> getSharePermissions() {
        return sharePermissions;
    }

    @JsonProperty("sharePermissions")
    public void setSharePermissions(List<SharePermission> sharePermissions) {
        this.sharePermissions = sharePermissions;
    }

    public static class Builder {
        @JsonProperty("editPermissions")
        private List<Object> editPermissions = null;
        @JsonProperty("name")
        private String name;
        @JsonProperty("description")
        private String description;
        @JsonProperty("sharePermissions")
        private List<SharePermission> sharePermissions = null;

        public Builder withEditPermissions(List<Object> permissionsList){
            this.editPermissions = permissionsList;
            return this;
        }

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Builder withSharePermissions(List<SharePermission> sharePermissionList){
            this.sharePermissions = sharePermissionList;
            return this;
        }

        public Dashboard build(){
            Dashboard dashboard = new Dashboard(this);
            return dashboard;
        }

    }

}
