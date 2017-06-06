package com.example.user.myrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Info> listArray=new ArrayList<>();
    private Adapter adapter;
    private List<String> natureTitles = new ArrayList<>();
    private List<String> natureSubtitles = new ArrayList<>();
    private List<String> natureDescription = new ArrayList<>();
    private List<Integer> natureImages = new ArrayList<>();
    private List<String> natureLocation = new ArrayList<>();
    private List<String> historyTitles = new ArrayList<>();
    private List<String> historySubtitles = new ArrayList<>();
    private List<String> historyDescription = new ArrayList<>();
    private List<Integer> historyImages = new ArrayList<>();
    private List<String> historyLocation = new ArrayList<>();
    private List<String> foodTitles = new ArrayList<>();
    private List<String> foodSubtitles = new ArrayList<>();
    private List<String> foodDescription = new ArrayList<>();
    private List<Integer> foodImages = new ArrayList<>();
    private List<String> foodLocation = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setTitle(getIntent().getStringExtra("key"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView=(RecyclerView)findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new Adapter(this, listArray);
        recyclerView.setAdapter(adapter);

        natureTitles.addAll(Arrays.asList(getResources().getStringArray(R.array.nature_titles)));
        natureSubtitles.addAll(Arrays.asList(getResources().getStringArray(R.array.nature_subtitles)));
        natureDescription.addAll(Arrays.asList(getResources().getStringArray(R.array.nature_description)));
        natureImages.add(R.drawable.luxembourg);
        natureImages.add(R.drawable.seine);
        natureImages.add(R.drawable.butteschaumont2);
        natureLocation.addAll(Arrays.asList(getResources().getStringArray(R.array.nature_locations)));

        historyTitles.addAll(Arrays.asList(getResources().getStringArray(R.array.history_titles)));
        historySubtitles.addAll(Arrays.asList(getResources().getStringArray(R.array.history_subtitles)));
        historyDescription.addAll(Arrays.asList(getResources().getStringArray(R.array.history_description)));
        historyImages.add(R.drawable.eiffel2);
        historyImages.add(R.drawable.adetriomphe);
        historyImages.add(R.drawable.louvre);
        historyLocation.addAll(Arrays.asList(getResources().getStringArray(R.array.history_locations)));

        foodTitles.addAll(Arrays.asList(getResources().getStringArray(R.array.food_titles)));
        foodSubtitles.addAll(Arrays.asList(getResources().getStringArray(R.array.food_subtitles)));
        foodDescription.addAll(Arrays.asList(getResources().getStringArray(R.array.food_description)));
        foodImages.add(R.drawable.danslenoir);
        foodImages.add(R.drawable.cafedeflore2);
        foodImages.add(R.drawable.belcanto);
        foodLocation.addAll(Arrays.asList(getResources().getStringArray(R.array.food_locations)));

        if (getIntent().getStringExtra("key").equals("Alam")){
            for (int i=0;i<natureTitles.size();i++){
                Info info=new Info(natureTitles.get(i),natureSubtitles.get(i),natureDescription.get(i),natureImages.get(i), natureLocation.get(i));
                adapter.refill(info);
            }
        }
        else if(getIntent().getStringExtra("key").equals("Sejarah")){
            for (int i=0;i<historyTitles.size();i++){
                Info info=new Info(historyTitles.get(i),historySubtitles.get(i),historyDescription.get(i),historyImages.get(i), historyLocation.get(i));
                adapter.refill(info);
            }
        }
        else {
            for (int i=0;i<foodTitles.size();i++){
                Info info=new Info(foodTitles.get(i),foodSubtitles.get(i),foodDescription.get(i),foodImages.get(i), foodLocation.get(i));
                adapter.refill(info);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
