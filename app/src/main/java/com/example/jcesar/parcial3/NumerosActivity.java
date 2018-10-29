package com.example.jcesar.parcial3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NumerosActivity extends AppCompatActivity {

    EditText edtNumero1, edtNumero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

        edtNumero1 = (EditText) findViewById(R.id.edtNumero1);
        edtNumero2 = (EditText) findViewById(R.id.edtNumero2);
    }

    public void operaciones(View v){
        Double numero1, numero2;

        if(edtNumero1.getText().toString().isEmpty()){
            Toast.makeText(this, "Debe ingresar un numero", Toast.LENGTH_LONG).show();
            edtNumero1.requestFocus();
        } else if(edtNumero2.getText().toString().isEmpty()){
            Toast.makeText(this, "Debe ingresar un numero", Toast.LENGTH_LONG).show();
            edtNumero2.requestFocus();
        } else {
            numero1 = Double.parseDouble( edtNumero1.getText().toString() );
            numero2 = Double.parseDouble( edtNumero2.getText().toString() );

            Intent intent = new Intent(this, OperacionActivity.class);
            intent.putExtra("numero1", numero1);
            intent.putExtra("numero2", numero2);
            startActivity(intent);

        }




    }
}
