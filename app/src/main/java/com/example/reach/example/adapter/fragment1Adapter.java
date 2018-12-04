package com.example.reach.example.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reach.example.R;
import com.example.reach.example.activity.ExampleActivity;

import java.util.List;

/**
 * Created by ZX on 2018/11/28
 */
public class fragment1Adapter extends RecyclerView.Adapter<fragment1Adapter.nav1Holder> {

    private List<String> data;
    private Context context;

    public fragment1Adapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public nav1Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nav1_fragment,parent,false);
        return new nav1Holder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull nav1Holder holder, int position) {
        String item=data.get(position);
        holder.bindView(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,ExampleActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class nav1Holder extends RecyclerView.ViewHolder{

        TextView tv;

        public nav1Holder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.item_nav1_tv);
        }

        public void bindView(String infoData){
            tv.setText(infoData);
        }
    }
}
