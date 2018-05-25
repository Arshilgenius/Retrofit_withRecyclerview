package net.accedegh.retrofitlibrary;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by frank on 12/16/16.
 */

public interface Service {
    @GET("users/arshilgenius/repos")
    Call<List<Movie>> getMovies();
    //Call<List<Movie> listRepos(@Path("user") String user);
}


