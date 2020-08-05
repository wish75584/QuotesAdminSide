package com.stubborn.quotesadminside;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void InsertingQuotes(View view) {
        startActivity(new Intent(MainActivity.this,CreateQuoteCategory.class));
    }

    public void ViewingQuotes(View view) {
        startActivity(new Intent(MainActivity.this,QuotesListActivity.class));

    }

    public void successActivity(View view) {
        startActivity(new Intent(MainActivity.this,SuccessActivity.class));


    }
}
