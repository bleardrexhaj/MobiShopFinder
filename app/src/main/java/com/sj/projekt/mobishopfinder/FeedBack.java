package com.sj.projekt.mobishopfinder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;


public class FeedBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);



    }
    public void DialogBox(final Context c){


        final LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
        View mview = layoutInflaterAndroid.inflate(R.layout.activity_feed_back,null);
        final AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
        alertDialogBuilderUserInput.setView(mview);


        final EditText userInputDialogEditText = mview.findViewById(R.id.userInputDialog);
        final EditText emri = mview.findViewById(R.id.emri_text);
        final EditText email = mview.findViewById(R.id.email_text);
        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton("Send",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            String kritika_result = userInputDialogEditText.getText().toString();
                            String emri_result = emri.getText().toString();
                            String email_result = email.getText().toString();

                            if (!kritika_result.equals("") && !emri_result.equals("") && !email_result.equals("")) {
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("text/html");
                                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"bleardd@gmail.com"});
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback-u nga: "+email_result);
                                intent.putExtra(Intent.EXTRA_TEXT, kritika_result+"\n Emri: "+emri_result +"\n Email: "+email_result);

                                PackageManager packageManager = c.getPackageManager();
                                List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,
                                        PackageManager.MATCH_DEFAULT_ONLY);
                                boolean isIntentSafe = activities.size() > 0;
                                if(isIntentSafe){
                                    c.startActivity(Intent.createChooser(intent, "Send Email"));
                                }else
                                {
                                    Toast.makeText(c,"Nuk ka default program per egzekutim",Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(c, "Plotesoni te gjitha kolonat", Toast.LENGTH_LONG).show();
                            }
                    }
                }).setNegativeButton("Cancel",new DialogInterface.OnClickListener(){

                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         dialog.cancel();
                     }
        });

        AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
        alertDialogAndroid.show();



    }

}
