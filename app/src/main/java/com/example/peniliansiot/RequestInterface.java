package com.example.peniliansiot;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("/siot.php")
    Call<JSONResponse> getJSON();
}
