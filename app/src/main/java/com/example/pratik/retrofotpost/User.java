package com.example.pratik.retrofotpost;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public User(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Integer getV() {
        return v;
    }
}
