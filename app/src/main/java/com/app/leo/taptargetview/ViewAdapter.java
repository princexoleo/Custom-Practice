package com.app.leo.taptargetview;

import android.support.annotation.NonNull;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {


    private String [] data;
    public ViewAdapter(String [] data) {

        this.data=data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       LayoutInflater inflater=LayoutInflater.from(parent.getContext());
       View view=inflater.inflate(R.layout.list_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title=data[position];
        holder.textView.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    //inner class to hold view
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imgView=itemView.findViewById(R.id.imgView);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}
