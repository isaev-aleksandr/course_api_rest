
package ru.isaev.course.demo.model.apiResponse.gif;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mp4",
    "mp4_size"
})
public class Looping {

    @JsonProperty("mp4")
    private String mp4;
    @JsonProperty("mp4_size")
    private String mp4Size;

}
