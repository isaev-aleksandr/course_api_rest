package ru.isaev.course.demo.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.isaev.course.demo.model.apiResponse.course.CourseResponse;

@FeignClient(url = "${courseApiUrl}", name = "COURSE-CLIENT")
public interface CourseClient {

    @GetMapping("/latest.json?app_id=" + "${appIdOpenexchangerates}" + "&base={currency}" + "&symbols={targetCurrency}")
    public CourseResponse getTodayCourse(@PathVariable String currency, @PathVariable String targetCurrency);

    @GetMapping("/historical/{yesterday}.json?app_id=" + "${appIdOpenexchangerates}" + "&base={currency}" + "&symbols={targetCurrency}")
    public CourseResponse getYesterdayCourse(@PathVariable String currency, @PathVariable String targetCurrency, @PathVariable String yesterday);
}
