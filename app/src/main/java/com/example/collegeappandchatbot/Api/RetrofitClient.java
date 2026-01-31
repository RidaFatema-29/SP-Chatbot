package com.example.collegeappandchatbot.Api;

        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String BASE_URL = "https://projects.ayaminteractive.com/collage_app_chat_bot/";
    private static RetrofitClient mInstance;
    private static Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if (mInstance == null ){
            mInstance = new RetrofitClient();
        }
        return mInstance;

    }

    public static Retrofit getClient() {
        return null;
    }

    public ApiService getApi(){
        return retrofit.create(ApiService.class);
    }

}







