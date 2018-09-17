package com.example.root.tp1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter {

    Context managed;
    List<Category> list = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_category, viewGroup, false);
        CategoryViewHolder vh = new CategoryViewHolder(mView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int pos) {
        Category currentCategory = list.get(pos);
        if(viewHolder instanceof CategoryViewHolder && currentCategory != null) {
            CategoryViewHolder holder = (CategoryViewHolder)viewHolder;
            holder.layoutForCategory(currentCategory);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItems(List<Category> cats) {
        list = cats;
    }

    public void setManager(Context context) {
        managed = context;
    }
}
