package com.example.dadabhagwan.rectrofijsonpostandget;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by dadabhagwan on 12/8/2016.
 */

public interface JsonObjectAPI  {


  @GET("/posts")
  Call<List<User>> getUser();

  @GET("/posts")
  Call<List<User>> getSelectedUserData(@Query("userId") Long userId);

  @POST("/posts")
  Call<AddPostResponse> addPost(@Body AddPostRequest addPostRequest);

}
