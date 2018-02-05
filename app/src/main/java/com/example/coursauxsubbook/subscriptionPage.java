/**
 * Issues:
 *      1. the way I had to update the listview prevents it from saving after closing, any other
 *      way of doing it caused the app to crash.
 *      2. the setOnItemClickListener didn't work no matter what I tried. multiple hours were
 *      trying to fix it it to no avail.
 *      3. The emulator froze my computer at one point and I lost the tabs I had open, so some
 *      parts aren't cited properly.
 *
 */

package com.example.coursauxsubbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * the main activity
 */
public class subscriptionPage extends AppCompatActivity  {

    private static final String FILENAME = "newfile.sav";
    private ListView lv;
    private ArrayList<String> subList = new ArrayList<String>();
    private ArrayList<Subscription> subListR = new ArrayList<Subscription>();
    private ArrayAdapter<Subscription> adapter;

    /**
     * creating the instance
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscription_page);

        lv = (ListView) findViewById(R.id.SubListView);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * changes to the edit subscription page and fills the edittexts
             * with info from the subscription to be edited
             *
             * @param parent
             * @param view
             * @param i
             * @param id
             */
            /* from stackoverflow, lost url */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Log.i("tag1", "it works!");
                setContentView(R.layout.sub_info);
                /* from stackoverflow, lost url */
                EditText et = (EditText) findViewById(R.id.NameEdit);
                et.setText(subListR.get(i).getName());
                EditText et1 = (EditText) findViewById(R.id.DateEdit);
                et1.setText(subListR.get(i).getDate().toString());
                EditText et2 = (EditText) findViewById(R.id.PriceEdit);
                et2.setText(subListR.get(i).getPrice().toString());
            }
        });
    }


    /**
     * called when clicking on the add subscription button, changes to a new layout
     *
     * @param view
     */
    public void ChangePage(View view) {
        setContentView(R.layout.activity_add_subscription);
    }

    /**
     * called when clicking on the add button in the add subscription layout
     * adds a subscription to the list and list view
     *
     * @param view
     * @throws ParseException
     */
    public void ChangePageBack(View view) throws ParseException {
         /* from https://stackoverflow.com/questions/8498880/retrieving-data-from-edittext-in-android*/
        EditText editText = (EditText) findViewById(R.id.NameFill);
        String name = editText.getText().toString();

        EditText editText1 = (EditText) findViewById(R.id.DateFill);
        String dateString = editText1.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
        Date date = dateFormat.parse(dateString);

        EditText editText2 = (EditText) findViewById(R.id.PriceFill);
        float price = Float.valueOf(editText2.getText().toString());

        EditText editText3 = (EditText) findViewById(R.id.NameFill);
        String comment = editText3.getText().toString();

        Subscription sub = new Subscription(name, date, price, comment);

        setContentView(R.layout.subscription_page);

        lv = (ListView) findViewById(R.id.SubListView);

        subListR.add(sub);
        subList.add(sub.getName());

        float k = 0;    /* Here until issue with click listener solved*/
        for(int i=0; i<subListR.size(); i++){
            k = k + subListR.get(i).getPrice();
        }
        String l = String.format("%.2f", k);
        TextView tv = (TextView) findViewById(R.id.PriceTotal);
        tv.setText(l);  /* Here until issue with click listener solved*/

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                subList);

        lv.setAdapter(arrayAdapter);
    }

}
