package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class Company {
    @JsonProperty("name")
    public String name;

    @JsonProperty("catchPhrase")
    public String catchPhrase;

    @JsonProperty("bs")
    public String bs;
}
