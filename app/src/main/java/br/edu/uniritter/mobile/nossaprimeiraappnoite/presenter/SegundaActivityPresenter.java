package br.edu.uniritter.mobile.nossaprimeiraappnoite.presenter;

import android.os.Parcelable;
import android.util.Log;
import android.view.View;
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

import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Todo;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.service.TodoService;

public class SegundaActivityPresenter implements Response.Listener<JSONArray>,
        Response.ErrorListener, SegundaActivityContrato.SegundaActivityInterfacePresenter {

    private List<Parcelable> lista;
    private SegundaActivityContrato.SegundaActivityView view;

    public SegundaActivityPresenter(SegundaActivityContrato.SegundaActivityView view) {
        this.view = view;
        this.lista = TodoService.getTodos();
        start();
    }
    @Override
    public void start() {


        // Volley
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(view.getContexto());
        String url = "https://jsonplaceholder.typicode.com/todos";

        // Request de JsonArray da URL.

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                this, this);


        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequest);
    }

    @Override
    public void encerrar() {

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        view.mostraToast("deu erro: "+msg);

    }

    @Override
    public void onResponse(JSONArray response) {
        this.lista = new ArrayList<>();
        try {

            for(int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                Todo obj = new Todo(json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getBoolean("completed"));

                lista.add(obj);

            }
            view.bindLista(lista);

        } catch (JSONException e) {
            Log.e("erro",e.getMessage());
            e.printStackTrace();
        }
    }
}
