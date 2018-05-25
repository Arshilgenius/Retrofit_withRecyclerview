package net.accedegh.retrofitlibrary;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by frank on 12/16/16.
 */

public class Client {

    // Trailing slash is needed
    public static final String BASE_URL = "https://api.github.com/";
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //GitHubService service = retrofit.create(GitHubService.class);
}
