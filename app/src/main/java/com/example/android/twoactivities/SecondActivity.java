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

/**
 * SecondActivity defines the second activity in the app. It is launched
 * from an intent with a message, and sends an intent back with a second
 * message.
 */
public class SecondActivity extends AppCompatActivity {

    // Unique tag for the intent reply.
    public static final String EXTRA_ITEMS = "com.example.android.twoactivities.extra.ITEMS";

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    /**
     * Handles the onClick for the "Reply" button. Gets the message from the
     * second EditText, creates an intent, and returns that message back to
     * the main activity.
     *
     * @param view The view (Button) that was clicked.
     */
    public void select(View view) {

        // Create a new intent for the reply, add the reply message to it
        // as an extra, set the intent result, and close the activity.
        Intent itemIntent = new Intent();
        switch (view.getId()) {
            case R.id.cheese:
                itemIntent.putExtra(EXTRA_ITEMS, "cheese");
                setResult(RESULT_OK, itemIntent);
                finish();
                break;
            case R.id.rice:
                itemIntent.putExtra(EXTRA_ITEMS, "rice");
                setResult(RESULT_OK, itemIntent);
                finish();
                break;
            case R.id.apple:
                itemIntent.putExtra(EXTRA_ITEMS, "apple");
                setResult(RESULT_OK, itemIntent);
                finish();
                break;
            case R.id.rosti:
                itemIntent.putExtra(EXTRA_ITEMS, "rosti");
                setResult(RESULT_OK, itemIntent);
                finish();
                break;
            case R.id.muesli:
                itemIntent.putExtra(EXTRA_ITEMS, "muesli");
                setResult(RESULT_OK, itemIntent);
                finish();
                break;
            case R.id.orange:
                itemIntent.putExtra(EXTRA_ITEMS, "orange");
                setResult(RESULT_OK, itemIntent);
                finish();
                break;
            case R.id.pear:
                itemIntent.putExtra(EXTRA_ITEMS, "pear");
                setResult(RESULT_OK, itemIntent);
                finish();
                break;
            case R.id.peach:
                itemIntent.putExtra(EXTRA_ITEMS, "peach");
                setResult(RESULT_OK, itemIntent);
                finish();
                break;
            case R.id.lime:
                itemIntent.putExtra(EXTRA_ITEMS, "lime");
                setResult(RESULT_OK, itemIntent);
                finish();
                break;
            case R.id.kiwi:
                itemIntent.putExtra(EXTRA_ITEMS, "kiwi");
                setResult(RESULT_OK, itemIntent);
                finish();
                break;
        }

    }

}
