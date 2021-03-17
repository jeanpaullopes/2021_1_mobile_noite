package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

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
        Toast.makeText(this,"olá "+txt,Toast.LENGTH_LONG).show();

    }
}