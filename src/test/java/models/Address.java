package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("street")
    public String street;

    @JsonProperty("suite")
    public String suite;

    @JsonProperty("city")
    public String city;

    @JsonProperty("zipcode")
    public String zipcode;

    @JsonProperty("geo")
    public Geo geo;
}
