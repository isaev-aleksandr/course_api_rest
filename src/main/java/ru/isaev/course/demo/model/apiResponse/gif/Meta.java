
package ru.isaev.course.demo.model.apiResponse.gif;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "msg",
    "response_id"
})
public class Meta {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("response_id")
    private String responseId;

}
