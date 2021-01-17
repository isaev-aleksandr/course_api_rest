
package ru.isaev.course.demo.model.apiResponse.gif;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "width",
    "height"
})
public class _480wStill {

    @JsonProperty("url")
    private String url;
    @JsonProperty("width")
    private String width;
    @JsonProperty("height")
    private String height;

}
