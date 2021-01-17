
package ru.isaev.course.demo.model.apiResponse.gif;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "meta"
})
public class GifResponse {

    @JsonProperty("data")
    private Data data;
    @JsonProperty("meta")
    private Meta meta;

}
