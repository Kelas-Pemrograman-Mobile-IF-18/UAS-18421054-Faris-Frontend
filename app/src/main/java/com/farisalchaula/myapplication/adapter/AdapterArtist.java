package com.farisalchaula.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.farisalchaula.myapplication.R;
import com.farisalchaula.myapplication.model.ModelArtist;
import com.farisalchaula.myapplication.server.BaseURL;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterArtist extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<ModelArtist> item;

    public AdapterArtist(Activity activity, List<ModelArtist> item) {
        this.activity = activity;
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.artist_line, null);


        TextView artistName     = (TextView) convertView.findViewById(R.id.txtArtistName);
        TextView workDays       = (TextView) convertView.findViewById(R.id.txtWorkDays);
        TextView workProgress   = (TextView) convertView.findViewById(R.id.txtWorkProgress);
        TextView email          = (TextView) convertView.findViewById(R.id.txtEmail);
        ImageView gambarArtist    = (ImageView) convertView.findViewById(R.id.gambarArtist);

        artistName.setText(item.get(position).getArtistName());
        workDays.setText(item.get(position).getWorkDays());
        workProgress.setText(item.get(position).getWorkProgress());
        email.setText(item.get(position).getEmail());
        Picasso.get().load(BaseURL.baseUrl + "image/" + item.get(position).getCommissionSheet())
                .resize(300, 150)
                .centerCrop()
                .into(gambarArtist);
        return convertView;
    }
}
