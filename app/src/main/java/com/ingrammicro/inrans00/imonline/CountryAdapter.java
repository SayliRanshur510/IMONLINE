package com.ingrammicro.inrans00.imonline;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by INRANS00 on 9/11/2018.
 */


public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> implements Filterable {
    private Context ctx;
    private ArrayList<Country> mCountry;
    private OnItemClickListener listener;

    private ArrayList<Country> dataList;

    public interface OnItemClickListener {
        void onItemClick(Country item);
    }




    public CountryAdapter(Context ctx, ArrayList<Country> mCountry) {
        this.mCountry = mCountry;
        this.ctx = ctx;
        this.dataList = new ArrayList<>(mCountry);
        notifyDataSetChanged();


    }
   /** public CountryAdapter(ArrayList<Country> mCountry, OnItemClickListener listener){
        this.mCountry = mCountry;
        this.listener = listener;
    }**/


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(ctx);
        view = mInflater.inflate(R.layout.content_country, parent, false);

        return new MyViewHolder(view,ctx,mCountry);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.countryName.setText(mCountry.get(position).getmCountryName());
        holder.countryFlag.setImageResource(mCountry.get(position).getImageResourceId());

    }


    @Override
    public int getItemCount() {
        return mCountry.size();
    }

    @Override
    public Filter getFilter() {
        return countryFilter;
    }

    private Filter countryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Country> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(dataList);

            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Country item : dataList) {
                    if (item.getmCountryName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mCountry.clear();
            mCountry.addAll((ArrayList) results.values);
            notifyDataSetChanged();

        }
    };


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

       TextView countryName;
       ImageView countryFlag;
       ArrayList<Country> mCountry = new ArrayList<Country>();
        Context mContext;


        public MyViewHolder(View itemView,Context mContext, ArrayList<Country> mCountry) {
            super(itemView);
            this.mCountry = mCountry;
            this.mContext = mContext;
            itemView.setOnClickListener(this);
            countryName = (TextView) itemView.findViewById(R.id.text_countryname);
            countryFlag = (ImageView) itemView.findViewById(R.id.image_countryflag);
        }

       /** public void bind(final Country item, final OnItemClickListener listener) {
            countryName.setText(item.getmCountryName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }**/

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Country country = this.mCountry.get(position);
            Intent intent = new Intent(this.mContext,HomeActivity.class);
            intent.putExtra("countryFlag",country.getImageResourceId());
            intent.putExtra("countryName",country.getmCountryName());

            this.mContext.startActivity(intent);

        }
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        mCountry.clear();
        if (charText.length() == 0) {
            mCountry.addAll(dataList);
        } else {
            for (Country filterCountryName : dataList) {
                if (filterCountryName.getmCountryName().toLowerCase(Locale.getDefault()).contains(charText)) {
                   mCountry.add(filterCountryName);
                }
            }
        }
        notifyDataSetChanged();
    }
    }

