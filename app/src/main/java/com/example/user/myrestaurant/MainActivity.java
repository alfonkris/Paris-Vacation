package com.example.user.myrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alam(View view){
        Intent intent = new Intent(MainActivity.this,ListActivity.class);
        intent.putExtra("key","Alam");
        startActivity(intent);
    }
    public void sejarah(View view){
        Intent intent = new Intent(MainActivity.this,ListActivity.class);
        intent.putExtra("key","Sejarah");
        startActivity(intent);
    }
    public void kuliner(View view){
        Intent intent = new Intent(MainActivity.this,ListActivity.class);
        intent.putExtra("key","Kuliner");
        startActivity(intent);
    }

}
