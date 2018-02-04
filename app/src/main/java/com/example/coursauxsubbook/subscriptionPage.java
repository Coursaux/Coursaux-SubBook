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
import java.util.ArrayList;

public class subscriptionPage extends AppCompatActivity {

    private static final String FILENAME = "newfile.sav";
    private ListView SubscriptionListView;
    private static ArrayList<Subscription> subscriptionlist;
    private ArrayAdapter<Subscription> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            subscriptionlist.add(addSubscription.getNewSubscription());
            adapter.notifyDataSetChanged();

            saveInFile();
        }catch (NullPointerException e){}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscription_page);

        Button addSubscription = (Button) findViewById(R.id.addSubscriptionButton);

        SubscriptionListView = (ListView) findViewById(R.id.SubscriptionListView);

    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    public void ChangePage(View view) {
        Intent intent = new Intent(this, addSubscription.class);
        startActivity(intent);
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();

            gson.toJson(subscriptionlist, out);

            out.flush();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
