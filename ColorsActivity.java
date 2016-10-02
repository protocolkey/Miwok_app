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

import com.example.android.miwok.Word;
import com.example.android.miwok.WordAdapter;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer Mp;
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp)
        {
            ReleaseMPPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_list_view);
        final ArrayList<Word> words = new ArrayList<>();


        words.add(new Word("red", "weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        words.add(new Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("green", "chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("black", "kululli",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("white", "kelelli",R.drawable.color_white,R.raw.color_white));


        WordAdapter wordAdapter = new WordAdapter(this, words,R.color.category_colors,R.color.tan_background); // create custom adapter arrayList<Word>
        ListView rootList = (ListView) findViewById(R.id.listview); // get reference to listview
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
                //test


            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        Mp.release();
    }

    private void donot ()
    {

    }
    private void ReleaseMPPlayer() {
        if (Mp!=null) {
            Mp.release();
            Mp = null;
        }
    }
}
