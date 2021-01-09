package com.example.ezyfoodyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PesanActivity extends AppCompatActivity {

    TextView nametxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        nametxt = findViewById(R.id.nama_tempat);
        String title = getIntent().getStringExtra("title");
        nametxt.setText(title);
    }

    public void toDrink(View view) {
        Intent intent = new Intent(this, DrinkActivity.class);
        startActivity(intent);
    }

    public void toMyOrder(View view){
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }

    public void toTopup(View view) {
        Intent intent = new Intent(this, TopupActivity.class);
        startActivity(intent);
    }
}