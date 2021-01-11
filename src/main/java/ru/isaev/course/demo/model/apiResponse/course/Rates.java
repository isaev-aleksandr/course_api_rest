
package ru.isaev.course.demo.model.apiResponse.course;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rates {

    private Map<String, Double> additionalInformation = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Double> getAdditionalInformation() {
        return additionalInformation;
    }
    public void setAdditionalInformation(Map<String, Double> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
    @JsonAnySetter
    public void setAdditionalProperty(final String name, final Double value) {
        this.additionalInformation.put(name, value);
    }

}
