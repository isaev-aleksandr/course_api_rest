package ru.isaev.course.demo.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.isaev.course.demo.model.apiResponse.gif.GifResponse;

@FeignClient(url = "${gifApiUrl}", name = "GIF-CLIENT")
public interface GifClient {

    @GetMapping("/v1/stickers/random?api_key=" + "${appIdGif}" + "&tag={state}")
    public GifResponse getRandomGif(@PathVariable String state);

}
