package mobile.fasam.edu.Android_Java_Retrofit2.resource;

import java.util.List;

import mobile.fasam.edu.Android_Java_Retrofit2.representacao.Comments;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

    public interface CommentsService {
        //Envia um comments para o servidor;
        @POST("comments")
        Call<Comments> post(@Body Comments comments);

        //Recupera um comments baseado no ID;
        @GET("comments/{id}")
        Call<Comments> get(@Path("id") Integer id);

        //Trás a lista do comments;
        @GET("comments")
        Call<List<Comments>> get();

        //atualiza o objeto comments inteiramente
        @PUT("comments/{id}")
        Call<Comments> put(@Path("id") Integer id, @Body Comments comments);

        // atualiza parcialmente o comments
        @PATCH("comments/{id}")
        Call<Comments> patch(@Path("id") Integer id, @Body Comments comments);

        //apaga um comments baseado em ID
        @DELETE("comments")
        Call<Void> delete(@Path("id") Integer id);
}
