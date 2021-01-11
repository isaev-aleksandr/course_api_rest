package ru.isaev.course.demo.Service;

import java.time.LocalDate;

public interface CourseService {

    public String getFinancialCondition(String currency);

    public Double getApiCourseToday (String currency);

    public Double getApiCourseYesterday(String currency);

    public String getApiRandomGif (String searchApiWordGifIfMore);
}
