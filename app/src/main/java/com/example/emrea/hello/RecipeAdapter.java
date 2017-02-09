package com.example.emrea.hello;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RecipeAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    //private final Integer[] imgid;

    public RecipeAdapter(Activity context, String[] itemname) {
        super(context, R.layout.listview, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        //this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        //imageView.setImageResource(imgid[position]);
        Picasso.with(context).load("https://i.scdn.co/image/f952cce40f47e2571f7e0f918b56395612ed2843").into(imageView);
        extratxt.setText("Description "+itemname[position]);
        return rowView;

    };
}