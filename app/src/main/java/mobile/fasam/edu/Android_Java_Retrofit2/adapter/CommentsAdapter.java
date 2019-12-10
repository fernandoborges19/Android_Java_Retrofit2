package mobile.fasam.edu.Android_Java_Retrofit2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mobile.fasam.edu.Android_Java_Retrofit2.R;
import mobile.fasam.edu.Android_Java_Retrofit2.representacao.Comments;

public class CommentsAdapter extends BaseAdapter {
    Context context;
    List<Comments> colecao;
    LayoutInflater inflter;

    public CommentsAdapter(final Context applicationContext,
                       final List<Comments> colecao) {
        this.context = applicationContext;
        this.colecao = colecao;

    }
    @Override
    public int getCount() {
        return this.colecao!=null ? this.colecao.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return this.colecao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        // inflate the layout for each list row
        //'Infla' o layout(pega a referencia) para ser trabalhada
        //no método
        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.item_comments,
                            viewGroup, false);
        }

        // pega o objeto corrente da lista
        Comments comments = (Comments) getItem(position);

        //Declarar campos para preencher o layout item
        TextView commentsID, id, nome;

        //Pegando referencia da campo no latout item
        commentsID = view.findViewById(R.id.txtCommentsId);
        nome = view.findViewById(R.id.txtNome);

        //Preencher item do layout como o objeto Commentss
        commentsID.setText(String.valueOf(comments.getId()));
        nome.setText(String.valueOf(comments.getName()));

        return view;
    }
}
