package com.example.mylibrary;

import static com.example.mylibrary.BookRecViewAdapter.BOOK_ID_KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private Button btnCurrentlyReading,btnWantToRead,btnAlreadyread,btnAddToFavorites;
    private ImageView imgBookLogo;
    private TextView txtBookTitle, txtAuthorTitle,txtPages,txtLongDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        intiViews();
        //TODO: GET THE DATA FROM RECYCLER VIEW
//        String desc = "Rich Dad Poor Dad has sold over 32 million copies[3] in more than 51 languages across more than 109 countries, been on the New York Times bestsellers list for over six years,[4] launched a series of books and related products; and received positive reviews from some critics.[5] American talk show host and media mogul Oprah Winfrey endorsed the book on her show. Another celebrity supporter is actor Will Smith, who said he taught his son about the financial responsibility by reading the book.[6] PBS Public Television station KOCE, aired a 55-minute presentation of Kiyosaki titled \"A Guide to Wealth\" in 2006 which essentially summarises his Rich Dad Poor Dad book. PBS also honored him with an excellence in education award in 2005.[7] Donald Trump did a literary collaboration with Kiyosaki in 2006 called Why We Want You To Be Rich, Two Men One Message and a second book called Midas Touch: Why Some Entrepreneurs Get Rich — And Why Most Don't in 2011.[8]\n" +
//                "\n" +
//                "American fashion entrepreneur and investor Daymond John has called the book one of his favorites.[9]\n" +
//                "\n" +
//                "Criticism\n" +
//                "A competing financial self help writer, John T. Reed, says, \"Rich Dad, Poor Dad contains much wrong advice, much bad advice, and virtually no good advice.\" He also states, \"Rich Dad, Poor Dad is one of the dumbest financial advice books I have ever read. It contains many factual errors and numerous extremely unlikely accounts of events that supposedly occurred.\"[10]\n" +
//                "\n" +
//                "Slate reviewer Rob Walker called the book full of nonsense, and said that Kiyosaki's claims were often vague, the narrative \"fablelike\", and that much of the book was \"self-help boilerplate\", noting the predictable common features of such books were present in Rich Dad, Poor Dad. He also criticizes Kiyosaki's conclusions about Americans, American culture, and Kiyosaki's methods.";
//        Book book = new Book(1,"Rich Dad Poor Dad","Robert Kiyosaki",2000,R.drawable.img,
//                "Rich Dad Poor Dad is a 1997 ",
//                desc);
        Intent intent = getIntent();
        if(intent!=null){
            int bookId = intent.getIntExtra(BOOK_ID_KEY,-1);
            if(bookId!=-1){
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if(incomingBook !=null){
                    setData(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handelCurrentlyReading(incomingBook);
                }
            }

        }
//        setData(book);
    }

    private void handelCurrentlyReading(final Book incomingBook) {
        ArrayList<Book> CurrentlyReading = Utils.getInstance().getCurrentlyReadingBooks();
        boolean ifExist = false;
        for(Book book : CurrentlyReading){
            if(book.getId()==incomingBook.getId()){
                ifExist=true;
            }
        }
        if(ifExist){
            btnCurrentlyReading.setEnabled(false);
        }else{
            btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(btnAlreadyread.isEnabled()==false){
                        new AlertDialog.Builder(BookActivity.this)
                                .setTitle("Confirm")
                                .setMessage("This book is already in already Readbooks \n" + "Are you sure to change it into Curently reading ")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        if(Utils.getInstance().swap_AlreadyRead_to_CurrentlyReading(incomingBook)){
                                            Toast.makeText(BookActivity.this, "Added Successfully 🪄", Toast.LENGTH_SHORT).show();
                                            //todo: navigate
                                            Intent intent = new Intent(BookActivity.this,CurrentlyReadingActivity.class);
                                            startActivity(intent);
                                        }
                                    }
                                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                }).show();
                    }else{
                        if(Utils.getInstance().addInCurrentlyReadingBooks(incomingBook)){
                            Toast.makeText(BookActivity.this, "Added Successfully 🪄", Toast.LENGTH_SHORT).show();
                            //todo: navigate
                            Intent intent = new Intent(BookActivity.this,CurrentlyReadingActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(BookActivity.this, "Something went wrong ⚠️,Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            });
        }


    }

    /**
     * enable or disable the button
     * add the books to already read books
     * @param incomingBook
     */
    private void handleAlreadyRead(final Book incomingBook) {
        ArrayList<Book> alReadyReadBook = Utils.getInstance().getAlreadyReadBooks();
        boolean ifExist = false;
        for(Book b : alReadyReadBook ){
            if(b.getId() == incomingBook.getId()){
                ifExist = true;
            }
        }
        if(ifExist){
            btnAlreadyread.setEnabled(false);
        }else{
            btnAlreadyread.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(btnCurrentlyReading.isEnabled()==false){
                        new AlertDialog.Builder(BookActivity.this)
                                .setTitle("Confirm")
                                .setMessage("This book is already in Currently Reading books \n" + "Are you sure to change it into Already read books ")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        if(Utils.getInstance().swap_CurrentlyReading_to_AlreadyRead(incomingBook)){
                                            Toast.makeText(BookActivity.this, "Added Successfully 🪄", Toast.LENGTH_SHORT).show();
                                            //todo: navigate
                                            Intent intent = new Intent(BookActivity.this,AlreadyReadBookActivity.class);
                                            startActivity(intent);
                                        }
                                    }
                                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                }).show();
                    }else{
                        if(Utils.getInstance().addInAlreadyReadBooks(incomingBook)){
                            Toast.makeText(BookActivity.this, "Added Successfully 🪄", Toast.LENGTH_SHORT).show();
                            //todo: navigate
                            Intent intent = new Intent(BookActivity.this,AlreadyReadBookActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(BookActivity.this, "Something went wrong ⚠️,Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            });
        }
    }

    private void setData(Book book){
        txtBookTitle.setText(book.getName());
        txtAuthorTitle.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtLongDescription.setText(book.getLongDesc());
        imgBookLogo.setImageResource(book.getImageUrl());
    }
    private void intiViews(){
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnAlreadyread = findViewById(R.id.btnAlreadyread);
        btnAddToFavorites = findViewById(R.id.btnAddToFavorites);
        imgBookLogo = findViewById(R.id.imgBookLogo);
        txtBookTitle = findViewById(R.id.txtBookTitle);
        txtAuthorTitle = findViewById(R.id.txtAuthorTitle);
        txtLongDescription = findViewById(R.id.txtLongDescription);
        txtPages = findViewById(R.id.txtPages);

    }
}