package com.example.cs213_project5;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class TicketActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    double total =0.0;
    int adultCost = 0;
    int seniorCost = 0;
    int studentCost = 0;
    int numberTickets=0;



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

        ImageView museumName = (ImageView) findViewById(R.id.museumImage);
        TextView adultAdmission = (TextView) findViewById(R.id.adultPrice);
        TextView seniorAdmission = (TextView) findViewById(R.id.seniorPrice);
        TextView studentAdmission = (TextView) findViewById(R.id.studentPrice);

        Spinner adultTickets = (Spinner)findViewById(R.id.adultTickets);
        Spinner seniorTickets = (Spinner)findViewById(R.id.seniorTickets);
        Spinner studentTickets = (Spinner)findViewById(R.id.studentTickets);


        if (message.equals("The Museum of Modern Art")) {
            museumName.setImageResource(R.drawable.moma);
            adultAdmission.setText("Adult $25");
            seniorAdmission.setText("Senior $18");
            studentAdmission.setText("Student $14");
            adultCost = 25;
            seniorCost = 18;
            studentCost = 14;




        } else if (message.equals("The Museum of Natural History")) {
            museumName.setImageResource(R.drawable.natural_history);
            adultAdmission.setText("Adult $23");
            seniorAdmission.setText("Senior $18");
            studentAdmission.setText("Student $18");
            adultCost = 23;
            seniorCost = 18;
            studentCost = 18;



        } else if (message.equals("The Metropolitan Museum of Art")) {
            museumName.setImageResource(R.drawable.met);
            adultAdmission.setText("Adult $25");
            seniorAdmission.setText("Senior $17");
            studentAdmission.setText("Student $12");
            adultCost = 25;
            seniorCost = 17;
            studentCost = 12;




        } else if (message.equals("The Brooklyn Museum")) {
            museumName.setImageResource(R.drawable.brooklyn);
            adultAdmission.setText("Adult $16");
            seniorAdmission.setText("Senior $10");
            studentAdmission.setText("Student $10");
            adultCost = 16;
            seniorCost = 10;
            studentCost = 10;




        }


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tickets, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adultTickets.setAdapter(adapter);
        adultTickets.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.tickets, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        seniorTickets.setAdapter(adapter2);
        seniorTickets.setOnItemSelectedListener(this);



        studentTickets.setAdapter(adapter);
        studentTickets.setOnItemSelectedListener(this);




    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView ticketCostView = (TextView)findViewById(R.id.ticketCostView);
        TextView salesTaxView = (TextView)findViewById(R.id.salesTaxView);
        TextView totalPriceView = (TextView)findViewById(R.id.totalView);
        double salesTax = 0.0, ticketCost = 0.0;

        numberTickets = position;
        total = numberTickets * adultCost;

        System.out.println("checking->>:" + id);
        totalPriceView.setText(String.valueOf(total));




    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    /**
     * Handles clickable Image and links to the associated museums website
     * @param view
     */

    public void museumImageOnCLick(View view) {

        Intent intent = getIntent();
        String museumId = intent.getStringExtra("MUSEUM_ID");


        if (museumId.equals("The Museum of Modern Art")) {

            Uri website = Uri.parse("https://www.moma.org/");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, website);
            startActivity(launchBrowser);


        } else if (museumId.equals("The Museum of Natural History")) {

            Uri website = Uri.parse("https://www.amnh.org/");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, website);
            startActivity(launchBrowser);

        } else if (museumId.equals("The Metropolitan Museum of Art")) {

            Uri website = Uri.parse("https://www.metmuseum.org/");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, website);
            startActivity(launchBrowser);

        } else if (museumId.equals("The Brooklyn Museum")) {

            Uri website = Uri.parse("https://www.brooklynmuseum.org/");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, website);
            startActivity(launchBrowser);

        }

    }

}