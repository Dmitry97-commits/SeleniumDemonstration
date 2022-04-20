package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataModel {

    @JsonProperty("userId")
    private Integer UserId ;

    @JsonProperty("id")
    private Integer Id;

    @JsonProperty("title")
    private String Title;

    @JsonProperty("body")
    private String Body;

    public Integer getUserId(){
        return UserId;
    }

    public void setUserId(Integer userid){
        this.UserId = userid;
    }

    public Integer getId(){
        return Id;
    }

    public void setId(Integer id){
        this.Id = id;
    }

    public String getTitle(){
        return Title;
    }

    public void setTitle(String title){
        this.Title = title;
    }

    public String getBody(){
        return Body;
    }

    public void setBody(String body){
        this.Body = body;
    }

}
