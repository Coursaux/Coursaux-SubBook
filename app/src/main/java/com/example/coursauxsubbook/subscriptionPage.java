package com.example.coursauxsubbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class subscriptionPage extends AppCompatActivity {

    private static final String FILENAME = "newfile.sav";
    private EditText bodyText;
    private ListView SubscriptionListView;
    private ArrayList<Subscription> subscriptionlist;
    private ArrayAdapter<Subscription> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
}
