package com.example.jcesar.parcial3;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class OperacionActivity extends AppCompatActivity {

    TextView tvNumero1, tvNumero2;

    RadioButton rdSumar, rdRestar, rdMultiplicar, rdDividir;

    Double numero1, numero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion);

        tvNumero1 = (TextView) findViewById(R.id.tvNumero1);
        tvNumero2 = (TextView) findViewById(R.id.tvNumero2);

        rdSumar = (RadioButton) findViewById(R.id.rdSumar);
        rdRestar = (RadioButton) findViewById(R.id.rdRestar);
        rdMultiplicar = (RadioButton) findViewById(R.id.rdMultiplicar);
        rdDividir = (RadioButton) findViewById(R.id.rdDividir);

        Bundle bundle = getIntent().getExtras();
        numero1 =  bundle.getDouble("numero1");
        numero2 = bundle.getDouble("numero2");

        tvNumero1.setText( "Numero 1: "  + numero1.toString() );
        tvNumero2.setText( "Numero 2: "  + numero2.toString() );

    }

    public void procesar(View v){
        String operacionSelecionada ="";
        Double resultado = 0.0;

        if(rdSumar.isChecked()){
            operacionSelecionada ="Suma";
            resultado = numero1 + numero2;

        } else if(rdRestar.isChecked()){
            operacionSelecionada ="Resta";
            resultado = numero1 - numero2;

        } else if(rdMultiplicar.isChecked()){
            operacionSelecionada ="Multiplicacion";
            resultado =  numero1 * numero2 ;

        } else if(rdDividir.isChecked()){
            operacionSelecionada ="Division";
            resultado = numero1 / numero2;

        } else {
            Toast.makeText(this, "Debe seleccionar una operacion", Toast.LENGTH_LONG).show();

        }


        if(!operacionSelecionada.equals("")){
            Intent resultIntent = new Intent();

            resultIntent.putExtra("operacion", operacionSelecionada);
            resultIntent.putExtra("resultado", resultado.toString());

            setResult(RESULT_OK, resultIntent);
            finish();
        }

    }


}
