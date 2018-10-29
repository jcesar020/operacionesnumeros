package com.example.jcesar.parcial3;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NumerosActivity extends AppCompatActivity {
    int request_code = 1;

    EditText edtNumero1, edtNumero2;
    TextView tvOperacion, tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

        edtNumero1 = (EditText) findViewById(R.id.edtNumero1);
        edtNumero2 = (EditText) findViewById(R.id.edtNumero2);

        tvOperacion = (TextView) findViewById(R.id.tvOperacion);
        tvResultado = (TextView) findViewById(R.id.tvResultado);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == request_code && resultCode== RESULT_OK){

            String operacion = data.getStringExtra("operacion");
            String resultado= data.getStringExtra("resultado");

            tvOperacion.setText( "Operacion: "  + operacion );
            tvResultado.setText( "Resultado: " + resultado );
        }
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
            startActivityForResult(intent, request_code);

        }

    }
}
