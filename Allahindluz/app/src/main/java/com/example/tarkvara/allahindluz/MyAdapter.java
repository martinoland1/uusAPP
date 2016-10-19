package com.example.tarkvara.allahindluz;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tarkvara.allahindluz.R;


public class MyAdapter extends ArrayAdapter<Product> {

    Context context;
    int layoutResourceId;
    ArrayList<Product> data = new ArrayList<Product>();


    public MyAdapter(Context context, int layoutResourceId, ArrayList<Product> data) {

        super(context, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        Holder holder = null;

        if (row == null) {

            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new Holder();
            holder.name = (TextView) row.findViewById(R.id.item_name);
            holder.oldp = (TextView) row.findViewById(R.id.item_old_price);
            holder.newp = (TextView) row.findViewById(R.id.item_new_price);
            row.setTag(holder);
        }
        else {
            holder = (Holder) row.getTag();
        }

        Product product = data.get(position);
        holder.name.setText(product.getName());
        holder.oldp.setText(product.getOldPriceString());
        holder.newp.setText(product.getNewPriceString());
        return row;

    }

    static class Holder {
        TextView name;
        TextView oldp;
        TextView newp;

    }
}