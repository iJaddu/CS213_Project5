package com.example.cs213_project5;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
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
        String museum = "MOMA";
        intent.putExtra("MUSEUM_ID", museum);
        startActivity(intent);
    }

    public void NaturalHistoryOnClick(View view){
        Intent intent = new Intent(this, TicketActivity.class);
        String museum = "NH";
        startActivity(intent);

    }

    public void TheMetOnClick(View view){
        Intent intent = new Intent(this, TicketActivity.class);
        String museum = "MET";
        startActivity(intent);

    }

    public void BrooklynOnClick(View view){
        Intent intent = new Intent(this, TicketActivity.class);
        String museum = "BROOK";
        startActivity(intent);

    }
}