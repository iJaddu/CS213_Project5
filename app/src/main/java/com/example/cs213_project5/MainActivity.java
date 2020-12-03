package com.example.cs213_project5;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MoMAOnClick(View view){
        Intent intent = new Intent(this, TicketActivity.class);
        String museum = "The Museum of Modern Art";
        intent.putExtra("MUSEUM_ID", museum);
        startActivity(intent);
    }

    public void NaturalHistoryOnClick(View view){
        Intent intent = new Intent(this, TicketActivity.class);
        String museum = "The Museum of Natural History";
        intent.putExtra("MUSEUM_ID", museum);
        startActivity(intent);

    }

    public void TheMetOnClick(View view){
        Intent intent = new Intent(this, TicketActivity.class);
        String museum = "The Metropolitan Museum of Art";
        intent.putExtra("MUSEUM_ID", museum);
        startActivity(intent);

    }

    public void BrooklynOnClick(View view){
        Intent intent = new Intent(this, TicketActivity.class);
        String museum = "The Brooklyn Museum";
        intent.putExtra("MUSEUM_ID", museum);
        startActivity(intent);

    }
}