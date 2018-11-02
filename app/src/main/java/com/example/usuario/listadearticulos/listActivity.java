package com.example.usuario.listadearticulos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class listActivity extends AppCompatActivity {
    private final LinkedList<String> ProductList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private ProductListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        for (int i = 0; i < 20; i++) {
            int j = i+1;
            ProductList.addLast("Artículo " + j);
        }

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new ProductListAdapter(this, ProductList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
