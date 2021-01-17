
package ru.isaev.course.demo.model.apiResponse.gif;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hd",
    "downsized_large",
    "fixed_height_small_still",
    "original",
    "fixed_height_downsampled",
    "downsized_still",
    "fixed_height_still",
    "downsized_medium",
    "downsized",
    "preview_webp",
    "original_mp4",
    "fixed_height_small",
    "fixed_height",
    "downsized_small",
    "preview",
    "fixed_width_downsampled",
    "fixed_width_small_still",
    "fixed_width_small",
    "original_still",
    "fixed_width_still",
    "looping",
    "fixed_width",
    "preview_gif",
    "480w_still"
})
public class Images {

    @JsonProperty("hd")
    private Hd hd;
    @JsonProperty("downsized_large")
    private DownsizedLarge downsizedLarge;
    @JsonProperty("fixed_height_small_still")
    private FixedHeightSmallStill fixedHeightSmallStill;
    @JsonProperty("original")
    private Original original;
    @JsonProperty("fixed_height_downsampled")
    private FixedHeightDownsampled fixedHeightDownsampled;
    @JsonProperty("downsized_still")
    private DownsizedStill downsizedStill;
    @JsonProperty("fixed_height_still")
    private FixedHeightStill fixedHeightStill;
    @JsonProperty("downsized_medium")
    private DownsizedMedium downsizedMedium;
    @JsonProperty("downsized")
    private Downsized downsized;
    @JsonProperty("preview_webp")
    private PreviewWebp previewWebp;
    @JsonProperty("original_mp4")
    private OriginalMp4 originalMp4;
    @JsonProperty("fixed_height_small")
    private FixedHeightSmall fixedHeightSmall;
    @JsonProperty("fixed_height")
    private FixedHeight fixedHeight;
    @JsonProperty("downsized_small")
    private DownsizedSmall downsizedSmall;
    @JsonProperty("preview")
    private Preview preview;
    @JsonProperty("fixed_width_downsampled")
    private FixedWidthDownsampled fixedWidthDownsampled;
    @JsonProperty("fixed_width_small_still")
    private FixedWidthSmallStill fixedWidthSmallStill;
    @JsonProperty("fixed_width_small")
    private FixedWidthSmall fixedWidthSmall;
    @JsonProperty("original_still")
    private OriginalStill originalStill;
    @JsonProperty("fixed_width_still")
    private FixedWidthStill fixedWidthStill;
    @JsonProperty("looping")
    private Looping looping;
    @JsonProperty("fixed_width")
    private FixedWidth fixedWidth;
    @JsonProperty("preview_gif")
    private PreviewGif previewGif;
    @JsonProperty("480w_still")
    private ru.isaev.course.demo.model.apiResponse.gif._480wStill _480wStill;

}
