package com.example.usuario.listadearticulos;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;


public class ProductListAdapter  extends BaseAdapter {

    Context contexto;
    private final LinkedList<String> mProductList;
    private LayoutInflater mInflater;
    ArrayList<String> selectedItems;


    public ProductListAdapter(Context conexto,LinkedList<String> mProductList )
    {
        this.contexto = conexto;
        this.mProductList = mProductList;
        mInflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final View vista = mInflater.inflate(R.layout.productlist_item, null);

        TextView productName = (TextView) vista.findViewById(R.id.listaproductos);
        ImageView imagen = (ImageView) vista.findViewById(R.id.ivImagen);

        productName.setText(mProductList.get(i));
        productName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String selectedItem = ((TextView) v).getText().toString();
                if(selectedItems.contains(selectedItem))
                    selectedItems.remove(selectedItem); //remove deselected item from the list of selected items

                else
                    selectedItems.add(selectedItem); //add selected item to the list of selected items


            }



        });
/*
        productName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/


        return vista;

    }


}



