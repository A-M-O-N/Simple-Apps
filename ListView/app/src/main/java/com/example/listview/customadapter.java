package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class customadapter extends ArrayAdapter<String> {
    public customadapter(@NonNull Context context, String[] fruits) {
        super(context,R.layout.customrow, fruits);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater myinflater=LayoutInflater.from(getContext());
        View Customview =myinflater.inflate(R.layout.customrow,parent,false);
        //get a reference o a row
        String singlefruititem=getItem(position);
        TextView mytext=(TextView)Customview.findViewById(R.id.mytext);
        ImageView myimage=(ImageView)Customview.findViewById(R.id.myimage);
        mytext.setText(singlefruititem);
        myimage.setImageResource(R.drawable.apple);
        return Customview;

    }
}
