package mobile.fasam.edu.Android_Java_Retrofit2.atividade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import mobile.fasam.edu.Android_Java_Retrofit2.R;
import mobile.fasam.edu.Android_Java_Retrofit2.adapter.CommentsAdapter;
import mobile.fasam.edu.Android_Java_Retrofit2.bootstrap.BootstrapApi;
import mobile.fasam.edu.Android_Java_Retrofit2.representacao.Comments;
import mobile.fasam.edu.Android_Java_Retrofit2.resource.CommentsService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends AppCompatActivity {
    EditText txtId;
    EditText txtCommentsId;
    EditText txtNome;
    EditText txtEmail;
    EditText txtBody;
    ListView listView;

    //criar referencia para consumir o serviço de CommentsService
    CommentsService CommentsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
    }

    private void carregarDados(){

        //Fazer injeção de dependencia da INTERFACE
        CommentsService = BootstrapApi.getClient().create(CommentsService.class);

        Call<List<Comments>> get = CommentsService.get();

        get.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                //Recuperar a lista de posts
                List<Comments> posts = response.body();

                //Pegar referencia da listtview
                listView = findViewById(R.id.listviewComments);

                //chamar o Adapter para trabalhar os dados
                CommentsAdapter adapter = new CommentsAdapter(getApplicationContext(),posts);

                //Fazer "bind" com a listview
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {

            }
        });

    }

    public void Adicionar(View view) {

            carregarDados();

    }
}
