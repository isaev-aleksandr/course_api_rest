package ru.isaev.course.demo.model.apiResponse.course;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rates {

    private Map<String, Double> additionalInformation = new HashMap<>();

    @JsonAnySetter
    public void setAdditionalInformation(final String name, final Double value) {
        this.additionalInformation.put(name, value);
    }

}
