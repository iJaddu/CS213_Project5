package com.example.cs213_project5;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.text.DecimalFormat;

public class TicketActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    double total =0.0;
    int adultCost = 0;
    int seniorCost = 0;
    int studentCost = 0;
    int numberTickets=0;
    double salesTax = 0.0, adultTicketCost = 0.0, seniorTicketCost = 0.0, studentTicketCost = 0.0,nySalesTax  = .08875;
    double adultTax=0.0, seniorTax = 0.0, studentTax = 0.0;



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
            adultAdmission.setText(R.string.momaAdult);
            seniorAdmission.setText(R.string.momaSenior);
            studentAdmission.setText(R.string.momaStudent);
            adultCost = 25;
            seniorCost = 18;
            studentCost = 14;





        } else if (message.equals("The Museum of Natural History")) {
            museumName.setImageResource(R.drawable.natural_history);
            adultAdmission.setText(R.string.nhmAdult);
            seniorAdmission.setText(R.string.nhmSenior);
            studentAdmission.setText(R.string.nhmStudent);
            adultCost = 23;
            seniorCost = 18;
            studentCost = 18;



        } else if (message.equals("The Metropolitan Museum of Art")) {
            museumName.setImageResource(R.drawable.met);
            adultAdmission.setText(R.string.metAdult);
            seniorAdmission.setText(R.string.metSenior);
            studentAdmission.setText(R.string.metStudent);
            adultCost = 25;
            seniorCost = 17;
            studentCost = 12;





        } else if (message.equals("The Brooklyn Museum")) {
            museumName.setImageResource(R.drawable.brooklyn);
            adultAdmission.setText(R.string.brookAdult);
            seniorAdmission.setText(R.string.brookSenior);
            studentAdmission.setText(R.string.brookStudent);
            adultCost = 16;
            seniorCost = 10;
            studentCost = 10;



        }








        ArrayAdapter<CharSequence> adultAdapter = ArrayAdapter.createFromResource(this, R.array.adultTicketArray, android.R.layout.simple_spinner_item);
        adultAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adultTickets.setAdapter(adultAdapter);
        adultTickets.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> seniorAdapter = ArrayAdapter.createFromResource(this, R.array.seniorTicketArray, android.R.layout.simple_spinner_item);
        seniorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        seniorTickets.setAdapter(seniorAdapter);
        seniorTickets.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> studentAdapter = ArrayAdapter.createFromResource(this, R.array.studentTicketArray, android.R.layout.simple_spinner_item);
        seniorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        studentTickets.setAdapter(studentAdapter);
        studentTickets.setOnItemSelectedListener(this);


        Context context = getApplicationContext();
        CharSequence msg = "Maximum of 5 tickets each!";
        int duration = Toast.LENGTH_LONG;

        Toast.makeText(context, msg, duration).show();

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView ticketCostView = (TextView)findViewById(R.id.ticketCostView);
        TextView salesTaxView = (TextView)findViewById(R.id.salesTaxView);
        TextView totalPriceView = (TextView)findViewById(R.id.totalView);

        DecimalFormat df = new DecimalFormat("0.00");


        String ticketType = parent.getSelectedItem().toString().split(" ")[1];

        switch (ticketType) {


            case "Adults":

                if((position == 0) && (total > 0.0)) {
                    total = total - adultTicketCost - adultTax;
                    salesTax = salesTax - adultTax;
                    adultTicketCost = 0.0;
                    adultTax = 0.0;
                    totalPriceView.setText("$ ".concat(String.valueOf(df.format(total))));
                    ticketCostView.setText("$ ".concat(String.valueOf(df.format(adultTicketCost))));
                    salesTaxView.setText("$ ".concat(String.valueOf(df.format(salesTax))));
                }
                else{

                    numberTickets = position;
                    adultTicketCost = adultTicketCost + ( numberTickets * adultCost);
                    ticketCostView.setText("$ ".concat(String.valueOf(df.format(adultTicketCost))));
                    adultTax = (adultTicketCost * nySalesTax);
                    salesTax = salesTax + adultTax;
                    salesTaxView.setText("$ ".concat(String.valueOf(df.format(salesTax))));
                    total = total + adultTicketCost + adultTax;

                }


                break;

            case "Seniors":

                if(position == 0 && total > 0.0) {
                    total = total - seniorTicketCost - seniorTax;
                    salesTax = salesTax - seniorTax;
                    seniorTicketCost = 0.0;
                    seniorTax = 0.0;
                    totalPriceView.setText("$ ".concat(String.valueOf(df.format(total))));
                    ticketCostView.setText("$ ".concat(String.valueOf(df.format(seniorTicketCost))));
                    salesTaxView.setText("$ ".concat(String.valueOf(df.format(salesTax))));

                }
                else {

                    numberTickets = position;
                    seniorTicketCost = seniorTicketCost + ( numberTickets * seniorCost);
                    ticketCostView.setText("$ ".concat(String.valueOf(seniorTicketCost)));
                    seniorTax = seniorTicketCost * nySalesTax;
                    salesTax = salesTax + seniorTax;
                    salesTaxView.setText("$ ".concat(String.valueOf(df.format(salesTax))));
                    total = total + seniorTicketCost + seniorTax;
                }


                break;

            case "Students":

                if(position == 0 && total > 0.0) {
                    total = total - studentTicketCost - studentTax;
                    salesTax = salesTax - studentTax;
                    studentTicketCost = 0.0;
                    studentTax =0.0;
                    totalPriceView.setText("$ ".concat(String.valueOf(df.format(total))));
                    ticketCostView.setText("$ ".concat(String.valueOf(df.format(studentTicketCost))));
                    salesTaxView.setText(String.valueOf("$ ".concat(String.valueOf(df.format(salesTax)))));
                }
                numberTickets = position;
                studentTicketCost = studentTicketCost + ( numberTickets * studentCost);
                ticketCostView.setText("$ ".concat(String.valueOf(df.format(studentTicketCost))));
                studentTax = studentTicketCost * nySalesTax;
                salesTax = salesTax + studentTax;
                salesTaxView.setText("$ ".concat(String.valueOf(df.format(salesTax))));
                total = total + studentTicketCost + studentTax;

                break;

        }

        totalPriceView.setText("$ ".concat(String.valueOf(df.format(total))));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
        return true;
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