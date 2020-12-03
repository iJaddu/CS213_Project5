package com.example.cs213_project5;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class TicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra("MUSEUM_ID");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.MuseumName);
        if(message.equals("MOMA")){
            textView.setText("The Museum of Modern Art");
        }

    }


}