package com.example.usuario.listadearticulos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.LinkedList;

/**

 * Esta clase define objetos que maneja la aplicacion, los articulos que trae la misma.

 */
public class listActivity extends AppCompatActivity {

    //Campos de la clase
    ListView listview;
    ArrayList<String> selectedItems;
    LinkedList<String> ProductList = new LinkedList<>();
    private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        selectedItems=new ArrayList<String>();
    }
    //Cierre del método

    public void onStart(){
        super.onStart();
        for (int i = 0; i < 20; i++) {
            int j = i+1;
            ProductList.addLast("Artículo " + j);

        }
        listview = (ListView) findViewById(R.id.listaproductos);
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, ProductList);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            /**
             * Método que agrega los articulos a seleccionar
             */
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // selected item
                String selectedItem = ((TextView) view).getText().toString();
                if(selectedItems.contains(selectedItem))
                    selectedItems.remove(selectedItem); //remove deselected item from the list of selected items
                else
                    selectedItems.add(selectedItem); //add selected item to the list of selected items

            }
            //Cierre del método

        });
    }

     /**
     * Método que muestra los articulos seleccionados
     */
    public void showSelectedItems(View view){
        String selItems="";
        for(String item:selectedItems){
            if(selItems=="")
                selItems=item;
            else
                selItems+="/"+item;
        }
        Toast.makeText(this, selItems, Toast.LENGTH_LONG).show();
    }
    //Cierre del método

}
//Cierre de la clase
