package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class UsersModel {

    @JsonProperty("id")
    public Integer id ;

    @JsonProperty("name")
    public String name ;

    @JsonProperty("username")
    public String username ;

    @JsonProperty("email")
    public String email ;

    @JsonProperty("address")
    public Address address ;

    @JsonProperty("phone")
    public String phone;

    @JsonProperty("website")
    public String website ;

    @JsonProperty("company")
    public Company company;


}


