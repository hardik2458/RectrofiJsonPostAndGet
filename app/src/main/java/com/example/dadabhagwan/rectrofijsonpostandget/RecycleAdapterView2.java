package com.example.dadabhagwan.rectrofijsonpostandget;

/**
 * Created by dadabhagwan on 12/8/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapterView2 extends RecyclerView.Adapter<RecycleAdapterView2.ViewHolder1> {

    private Context c;
    private List<User> msg=new ArrayList<>();

    public RecycleAdapterView2(Context context, List<User> message) {
        this.c=context;
        this.msg=message;

    }

    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_raw,parent,false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder1 holder, final int position) {

        holder.Id.setText(msg.get(position).getId()+"");
        holder.userId.setText(msg.get(position).getUserId()+"");
        holder.Title.setText(msg.get(position).getTitle());
        holder.Body.setText(msg.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return msg.size();
    }
    static class ViewHolder1 extends RecyclerView.ViewHolder {

        TextView userId,Id,Title,Body;

        public ViewHolder1(View itemView) {
            super(itemView);
            userId= (TextView) itemView.findViewById(R.id.tvUserId);
            Id= (TextView) itemView.findViewById(R.id.tvId);
            Title= (TextView) itemView.findViewById(R.id.tvTitle);
            Body= (TextView) itemView.findViewById(R.id.tvBody);
        }
    }
}

