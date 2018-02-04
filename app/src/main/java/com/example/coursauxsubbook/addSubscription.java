package com.example.coursauxsubbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addSubscription extends AppCompatActivity {
    private static Subscription newSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subscription);
    }

    public void ChangePage(View view) throws ParseException {
        /* from https://stackoverflow.com/questions/8498880/retrieving-data-from-edittext-in-android*/
        EditText editText = (EditText) findViewById(R.id.NameFill);
        String name = editText.getText().toString();

        EditText editText1 = (EditText) findViewById(R.id.DateFill);
        String dateString = editText1.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
        Date date = dateFormat.parse(dateString);

        EditText editText2 = (EditText) findViewById(R.id.PriceFill);
        float price = Float.valueOf(editText2.getText().toString());

        newSubscription = new Subscription(name, date, price);

        Intent intent = new Intent(this, subscriptionPage.class);
        startActivity(intent);
    }

    public static Subscription getNewSubscription() {
        return newSubscription;
    }
}
