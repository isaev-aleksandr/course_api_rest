
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
    "size",
    "url",
    "webp",
    "webp_size",
    "width"
})
public class FixedWidthSmall {

    @JsonProperty("height")
    private String height;
    @JsonProperty("mp4")
    private String mp4;
    @JsonProperty("mp4_size")
    private String mp4Size;
    @JsonProperty("size")
    private String size;
    @JsonProperty("url")
    private String url;
    @JsonProperty("webp")
    private String webp;
    @JsonProperty("webp_size")
    private String webpSize;
    @JsonProperty("width")
    private String width;

}
