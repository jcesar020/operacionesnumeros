package com.example.jcesar.parcial3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsuario, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
    }

    public void ingresar(View v){
        String usuario = edtUsuario.getText().toString();
        String password = edtPassword.getText().toString();

        if (usuario.isEmpty()){
            Toast.makeText(this, "Debe ingresar un nombre usuario", Toast.LENGTH_LONG).show();
        }else if (password.isEmpty()){
            Toast.makeText(this, "Debe ingresar una contraseña", Toast.LENGTH_LONG).show();
        }else if( usuario.equals("ELE1") && password.equals("SECC01")){
            //Toast.makeText(this, "Accesso correcto", Toast.LENGTH_LONG).show();
            Intent intent = new Intent( this, NumerosActivity.class);
            startActivity(intent);


        }else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show();
        }


    }
}
