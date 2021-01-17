package ru.isaev.course.demo.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.isaev.course.demo.model.apiResponse.course.CourseResponse;

@FeignClient(url = "${course.courseApiUrl}", name = "COURSE-CLIENT")
public interface CourseClient {

    @RequestMapping(method= RequestMethod.GET, path = "/latest.json?app_id=${course.appIdOpenexchangerates}")
    public CourseResponse getTodayCourse(@RequestParam(value = "base") String currency,
                                         @RequestParam(value = "symbols") String targetCurrency);

    @RequestMapping(method= RequestMethod.GET, path = "/historical/{yesterday}.json?app_id=${course.appIdOpenexchangerates}")
    public CourseResponse getYesterdayCourse(@RequestParam(value = "base") String currency,
                                             @RequestParam(value = "symbols") String targetCurrency,
                                             @PathVariable String yesterday);
}
