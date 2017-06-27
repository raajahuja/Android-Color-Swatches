package com.example.raaj.acs;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Raaj on 1/28/2016.
 */
public class RecyclerViewAdapter_ListingColors extends RecyclerView.Adapter<RecyclerViewAdapter_ListingColors.RecyclerViewHolder> {
    List<Color_Holder> websites;
    Context context;

    public RecyclerViewAdapter_ListingColors(List<Color_Holder> websites, Context context) {
        this.websites = websites;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return websites.size();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_listingcolor, viewGroup, false);
        RecyclerViewHolder websiteViewHolder = new RecyclerViewHolder(view);
        return websiteViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder websiteViewHolder, final int i) {
        websiteViewHolder.website_name.setText(websites.get(i).Color_Code);
        websiteViewHolder.hex_color.setText(websites.get(i).hexadecimal_color);
        websiteViewHolder.rgb_color.setText(websites.get(i).rgb_color);

        websiteViewHolder.cardView.setCardBackgroundColor(websites.get(i).hex_color);

        //Clicking Event
        websiteViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView website_name;
        TextView hex_color;
        TextView rgb_color;

        CardView cardView;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.CardView1);
            website_name = (TextView) itemView.findViewById(R.id.ColorCode_textView1);
            hex_color = (TextView) itemView.findViewById(R.id.HexColor_textView2);
            rgb_color = (TextView) itemView.findViewById(R.id.RGB_textView3);
        }
    }
}
