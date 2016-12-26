package com.example.dadabhagwan.rectrofijsonpostandget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dadabhagwan on 12/6/2016.
 */

public class RecycleAdapterView extends RecyclerView.Adapter<RecycleAdapterView.ViewHolder> {

    private Context c;
    private List<User> msg=new ArrayList<>();

    public RecycleAdapterView(Context context, List<User> message) {
    this.c=context;
    this.msg=message;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_raw,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.Id.setText(msg.get(position).getId()+"");
        holder.userId.setText(msg.get(position).getUserId()+"");
        holder.Title.setText(msg.get(position).getTitle());
        holder.Body.setText(msg.get(position).getBody());
        holder.Id.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                Long id=msg.get(position).getUserId();
                Intent i=new Intent(c,SecondActivity.class);
                i.putExtra("key",id);
                c.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return msg.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView userId,Id,Title,Body;

        public ViewHolder(View itemView) {
            super(itemView);
            userId= (TextView) itemView.findViewById(R.id.tvUserId);
            Id= (TextView) itemView.findViewById(R.id.tvId);
            Title= (TextView) itemView.findViewById(R.id.tvTitle);
            Body= (TextView) itemView.findViewById(R.id.tvBody);
        }
    }
}
