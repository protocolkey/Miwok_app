/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer Mp;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp)
        {
            ReleaseMPPlayer();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        ReleaseMPPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_list_view);
        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("one", "lutti",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two", "otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three", "tolookosu",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four", "oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five", "massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six", "temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven", "kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight", "kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine", "wo’e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten", "na’aacha",R.drawable.number_ten,R.raw.number_ten));


        WordAdapter wordAdapter = new WordAdapter(this, words,R.color.category_numbers,R.color.tan_background); // create custom adapter arrayList<Word>
        ListView rootList = (ListView) findViewById(R.id.listview); // get reference to listview
        rootList.setBackgroundColor(R.color.category_numbers);

                /*
                style="@style/CategoryStyle"
        android:background="@color/category_numbers"
                 */
        rootList.setAdapter(wordAdapter);// set custom adapter for list view.
        rootList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word tmp = words.get(position);
                ReleaseMPPlayer();
                Mp =  MediaPlayer.create(getApplicationContext(), tmp.getmSoundId());
                Mp.start();
                Mp.setOnCompletionListener(mOnCompletionListener);
                Log.e("MyApp", "Started play");
            }
        });







    }
    private void ReleaseMPPlayer() {
        if (Mp!=null) {
            Mp.release();
            Mp = null;
        }
    }
}
