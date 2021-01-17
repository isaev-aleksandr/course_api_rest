package ru.isaev.course.demo.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.isaev.course.demo.model.apiResponse.gif.GifResponse;

@FeignClient(url = "${course.gifApiUrl}", name = "GIF-CLIENT")
public interface GifClient {

    @RequestMapping(method= RequestMethod.GET, path = "/v1/stickers/random?api_key=${course.appIdGif}")
    public GifResponse getRandomGif(@RequestParam(value = "tag") String state);

}
