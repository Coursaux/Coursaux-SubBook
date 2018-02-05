package com.example.coursauxsubbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class subscriptionPage extends AppCompatActivity {

    private static final String FILENAME = "newfile.sav";
    private ListView lv;
    private ArrayList<String> subList = new ArrayList<String>();
    private ArrayAdapter<Subscription> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscription_page);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    public void ChangePage(View view) {
        setContentView(R.layout.activity_add_subscription);
    }

    public void ChangePageBack(View view) throws ParseException {
         /* from https://stackoverflow.com/questions/8498880/retrieving-data-from-edittext-in-android*/
        EditText editText = (EditText) findViewById(R.id.NameFill);
        String name = editText.getText().toString();

        EditText editText1 = (EditText) findViewById(R.id.DateFill);
        String dateString = editText1.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
        Date date = dateFormat.parse(dateString);

        EditText editText2 = (EditText) findViewById(R.id.PriceFill);
        float price = Float.valueOf(editText2.getText().toString());

        Subscription sub = new Subscription(name, date, price);

        setContentView(R.layout.subscription_page);

        lv = (ListView) findViewById(R.id.SubListView);

        subList.add(sub.getName());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                subList );

        lv.setAdapter(arrayAdapter);
}

    public void ChangeSubInfo(View view) {
        
    }
}
