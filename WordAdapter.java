package com.example.android.miwok;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by don on 9/20/16.
 */
public class WordAdapter extends ArrayAdapter <Word> {
    private int mTextViewBkcolor;
    private int mPicBackColor;

    public WordAdapter(Context context, ArrayList<Word> LstWords,int TextViewBkColor,int PicBackColor)
    {
        super(context, 0, LstWords);
        this.mTextViewBkcolor = TextViewBkColor;
        this.mPicBackColor=PicBackColor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        Word CurrentWord = getItem(position);// get current Object requested which view/list position
        if (convertView == null) {
            //if this is not a recycled view create new one...
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // now get reference to each item in list
        ImageView ImgVw = (ImageView) convertView.findViewById(R.id.imageViewItem);
        TextView txtDefaultWord = (TextView) convertView.findViewById(R.id.txtDefaultWord);
        TextView txtMiwokWord = (TextView) convertView.findViewById(R.id.txtMiwokWord);
        View TextLayout = convertView.findViewById(R.id.TextLayout);// get textview layout
        //set text for each item in list

        txtDefaultWord.setText(CurrentWord.getmDefaultWord());
        txtMiwokWord.setText(CurrentWord.getmMiwokWord());
        TextLayout.setBackgroundColor(ContextCompat.getColor(convertView.getContext(),mTextViewBkcolor));

        // set Picture
       if (CurrentWord.getmImageviewId()==-99999)
       {
        // no image to display
           ImgVw.setVisibility(View.GONE);
       }else
       {
           ImgVw.setVisibility(View.VISIBLE);
           ImgVw.setImageResource(CurrentWord.getmImageviewId());

           ImgVw.setBackgroundColor(ContextCompat.getColor(convertView.getContext(),mPicBackColor));
       }
        return convertView;

    }
}
