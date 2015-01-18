package com.app.max.codrandommap;

import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        final TextView textView3 = (TextView) findViewById(R.id.textView3);
        Button button_1 = (Button) findViewById(R.id.generate_button);

        final List<String> mapList = new ArrayList<>();
        mapList.add("Aftermath");
        mapList.add("Cargo");
        mapList.add("Carrier");
        mapList.add("Drone");
        mapList.add("Express");
        mapList.add("Hijacked");
        mapList.add("Meltdown");
        mapList.add("Overflow");
        mapList.add("Plaza");
        mapList.add("Raid");
        mapList.add("Slums");
        mapList.add("Standoff");
        mapList.add("Turbine");
        mapList.add("Yemen");

        final List<String> played = new ArrayList<>();
        final Random i = new Random();

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int rand = i.nextInt(mapList.size());

                textView.setText(mapList.get(rand));
                played.add(mapList.get(rand));
                mapList.remove(mapList.get(rand));

                Collections.sort(played, String.CASE_INSENSITIVE_ORDER);

                StringBuilder map = new StringBuilder();

                for (String s : played){
                    map.append(" ");
                    map.append(s);
                    map.append(" \t");
                }

                String count;
                count = Integer.toString(mapList.size());

                textView2.setPaintFlags(textView2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                textView2.setText(map);
                textView3.setText(count);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
