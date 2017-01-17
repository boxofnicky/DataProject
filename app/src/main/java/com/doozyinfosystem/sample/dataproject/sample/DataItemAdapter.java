package com.doozyinfosystem.sample.dataproject.sample;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doozyinfosystem.sample.dataproject.DetailActivity;
import com.doozyinfosystem.sample.dataproject.MainActivity;
import com.doozyinfosystem.sample.dataproject.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Doozy on 17-01-2017.
 */

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.ViewHolder> {
    public static final String ITEM_KEY = "Item_key";
    private List<String> nameList = new ArrayList<>();
    private Context context;

    public DataItemAdapter(Context context, List<String> dataNameList) {
        this.context = context;
        this.nameList = dataNameList;

    }


    @Override
    public DataItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(DataItemAdapter.ViewHolder holder, final int position) {
        holder.tvName.setText(nameList.get(position));
        holder.tvDesc.setText(SampleDataProvider.getDataItemMap().get(nameList.get(position)).getItemDescription());
        InputStream inputStream = null;

        try {
            inputStream = context.getAssets().open(SampleDataProvider.getDataItemMap().get(nameList.get(position)).getItemImage());
            Drawable d = Drawable.createFromStream(inputStream, null);
            holder.imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(ITEM_KEY, SampleDataProvider.getDataItemMap().get(nameList.get(position)));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvDesc;
        public View mView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.name_text_list);
            tvDesc = (TextView) itemView.findViewById(R.id.desc_text_list);
            imageView = (ImageView) itemView.findViewById(R.id.list_image);
        }
    }
}
