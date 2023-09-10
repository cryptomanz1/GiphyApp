import com.example.giphyapp.data.DataResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApiClient {
    @GET("gifs/search")
    suspend fun randomGifs(
        @Query("api_key") apiKey: String,
        @Query("q") q: String = "cat"
    ): Response<DataResponse?>
}
