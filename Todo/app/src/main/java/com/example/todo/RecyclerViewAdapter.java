package com.example.todo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private Context context;
    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }
    private  ArrayList<task>al=new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.checkedOrUnchecked.setChecked(al.get(position).isCheckedOrUnchecked());
        holder.txt.setText( al.get(position).getString());
        holder.cardViewParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(context,NotesActivity.class);
                Bundle extras = new Bundle();
                extras.putString("Title",al.get(position).getString());
                extras.putString("DESC",al.get(position).getDesc());
                extras.putInt("Activity",2);
                main.putExtras(extras);
                context.startActivity(main);
            }
        });
        if(!al.get(position).getDesc().equals("")) {
            holder.document.setVisibility(View.VISIBLE);
        }else{
            holder.document.setVisibility(View.INVISIBLE);
        }




    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt;
        CheckBox checkedOrUnchecked;
        CardView cardViewParent;
        ImageView document;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt=itemView.findViewById(R.id.giventext);
            checkedOrUnchecked=itemView.findViewById(R.id.checkorUnchecked);
            cardViewParent = itemView.findViewById(R.id.cardviewParent);
            document = itemView.findViewById(R.id.document);


        }
    }


    public void setall(ArrayList<task> al) {
        this.al = al;
        notifyDataSetChanged();

    }
}