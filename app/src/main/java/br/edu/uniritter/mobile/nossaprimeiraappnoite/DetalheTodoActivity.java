package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Todo;

public class DetalheTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_todo);
        Intent intent = getIntent();
        Parcelable prc = intent.getParcelableExtra("objTodo");
        if (prc instanceof Todo) {

        }
        if (prc instanceof Pessoa) {

        }
        Todo todo = intent.getParcelableExtra("objTodo");
        bind(todo);

    }
    public void trocaLayout(View v) {
        setContentView(R.layout.layout);
        Intent intent = getIntent();
        Todo todo = intent.getParcelableExtra("objTodo");
        bind(todo);

    }
    public void cbClick(View v) {
        CheckBox cb = findViewById(R.id.cbCompleted);
        Intent intent = getIntent();
        Todo todo = intent.getParcelableExtra("objTodo");
        todo.setCompleted(cb.isChecked());
    }
    private void bind(Todo obj) {
        TextView tv = findViewById(R.id.tvId);
        tv.setText(obj.getId()+"");
        tv = findViewById(R.id.tvIdUser);
        tv.setText(obj.getUserId()+"");
        tv = findViewById(R.id.tvTitle);
        tv.setText(obj.getTitle());
        CheckBox cb = findViewById(R.id.cbCompleted);
        cb.setChecked(obj.isCompleted());

    }
}