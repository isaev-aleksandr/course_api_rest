package ru.isaev.course.demo.config;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Data
@Validated
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix="course")
class AppProperties {

    @NotBlank
    @NotEmpty
    @NotNull
    @Pattern(regexp = "[A-Z]{3}")
    @Length(min = 3, max = 3)
    private String targetCurrency;

    @NotBlank
    @NotEmpty
    @NotNull
    private String courseApiUrl;

    @NotBlank
    @NotEmpty
    @NotNull
    @Length(min = 32, max = 32)
    private String appIdOpenexchangerates;

    @NotBlank
    @NotEmpty
    @NotNull
    private String gifApiUrl;

    @NotBlank
    @NotEmpty
    @NotNull
    @Length(min = 32, max = 32)
    private String appIdGif;

    @NotBlank
    @NotEmpty
    @NotNull
    private String searchWordGifIfMore;

    @NotBlank
    @NotEmpty
    @NotNull
    private String searchWordGifIfLess;


}
