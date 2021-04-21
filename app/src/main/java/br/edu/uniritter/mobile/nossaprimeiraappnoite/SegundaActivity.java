package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.adapter.TodoAdapter;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Address;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Todo;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.User;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.presenter.SegundaActivityContrato;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.presenter.SegundaActivityPresenter;

public class SegundaActivity extends AppCompatActivity
        implements SegundaActivityContrato.SegundaActivityView {
    private SegundaActivityContrato.SegundaActivityInterfacePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        TextView tv = (TextView) findViewById(R.id.textoSegunda);
        Intent it = getIntent();
        String txt = it.getStringExtra("nome");
        Pessoa pes = it.getParcelableExtra("objPessoa");
        //tv.setText(pes.getNome()+" ("+pes.getId()+")");
        tv.setText(txt);
        this.presenter =  new SegundaActivityPresenter(this);
        //Toast.makeText(this,"olá "+txt,Toast.LENGTH_LONG).show();

        Log.d("SegundaActivity", "fim");

        SwipeRefreshLayout str = findViewById(R.id.SwipeSegAct);
        str.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                str.setRefreshing(true);
                Log.d("SegundaActivity", "vou dar o start()");
                presenter.start();
            }
        });

    }

    @Override
    public void bindLista(List<Parcelable> lista) {
        RecyclerView rv = findViewById(R.id.rvTodos);
        RecyclerView rv2 = findViewById(R.id.rvTodos2);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        LinearLayoutManager llhm = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager llhm2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        GridLayoutManager glm = new GridLayoutManager(this,3);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        rv2.setLayoutManager(llhm);

        TodoAdapter todoAdapter = new TodoAdapter(lista,0);
        TodoAdapter todoAdapter2 = new TodoAdapter(lista.subList(3,7), R.layout.layout);
        rv.setAdapter(todoAdapter);
        rv2.setAdapter(todoAdapter2);


    }

    @Override
    public void bindListaAdd(List<Address> list) {

    }

    @Override
    public void bindListaUser(List<User> lista) {

    }

    @Override
    public void mostraToast(String msg) {
        Toast.makeText(this.getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void stopRefreshing() {
        SwipeRefreshLayout str = findViewById(R.id.SwipeSegAct);
        str.setRefreshing(false);
    }

    // aqui vai atender o onclick definido no layout
    public void cardClick(View v) {
        CardView btn = (CardView) v;
        Todo todo = (Todo) btn.getTag();
        Intent intent = new Intent(v.getContext(), DetalheTodoActivity.class);

        // adicional para incluir dados para a proxima activity
        intent.putExtra("objTodo", todo);
        // lança intent para o SO chamar a activity
        v.getContext().startActivity(intent);
    }



    @Override
    public Context getContexto() {
        return this.getApplicationContext();
    }
}