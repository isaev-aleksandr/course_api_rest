
package ru.isaev.course.demo.model.apiResponse.gif;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "height",
    "mp4",
    "mp4_size",
    "width"
})
public class Hd {

    @JsonProperty("height")
    private String height;
    @JsonProperty("mp4")
    private String mp4;
    @JsonProperty("mp4_size")
    private String mp4Size;
    @JsonProperty("width")
    private String width;

}
