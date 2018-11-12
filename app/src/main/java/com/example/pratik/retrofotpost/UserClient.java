package com.example.pratik.retrofotpost;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface UserClient {

    @POST("") //Enter Your End Point Here
    Call<User> createAccount(@Body User user, @HeaderMap Map<String, String> headers);
}
