package org.jlopez.tema6_caso1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mensaje;

    @Override
    protected void onCreate(Bundle in) {
        super.onCreate(in);
        setContentView(R.layout.activity_main);
        if(in == null){
            mensaje= "INI";
        }else{
           mensaje = in.getString("mensajeFuturo");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("mensajeFuturo",mensaje);

    }

    public void memorizar(View v){
        EditText texto = findViewById(R.id.edit);
        this.mensaje = texto.getTransitionName().toString();
        guardarPersistente(mensaje);

    }

    private void guardarPersistente(String mensaje) {
        SharedPreferences p = getSharedPreferences( "estado" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = p.edit();
        editor.putString("mensaje",mensaje);

        editor.commit();

    }

    public void mostrar(View v){
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();


    }
}
