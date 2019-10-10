/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.*;

/**
 * Version of TwoActivities app that prints messages to the logs
 * on Activity lifecycle state changes.
 */
public class MainActivity extends AppCompatActivity {

    // Unique tag for the intent reply
    public static final int ITEM_REQUEST = 1;

    private ArrayList<View> items = new ArrayList<>();
    private ArrayList<String> order = new ArrayList<>();

    /**
     * Maintains the Activity state across configuration changes.
     *
     * @param outState Activity state data to save
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (order.size() >= 0) {
            outState.putStringArrayList("order", order);
        }
    }

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all the view variables.
        items.add(findViewById(R.id.item1));
        items.add(findViewById(R.id.item2));
        items.add(findViewById(R.id.item3));
        items.add(findViewById(R.id.item4));
        items.add(findViewById(R.id.item5));
        items.add(findViewById(R.id.item6));
        items.add(findViewById(R.id.item7));
        items.add(findViewById(R.id.item8));
        items.add(findViewById(R.id.item9));
        items.add(findViewById(R.id.item10));

        // Restore the state.
        if (savedInstanceState != null) {
            order = savedInstanceState.getStringArrayList("order");
            if (order != null) {
                for (int i = 0; i < order.size(); i++) {
                    TextView it = (TextView) items.get(i);
                    it.setVisibility(View.VISIBLE);
                    it.setText(order.get(i));
                }
            }
        }
    }

    /**
     * Handles the onClick for the "Send" button. Gets the value of the main
     * EditText, creates an intent, and launches the second activity with
     * that intent.
     *
     * The return intent from the second activity is onActivityResult().
     *
     * @param view The view (Button) that was clicked.
     */
    public void addItem(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, ITEM_REQUEST);
    }

    public void clear(View view) {
        TextView emp = findViewById(R.id.item1);
        emp.setText("");
        emp = findViewById(R.id.item2);
        emp.setText("");
        emp = findViewById(R.id.item3);
        emp.setText("");
        emp = findViewById(R.id.item4);
        emp.setText("");
        emp = findViewById(R.id.item5);
        emp.setText("");
        emp = findViewById(R.id.item6);
        emp.setText("");
        emp = findViewById(R.id.item7);
        emp.setText("");
        emp = findViewById(R.id.item8);
        emp.setText("");
        emp = findViewById(R.id.item9);
        emp.setText("");
        emp = findViewById(R.id.item10);
        emp.setText("");
        order = new ArrayList<>();
    }

    /**
     * Handles the data in the return intent from SecondActivity.
     *
     * @param requestCode Code for the SecondActivity request.
     * @param resultCode Code that comes back from SecondActivity.
     * @param data Intent data sent back from SecondActivity.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Test for the right intent reply.
        if (requestCode == ITEM_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == RESULT_OK) {
                String it = data.getStringExtra(SecondActivity.EXTRA_ITEMS);
                order.add(it);
                for (int i = 0; i < order.size(); i++) {
                    TextView it1 = (TextView) items.get(i);
                    it1.setVisibility(View.VISIBLE);
                    it1.setText(order.get(i));
                }
            }
        }
    }
}
