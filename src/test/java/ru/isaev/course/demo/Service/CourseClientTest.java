package ru.isaev.course.demo.Service;

import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.isaev.course.demo.model.apiResponse.course.CourseResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles({"test","wiremock"})
class CourseClientTest {

//    @Rule
//    public WireMockRule wireMockRule = new WireMockRule(8081);

//    @ClassRule
//    public static WireMockClassRule wiremock = new WireMockClassRule(WireMockConfiguration.options().dynamicPort());

    @ClassRule
    public static WireMockRule WIREMOCK = new WireMockRule(
            wireMockConfig().fileSource(new ClasspathFileSource("path/to/wiremock/snipptes")).dynamicPort());

    private String currency = "USD";

    private String targetCurrency = "RUB";

    @Autowired
    private CourseClient courseClient;

    //    "/latest.json?app_id=${course.appIdOpenexchangerates}&base=USD&symbols=RUB"
    @Test
    public void getTodayCourseTest (){
        WIREMOCK.stubFor(get(urlPathMatching(
//                "/latest.json?app_id=$81919272c65d455b8e43d27de5a87ebe&base=[A-Z]{3}&symbols=[A-Z]{3}")).
                "/latest.json?app_id=$81919272c65d455b8e43d27de5a87ebe&base=USD&symbols=RUB")).
                willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "  \"disclaimer\": \"Usage subject to terms: https://openexchangerates.org/terms\",\n" +
                                "  \"license\": \"https://openexchangerates.org/license\",\n" +
                                "  \"timestamp\": 1610913563,\n" +
                                "  \"base\": \"USD\",\n" +
                                "  \"rates\": {\n" +
                                "    \"RUB\": 73.502399\n" +
                                "  }\n" +
                                "}")));

        CourseResponse courseResponse = courseClient.getTodayCourse(currency, targetCurrency);

        assertEquals(courseResponse.getRates().getAdditionalInformation().get(targetCurrency), "73.502399");
    }


    @Profile("wiremock")
    @Configuration
    public static class TestConfiguration {

        @Bean
        public ServerList<Server> ribbonServerList() {
            return new StaticServerList<>(new Server("localhost", WIREMOCK.port()));
        }
    }
}