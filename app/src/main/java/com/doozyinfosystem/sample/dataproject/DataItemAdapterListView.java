package com.doozyinfosystem.sample.dataproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Doozy on 15-01-2017.
 */

import com.doozyinfosystem.sample.dataproject.category.DataItem;
import com.doozyinfosystem.sample.dataproject.sample.*;

public class DataItemAdapterListView extends ArrayAdapter<String> {
    private List<String> itemList;
    private View inflater;
    private Context context;

    public DataItemAdapterListView(Context context, List<String> itemList) {
        super(context, R.layout.list_view, itemList);
        this.itemList = itemList;
        inflater = LayoutInflater.from(context).inflate(R.layout.list_view, null);
        this.context = context;
    }

    @NonNull
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }
        TextView nameText = (TextView) convertView.findViewById(R.id.name_text_list);
        nameText.setText(SampleDataProvider.getDataItemMap().get(itemList.get(position)).getItemName());
        TextView descText = (TextView) convertView.findViewById(R.id.desc_text_list);
        descText.setText(SampleDataProvider.getDataItemMap().get(itemList.get(position)).getCategory());
        ImageView imageView = (ImageView) convertView.findViewById(R.id.list_image);
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(SampleDataProvider.getDataItemMap().get(itemList.get(position)).getItemImage());
            Drawable d = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return convertView;
    }
}
