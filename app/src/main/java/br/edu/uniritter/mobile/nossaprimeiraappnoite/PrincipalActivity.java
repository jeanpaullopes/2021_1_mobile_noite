package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Address;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.Geo;
import br.edu.uniritter.mobile.nossaprimeiraappnoite.model.User;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Button joao = (Button) findViewById(R.id.button2);


        User user = new User(1,"jean","jean.paul@uniritter.edu.br",null);
        Geo geo = new Geo(-29.2323f,-50.9097f);
        Address add = new Address("Rua do cardeal dom eustáquio", "394", "Gravatai","9999999",geo);
        user.address = add;
        //btn.setOnClickListener(this::abreSegundaActivity);

        joao.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Intent intent = new Intent(v.getContext(),SegundaActivity.class);
                //startActivity(intent);
                abreSegundaActivity(v);

            }

        });
    }

    public void abreSegundaActivity(View view) {
        Intent intent = new Intent(this,SegundaActivity.class);

        // adicional para incluir dados para a proxima activity
        intent.putExtra("valorTexto", "Nossa 4ª aula");
        Pessoa jean  = new Pessoa("Jean Paul", 666);
        intent.putExtra("objPessoa", jean);

        EditText editNome = (EditText)findViewById(R.id.editTextTextPersonName);
        intent.putExtra("nome",editNome.getText().toString());

        // lança intent para o SO chamar a activity
        startActivity(intent);

    }
}