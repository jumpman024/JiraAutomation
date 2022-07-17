
package pojo.dashboardWithBuilder;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "column",
    "row"
})

public class Position {

    @JsonProperty("column")
    private Integer column;
    @JsonProperty("row")
    private Integer row;

    public Position(Builder builder) {
        this.column = builder.column;
        this.row = builder.row;
    }

    @JsonProperty("column")
    public Integer getColumn() {
        return column;
    }

    @JsonProperty("column")
    public void setColumn(Integer column) {
        this.column = column;
    }

    @JsonProperty("row")
    public Integer getRow() {
        return row;
    }

    @JsonProperty("row")
    public void setRow(Integer row) {
        this.row = row;
    }

    public static class Builder {

        @JsonProperty("column")
        private Integer column;
        @JsonProperty("row")
        private Integer row;

        public Builder withColumn(Integer column){
            this.column = column;
            return this;
        }
        public Builder withRow(Integer row){
            this.row = row;
            return this;
        }

        public Position build(){
            Position position = new Position(this);
            return position;
        }
    }

}
