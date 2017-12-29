package com.tenzliu.tenzbottomlayoutbar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tenzliu.tenzbottomlayoutbar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: TenzLiu
 * Date: 2017-12-27 22:15
 * Description: TODO
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainVieHolder> {

    private Context mContext;
    private List<String> mList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public MainAdapter(Context mContext, List<String> mList, OnItemClickListener onItemClickListener) {
        this.mContext = mContext;
        this.mList = mList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MainVieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainVieHolder(LayoutInflater.from(mContext).inflate(R.layout.item_main,parent,false));
    }

    @Override
    public void onBindViewHolder(MainVieHolder holder, final int position) {
        holder.btn_main.setText(mList.get(position));
        holder.btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MainVieHolder extends RecyclerView.ViewHolder{

        private Button btn_main;

        public MainVieHolder(View itemView) {
            super(itemView);
            btn_main = itemView.findViewById(R.id.btn_main);
        }

    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

}
