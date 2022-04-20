package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class Geo {
    @JsonProperty("lat")
    public String lat;

    @JsonProperty("lng")
    public String lng;
}
