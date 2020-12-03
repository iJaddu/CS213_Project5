package com.example.cs213_project5;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class TicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        // Get the Intent that started this activity and extract the museum name from it
        Intent intent = getIntent();
        String message = intent.getStringExtra("MUSEUM_ID");

        // Set the museum name as the title of second screen
        TextView textView = findViewById(R.id.MuseumName);
        textView.setText(message);

        ImageView museumName = (ImageView)findViewById(R.id.museumImage);

        if(message.equals("The Museum of Modern Art")){
            museumName.setImageResource(R.drawable.moma);
        }else if(message.equals("The Museum of Natural History")){
            museumName.setImageResource(R.drawable.natural_history);
        }else if(message.equals("The Metropolitan Museum of Art")){
            museumName.setImageResource(R.drawable.met);
        }else if(message.equals("The Brooklyn Museum")){
            museumName.setImageResource(R.drawable.brooklyn);
        }
    }


}