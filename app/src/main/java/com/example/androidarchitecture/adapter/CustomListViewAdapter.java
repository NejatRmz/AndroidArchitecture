package com.example.androidarchitecture.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidarchitecture.R;
import com.example.androidarchitecture.model.Model;

import java.util.ArrayList;

/**
 * 功能描述
 *
 * @author n84190005
 * @since 2022-02-02
 */
public class CustomListViewAdapter extends ArrayAdapter<Model> {

    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder holder;
    private final ArrayList<Model> models;

    public CustomListViewAdapter(Context context, ArrayList<Model> persons) {
        super(context,0, persons);
        this.context = context;
        this.models = persons;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Model getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return models.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.row_layout, null);

            holder = new ViewHolder();
            holder.countryName = (TextView) convertView.findViewById(R.id.listText);
            convertView.setTag(holder);

        }
        else{
            //Get viewholder we already created
            holder = (ViewHolder)convertView.getTag();
        }

        Model model = models.get(position);
        if(models != null){
            holder.countryName.setText(model.countryName);

        }
        return convertView;
    }

    //View Holder Pattern for better performance
    private static class ViewHolder {
        TextView countryName;

    }
}
