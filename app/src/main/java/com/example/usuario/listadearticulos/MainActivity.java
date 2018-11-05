package com.example.usuario.listadearticulos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**

 * Esta clase muestra y define objetos seleccionados por el usuario

 */
public class MainActivity extends AppCompatActivity {

    /**
     * Método que muestra la pantalla principal de la aplicacion
     */
        TextView product;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            product = (TextView) findViewById(R.id.replyprod);

            if (savedInstanceState != null) {
                boolean isVisible = savedInstanceState.getBoolean("list_visible");
                if (isVisible) {

                    product.setVisibility(View.VISIBLE);
                    product.setText(savedInstanceState.getString("list_text"));
                    product.setVisibility(View.VISIBLE);
                }
            }
        }
    //Cierre del método

    /**
     * Método que muestra los articulos seleccionados
     */

    public void listView(View view){
        Intent intent = new Intent(this, listActivity.class);
        startActivity(intent);


    }
    //Cierre del método

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Si el encabezado es visible, tenemos un mensaje que necesita ser
        // guardado.
        // De otra manera, seguiremos usando el default layout.
        if (product.getVisibility() == View.VISIBLE) {
            outState.putBoolean("list_visible", true);
            outState.putString("list_text",
                    product.getText().toString());
        }
    }
}
//Cierre de la clase
