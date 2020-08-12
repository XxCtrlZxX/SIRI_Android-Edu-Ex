package com.example.day6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Item> data = new ArrayList<>();
        data.add(addItem(getResources().getDrawable(R.drawable.baseline_account_circle_black_36dp), "item1", "desc1"));
        data.add(addItem(getResources().getDrawable(R.drawable.baseline_face_black_36dp), "item2", "desc2"));
        data.add(addItem(getResources().getDrawable(R.drawable.baseline_tag_faces_black_36dp), "item3", "desc3"));

        RecyclerView recyclerView = findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleTextAdapter simpleTextAdapter = new SimpleTextAdapter(data);
        recyclerView.setAdapter(simpleTextAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), new LinearLayoutManager(this).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public Item addItem(Drawable icon, String title, String desc)
    {
        Item item = new Item();
        item.setIconDrawable(icon);
        item.setTitleStr(title);
        item.setDescStr(desc);
        return item;
    }
}
