
package ru.isaev.course.demo.model.apiResponse.gif;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "avatar_url",
    "banner_image",
    "banner_url",
    "profile_url",
    "username",
    "display_name",
    "description",
    "is_verified",
    "website_url",
    "instagram_url"
})
public class User {

    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("banner_image")
    private String bannerImage;
    @JsonProperty("banner_url")
    private String bannerUrl;
    @JsonProperty("profile_url")
    private String profileUrl;
    @JsonProperty("username")
    private String username;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("is_verified")
    private Boolean isVerified;
    @JsonProperty("website_url")
    private String websiteUrl;
    @JsonProperty("instagram_url")
    private String instagramUrl;

}
