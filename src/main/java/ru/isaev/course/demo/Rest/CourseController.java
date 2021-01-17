package ru.isaev.course.demo.Rest;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.isaev.course.demo.Rest.exceptions.ThereIsIncorrectCurrency;
import ru.isaev.course.demo.Service.CourseService;

@Controller
public class CourseController {

    private CourseService courseServiceImpl;

    @Autowired
    public CourseController(CourseService courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    @GetMapping("/course/{currency}")
    public String getState(@PathVariable String currency){
//        try {
                return "redirect:" + courseServiceImpl.getFinancialCondition(currency);
//        } catch (FeignException e){
//            throw new ThereIsIncorrectCurrency();
//        }
    }


}
