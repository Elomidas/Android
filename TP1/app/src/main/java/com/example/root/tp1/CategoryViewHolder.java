package com.example.root.tp1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private TextView mName;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.m_category_name);
    }

    public void layoutForCategory(Category category) {
        if(category != null) {
            mName.setText(category.getName());
        }
    }
}
