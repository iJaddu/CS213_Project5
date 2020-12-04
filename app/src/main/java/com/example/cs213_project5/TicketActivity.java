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
        TextView adultAdmission = (TextView)findViewById(R.id.adultPrice);
        TextView seniorAdmission = (TextView)findViewById(R.id.seniorPrice);
        TextView studentAdmission = (TextView)findViewById(R.id.studentPrice);
        int adultCost = 0;
        int seniorCost = 0;
        int studentCost = 0;

        if(message.equals("The Museum of Modern Art")){
            museumName.setImageResource(R.drawable.moma);
            adultAdmission.setText("Adult $25");
            seniorAdmission.setText("Senior $18");
            studentAdmission.setText("Student $14");
            adultCost = 25;
            seniorCost = 18;
            studentCost = 14;
        }else if(message.equals("The Museum of Natural History")){
            museumName.setImageResource(R.drawable.natural_history);
            adultAdmission.setText("Adult $23");
            seniorAdmission.setText("Senior $18");
            studentAdmission.setText("Student $18");
            adultCost = 23;
            seniorCost = 18;
            studentCost = 18;
        }else if(message.equals("The Metropolitan Museum of Art")){
            museumName.setImageResource(R.drawable.met);
            adultAdmission.setText("Adult $25");
            seniorAdmission.setText("Senior $17");
            studentAdmission.setText("Student $12");
            adultCost = 25;
            seniorCost = 17;
            studentCost = 12;
        }else if(message.equals("The Brooklyn Museum")){
            museumName.setImageResource(R.drawable.brooklyn);
            adultAdmission.setText("Adult $16");
            seniorAdmission.setText("Senior $10");
            studentAdmission.setText("Student $10");
            adultCost = 16;
            seniorCost = 10;
            studentCost = 10;
        }
    }


}