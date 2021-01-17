
package ru.isaev.course.demo.model.apiResponse.course;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disclaimer",
    "license",
    "timestamp",
    "base",
    "rates"
})
public class CourseResponse {

    @JsonProperty("disclaimer")
    private String disclaimer;
    @JsonProperty("license")
    private String license;
    @JsonProperty("timestamp")
    private Integer timestamp;
    @JsonProperty("base")
    private String base;
    @JsonProperty("rates")
    private Rates rates;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
