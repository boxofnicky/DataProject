package com.doozyinfosystem.sample.dataproject;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.doozyinfosystem.sample.dataproject.category.DataItem;
import com.doozyinfosystem.sample.dataproject.sample.DataItemAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        DataItem item = getIntent().getExtras().getParcelable(DataItemAdapter.ITEM_KEY);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.activity_detail);
        ImageView imageView = (ImageView) findViewById(R.id.detail_image);
        TextView tName = (TextView) findViewById(R.id.name_detail);
        TextView tPrice = (TextView) findViewById(R.id.price_detail);
        try {
            InputStream inputStream = getAssets().open(item.getItemImage());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tName.setText(item.getItemName());
        double price = item.getItemPrice();
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
        tPrice.setText(format.format(price));
        TextView textView = new TextView(this);
        textView.setText(item.getItemDescription());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, imageView.getId());
        params.addRule(RelativeLayout.ALIGN_LEFT);
        textView.setLayoutParams(params);
        relativeLayout.addView(textView);

    }
}
