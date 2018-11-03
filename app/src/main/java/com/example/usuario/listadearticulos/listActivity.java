package com.example.usuario.listadearticulos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class listActivity extends AppCompatActivity {

    ListView listview;
 // String [] products =new String[];
  LinkedList<String> ProductList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        for (int i = 0; i < 20; i++) {
            int j = i+1;
            ProductList.addLast("Artículo " + j);
        }
        listview = (ListView) findViewById(R.id.listaproductos);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, ProductList);
        listview.setAdapter(adapter);

    }
}
