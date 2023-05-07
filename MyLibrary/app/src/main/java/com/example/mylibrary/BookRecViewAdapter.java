package com.example.mylibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.innerClass>{
    private static final String TAG = "BookRecViewAdapter";
    public static final String BOOK_ID_KEY = "bookId";
    private ArrayList<Book> books = new ArrayList<>();
    private Context myContext;
    private String parentActivity;


    public BookRecViewAdapter(Context myContext, String parentActivity) {
        this.myContext = myContext;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public innerClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent,false);
            return new innerClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull innerClass holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.txtBookName.setText(books.get(position).getName());
        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.imgBook.setImageResource(books.get(position).getImageUrl());
        holder.cardViewParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(myContext,BookActivity.class);
                intent.putExtra(BOOK_ID_KEY,books.get(position).getId());
                myContext.startActivity(intent);

            }
        });
        holder.txtShortDesc.setText(books.get(position).getShortDesc());
        if(parentActivity.equals("allbooks")){
            holder.btnDelete.setVisibility(View.GONE);
        }else if(parentActivity.equals(("alreadyRead"))){
            holder.btnDelete.setVisibility(View.VISIBLE);
            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(myContext);
                    builder.setMessage("Are you sure you want to delete " + books.get(position).getName() +" ?")
                        if(Utils.getInstance().removeFromAlreadyReadBook(books.get(position))){
                            Toast.makeText(myContext, "Books Removed", Toast.LENGTH_SHORT).show();
                            notifyDataSetChanged();
                        }else{
                            Toast.makeText(myContext, "Something happened", Toast.LENGTH_SHORT).show();
                        }
                }
            });

        } else if (parentActivity.equals("currentlyRead")) {
            
        }else{

        }
        if(books.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.cardViewParent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.btnDownArrow.setVisibility(View.GONE);
        }else{
            TransitionManager.beginDelayedTransition(holder.cardViewParent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.btnDownArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books){
        this.books = books;
        notifyDataSetChanged();
    }

    public class innerClass extends RecyclerView.ViewHolder{
        private CardView cardViewParent;
        private ImageView imgBook;
        private TextView txtBookName;
        private  TextView txtAuthor;
        private  ImageView btnDownArrow , btnUpArrow;
        private TextView txtShortDesc;
        private RelativeLayout expandedRelLayout;
        private TextView btnDelete;

        public innerClass(@NonNull View itemView) {
            super(itemView);
            cardViewParent = itemView.findViewById(R.id.cardViewParent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtBookName = itemView.findViewById(R.id.txtBookName);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            btnDownArrow = itemView.findViewById(R.id.btnDownArrow);
            btnUpArrow = itemView.findViewById(R.id.btnUpArrow);
            txtShortDesc = itemView.findViewById(R.id.txtShortDesc);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
            btnDelete = itemView.findViewById(R.id.btndelete);

            btnDownArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            btnUpArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
