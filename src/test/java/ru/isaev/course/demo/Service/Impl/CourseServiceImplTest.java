package ru.isaev.course.demo.Service.Impl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.isaev.course.demo.Service.CourseClient;
import ru.isaev.course.demo.Service.CourseService;
import ru.isaev.course.demo.Service.GifClient;
import ru.isaev.course.demo.model.apiResponse.course.CourseResponse;
import ru.isaev.course.demo.model.apiResponse.course.Rates;
import ru.isaev.course.demo.model.apiResponse.gif.Data;
import ru.isaev.course.demo.model.apiResponse.gif.GifResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseServiceImplTest {

    private String currency;

    private String currencyMore;

    private String targetCurrency;

    private String searchWordGifIfMore;

    private String searchWordGifIfLess;

    @Autowired
    private CourseService courseService;

    @MockBean
    private CourseClient courseClient;

    @MockBean
    private GifClient gifClient;

    @Mock
    private CourseResponse courseResponseLess;

    @Mock
    private CourseResponse courseResponseMore;

    @Mock
    private CourseResponse courseResponseYesterday;

    @Mock
    private GifResponse gifResponseLess;

    @Mock
    private GifResponse gifResponseMore;

    @BeforeEach
    public void setUp() throws Exception {
        currency = "USD";
        currencyMore = "AED";
        targetCurrency = "RUB";
        searchWordGifIfMore = "rich";
        searchWordGifIfLess = "broke";

        //TODO courseResponseLess Mock
        courseResponseLess = new CourseResponse();
        Rates ratesLess = new Rates();
        ratesLess.setAdditionalProperty(targetCurrency, 2.0);
        courseResponseLess.setRates(ratesLess);

        //TODO courseResponseMore Mock
        courseResponseMore = new CourseResponse();
        Rates ratesMore = new Rates();
        ratesMore.setAdditionalProperty(targetCurrency, 5.0);
        courseResponseMore.setRates(ratesMore);

        //TODO courseResponseYesterday Mock
        courseResponseYesterday = new CourseResponse();
        Rates ratesYesterday = new Rates();
        ratesYesterday.setAdditionalProperty(targetCurrency, 3.0);
        courseResponseYesterday.setRates(ratesYesterday);

        //TODO gifResponseLess Mock
        gifResponseLess = new GifResponse();
        Data dataLess = new Data();
        dataLess.setEmbedUrl("less.url");
        gifResponseLess.setData(dataLess);

        //TODO gifResponseMore Mock
        gifResponseMore = new GifResponse();
        Data dataMore = new Data();
        dataMore.setEmbedUrl("more.url");
        gifResponseMore.setData(dataMore);

        //TODO CourseClient .getTodayCourse() less
        Mockito.when(courseClient.getTodayCourse(currency, targetCurrency)).thenReturn(courseResponseLess);

        //TODO CourseClient .getTodayCourse() more
        Mockito.when(courseClient.getTodayCourse(currencyMore, targetCurrency)).thenReturn(courseResponseMore);

        //TODO CourseClient .getYesterdayCourse()
        Mockito.when(courseClient.getYesterdayCourse(currency, targetCurrency, "2021-01-10")).thenReturn(courseResponseYesterday);

        //TODO CourseClient .getYesterdayCourse() to more
        Mockito.when(courseClient.getYesterdayCourse(currencyMore, targetCurrency, "2021-01-10")).thenReturn(courseResponseYesterday);

        //TODO GifClient .getRandomGif() less
        Mockito.when(gifClient.getRandomGif(searchWordGifIfLess)).thenReturn(gifResponseLess);

        //TODO GifClient .getRandomGif() more
        Mockito.when(gifClient.getRandomGif(searchWordGifIfMore)).thenReturn(gifResponseMore);

    }

    @Test
    void testGetFinancialConditionLess() {
        String expected = courseService.getFinancialCondition(currency);
        String actual = "less.url";

        Assert.assertEquals(expected, actual);
    }

    @Test
    void testGetFinancialConditionMore() {
        String expected = courseService.getFinancialCondition(currencyMore);
        String actual = "more.url";

        Assert.assertEquals(expected, actual);
    }

    @Test
    void testGetApiCourseTodayLess() {
        Double expected = courseService.getApiCourseToday(currency);
        Double actual = 2.0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void testGetApiCourseTodayMore() {
        Double expected = courseService.getApiCourseToday(currencyMore);
        Double actual = 5.0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void testGetApiCourseYesterday() {
        Double expected = courseService.getApiCourseYesterday(currency);
        Double actual = 3.0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void testGetApiRandomGifLess() {
        String expected = courseService.getApiRandomGif(searchWordGifIfLess);
        String actual = "less.url";

        Assert.assertEquals(expected, actual);
    }

    @Test
    void testGetApiRandomGifMore() {
        String expected = courseService.getApiRandomGif(searchWordGifIfMore);
        String actual = "more.url";

        Assert.assertEquals(expected, actual);
    }
}