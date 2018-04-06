package com.example.paigeplander.april6_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by paigeplander on 4/6/18.
 */

public class MyAdapter extends RecyclerView.Adapter {

    private ArrayList<String> mStringsArray;
    private Context mContext;

    MyAdapter(ArrayList<String> stringsArray, Context context) {
        mStringsArray = stringsArray;
        mContext = context;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String stringToDisplay = mStringsArray.get(position);
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case R.layout.basic_item_view:
                ((BasicViewHolder) holder).bindData(stringToDisplay);
                break;
            case R.layout.second_view_type_layout:
                ((SecondViewHolder) holder).bindData(stringToDisplay);
                break;
            default:
                // do nothing
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mStringsArray.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // TODO: return view holder for this view type
        View itemView = LayoutInflater.from(mContext).inflate(viewType, parent, false);
        switch (viewType) {
            case R.layout.basic_item_view:
                return new BasicViewHolder(itemView);
            case R.layout.second_view_type_layout:
                return new SecondViewHolder(itemView);
            default:
                return null;
        }
    }

    @Override
    // OPTIONAL to override
    public int getItemViewType(int position) {

        boolean shouldBeBasicView = position%2 ==0;
        if (shouldBeBasicView) {
            return R.layout.basic_item_view;
        }
        else {
            return R.layout.second_view_type_layout;
        }
    }
}

class BasicViewHolder extends RecyclerView.ViewHolder {

    private TextView itemTextView;

    BasicViewHolder(View itemView) {
        super(itemView);
        itemTextView = itemView.findViewById(R.id.basic_item_text_view);
    }

    void bindData(String textToDisplayOnItem) {
        itemTextView.setText(textToDisplayOnItem);
    }

}

class SecondViewHolder extends RecyclerView.ViewHolder {

    private TextView itemTextView;

    SecondViewHolder(View itemView) {
        super(itemView);
        itemTextView = itemView.findViewById(R.id.second_item_type_text_view);
    }

    void bindData(String textToDisplayOnItem) {
        itemTextView.setText(textToDisplayOnItem);
    }

}