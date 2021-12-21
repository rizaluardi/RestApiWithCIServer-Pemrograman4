package com.rizaluardi.ppsdt1184102.rest;

import com.rizaluardi.ppsdt1184102.model.GetRuangan;
import com.rizaluardi.ppsdt1184102.model.PostPutDelRuangan;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterfaceRuangan {
    @GET("ruangan_android")
    Call<GetRuangan> getRuangan();

    @FormUrlEncoded
    @POST("ruangan")
    Call<PostPutDelRuangan> postRuangan(@Field("ruangan") String ruangan,
                                        @Field("nomor") String nomor);

    @FormUrlEncoded
    @PUT("ruangan")
    Call<PostPutDelRuangan> putRuangan(@Field("id_ruangan") String id_ruangan,
                                       @Field("ruangan") String ruangan,
                                       @Field("nomor") String nomor);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "ruangan", hasBody = true)
    @DELETE("ruangan")
    Call<PostPutDelRuangan> deleteRuangan(@Field("id_ruangan") String id_ruangan);
}