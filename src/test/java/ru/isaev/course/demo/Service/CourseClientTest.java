//package ru.isaev.course.demo.Service;
//
//import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
//import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
//import com.netflix.loadbalancer.Server;
//import com.netflix.loadbalancer.ServerList;
//import org.junit.ClassRule;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.cloud.netflix.ribbon.StaticServerList;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import ru.isaev.course.demo.model.apiResponse.course.CourseResponse;
//
//import static com.github.tomakehurst.wiremock.client.WireMock.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@RunWith (SpringRunner.class)
//@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@ContextConfiguration(classes = {CourseClientTest.LocalRibbonClientConfiguration.class})
//public class CourseClientTest {
//
//    @Autowired
//    public CourseClient courseClient;
//
//    @ClassRule
//    public static WireMockClassRule wiremock = new WireMockClassRule(WireMockConfiguration.options().dynamicPort());
//
//    @Test
//    public void getTodayCourseTest() {
//
//        wiremock.stubFor(get(urlEqualTo("/latest.json?app_id=81919272c65d455b8e43d27de5a87ebe&base=USD&symbols=RUB"))
//
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withHeader("Content-Type", "application/json")
//                        .withBody("{\n" +
//                                "  \"disclaimer\": \"Usage subject to terms: https://openexchangerates.org/terms\",\n" +
//                                "  \"license\": \"https://openexchangerates.org/license\",\n" +
//                                "  \"timestamp\": 1610992794,\n" +
//                                "  \"base\": \"USD\",\n" +
//                                "  \"rates\": {\n" +
//                                "    \"RUB\": 73.9667\n" +
//                                "  }\n" +
//                                "}")));
//
//
//        CourseResponse courseResponse = courseClient.getTodayCourse("USD", "RUB");
//
//        assertEquals(courseResponse.getRates().getAdditionalInformation().get("RUB"), "73.9667");
//    }
//
//    @TestConfiguration
//    public static class LocalRibbonClientConfiguration {
//
//
//        @Bean
//        public ServerList<Server> ribbonServerList() {
//            wiremock.start();
//            return new StaticServerList<>(new Server("localhost", wiremock.port()));
//        }
//    }
//}