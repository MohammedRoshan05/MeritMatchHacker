package com.example.meritmatch_hacker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    //User Endpoints
    @GET("/user/{User_name}")
    Call<ClassUserInfo> getUserInfo(@Path("User_name") String username);

    @POST("/user/login")
    Call<CallStatus> login(@Body ClassUserOperation user);

    @POST("/user/signup")
    Call<ClassUserInfo> signup(@Body ClassUserOperation user);

    //Task endpoints
    @GET("/tasks/begger/{PostedBy}")
    Call<List<ClassTaskDetails>> getPostedTasks(@Path("PostedBy") String PostedBy);
    @GET("/tasks/chooser/{Resolver}")
    Call<List<ClassTaskDetails>> getPendingTasks(@Path("Resolver") String Resolver);
}
