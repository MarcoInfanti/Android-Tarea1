package com.example.usuario.listadearticulos;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class ProductListAdapter  extends
        RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>{

    private final LinkedList<String> mProductList;
    private LayoutInflater mInflater;

    public ProductListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mProductList = wordList;
    }


    @NonNull

    @Override
    public ProductListAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.productlist_item, parent, false);
        return new ProductViewHolder(mItemView, this);

    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        String mCurrent = mProductList.get(position);
        holder.productItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }





    class ProductViewHolder extends RecyclerView.ViewHolder {

        public final TextView productItemView;
        final ProductListAdapter mAdapter;


        public ProductViewHolder(View itemView, ProductListAdapter adapter) {
            super(itemView);
            productItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
        }


    }




}



