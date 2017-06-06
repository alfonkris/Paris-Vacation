package com.example.user.myrestaurant;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView imageDetail, imageLocation;
    TextView textTitle, textDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageDetail=(ImageView)findViewById(R.id.img_detail);
        imageLocation=(ImageView)findViewById(R.id.img_location);
        textTitle=(TextView)findViewById(R.id.tx_title);
        textDetail=(TextView)findViewById(R.id.tx_detail);

        imageDetail.setImageResource(getIntent().getIntExtra("image",0));
        textTitle.setText(getIntent().getStringExtra("title"));
        textDetail.setText(getIntent().getStringExtra("description"));

        imageLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+getIntent().getStringExtra("location")+"("+getIntent().getStringExtra("title")+")"));
                startActivity(intent);
            }
        });
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
