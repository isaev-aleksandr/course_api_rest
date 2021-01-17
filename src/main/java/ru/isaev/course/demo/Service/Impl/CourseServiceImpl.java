package ru.isaev.course.demo.Service.Impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.isaev.course.demo.Service.CourseClient;
import ru.isaev.course.demo.Service.GifClient;
import ru.isaev.course.demo.Service.CourseService;

import java.time.LocalDate;

@Data
@Service
public class CourseServiceImpl implements CourseService {

    @Value("${course.targetCurrency}")
    private String targetCurrency;

    @Value("${course.searchWordGifIfMore}")
    private String searchWordGifIfMore;

    @Value("${course.searchWordGifIfLess}")
    private String searchWordGifIfLess;

    private CourseClient courseClient;

    private GifClient gifClient;

    @Autowired
    public CourseServiceImpl(CourseClient courseClient, GifClient gifClient) {
        this.courseClient = courseClient;
        this.gifClient = gifClient;
    }

    @Override
    public String getFinancialCondition(String currency) {
            if (getApiCourseToday(currency) > getApiCourseYesterday(currency)) {
                return getApiRandomGif(searchWordGifIfMore);
            } else {
                return getApiRandomGif(searchWordGifIfLess);
            }
    }

    @Override
    public Double getApiCourseToday(String currency) {
        return courseClient.getTodayCourse(currency,
                targetCurrency).getRates().getAdditionalInformation().get(targetCurrency);
    }

    @Override
    public Double getApiCourseYesterday(String currency) {
        return courseClient.getYesterdayCourse(currency, targetCurrency,
                LocalDate.now().minusDays(1).toString())
                .getRates().getAdditionalInformation().get(targetCurrency);
    }

    @Override
    public String getApiRandomGif(String searchApiWordGifIfMore) {
        return gifClient.getRandomGif(searchApiWordGifIfMore).getData().getEmbedUrl();
    }

}
