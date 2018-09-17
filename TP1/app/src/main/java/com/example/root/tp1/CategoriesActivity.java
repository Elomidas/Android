package com.example.root.tp1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends Activity {

    private RecyclerView mRecyclerView;
    private List<Category> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        initList();

        mRecyclerView = findViewById(R.id.main_recycler_view);
        CategoriesAdapter adapter = new CategoriesAdapter();
        //adapter.setManager(this);
        adapter.setItems(mList);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Category> getItems() {
        return mList;
    }

    private void initList() {
        mList = new ArrayList<>();

        mList.add(new Category("Humour"));
        mList.add(new Category("Action"));
        mList.add(new Category("Fantastique"));
        mList.add(new Category("Horreur"));
        mList.add(new Category("Western"));
        mList.add(new Category("Romance"));
        mList.add(new Category("Aventure"));
        mList.add(new Category("Animation"));
        mList.add(new Category("Dance"));
        mList.add(new Category("Dramatique"));
        mList.add(new Category("Espionnage"));
        mList.add(new Category("Pornographique"));
        mList.add(new Category("Guerre"));
        mList.add(new Category("Historique"));
        mList.add(new Category("Policier"));
        mList.add(new Category("Politique"));
        mList.add(new Category("Thriller"));
    }

    public void refreshData() {
        if(mRecyclerView != null && mRecyclerView .getAdapter() != null) {
            mRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
