package com.example.register;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class ListAdapter1 extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Items> itemsList;

    public ListAdapter1(Context context, int layout, ArrayList<Items> itemsList) {
        this.context = context;
        this.layout = layout;
        this.itemsList = itemsList;
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView txtemail;
        ImageView imageView;
        TextView txtName,txtPhone;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtName = (TextView) row.findViewById(R.id.name);
            holder.txtemail = (TextView) row.findViewById(R.id.email);
            holder.txtPhone = (TextView) row.findViewById(R.id.phone);
            holder.imageView = (ImageView) row.findViewById(R.id.image);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Items item = itemsList.get(position);
        holder.txtName.setText(item.getName());
        holder.txtPhone.setText(item.getPhone());
        holder.txtemail.setText(item.getEmail());
        byte[] foodImage = item.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}


