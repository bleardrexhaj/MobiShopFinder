package com.sj.projekt.mobishopfinder;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class FeedBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);



    }
    public void DialogBox(Context c){


        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
        View mview = layoutInflaterAndroid.inflate(R.layout.activity_feed_back,null);
        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
        alertDialogBuilderUserInput.setView(mview);



        final EditText userInputDialogEditText = mview.findViewById(R.id.userInputDialog);
        final EditText emri = mview.findViewById(R.id.emri_text);
        final EditText email = mview.findViewById(R.id.email_text);
        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                         //Rezultati i Boxit

                        String kritika_result = userInputDialogEditText.getText().toString();
                        String emri_result = emri.getText().toString();
                        String email_result = email.getText().toString();

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
        alertDialogAndroid.show();



    }

}
