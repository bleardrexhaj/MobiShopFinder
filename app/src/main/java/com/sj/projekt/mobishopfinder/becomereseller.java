package com.sj.projekt.mobishopfinder;

import android.content.Intent;
import android.database.Cursor;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class becomereseller extends AppCompatActivity  implements View.OnClickListener{

    private TextView login_text;
    private EditText user_name,user_surname,shop_name,shop_email,user_password,user_confirm_password;
    private Spinner shop_city;
    private Button register_button,shop_location;
    private double latitude,longitude;
    private final static int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_becomereseller);

        Spinner spinner = (Spinner) findViewById(R.id.shop_city);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cities, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        login_text = findViewById(R.id.login_text);
        shop_location = findViewById(R.id.shop_location);
        register_button = findViewById(R.id.register_button);
        user_name = findViewById(R.id.user_name);
        user_surname = findViewById(R.id.user_surname);
        shop_name = findViewById(R.id.shop_name);
        shop_city = findViewById(R.id.shop_city);
        shop_email = findViewById(R.id.shop_email);
        user_password = findViewById(R.id.password);
        user_confirm_password = findViewById(R.id.confirm_password);

        getWindow().setBackgroundDrawableResource(R.drawable.iph);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); //mos mu hap keyboardi(automatic)


        shop_location.setOnClickListener(this);
        login_text.setOnClickListener(this);
        register_button.setOnClickListener(this);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                latitude = data.getDoubleExtra("latitude",0);
                longitude = data.getDoubleExtra("longitude",0);

                shop_location.setText(latitude +" , "+longitude);
            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.login_text : intent = new Intent(this, Signin.class); startActivity(intent);break;

            case R.id.shop_location : intent = new Intent(this,MapsActivity.class);
            intent.putExtra("MerrLokacionin",true); startActivityForResult(intent,REQUEST_CODE); break;

            case R.id.register_button :

                if(!user_name.getText().toString().equals("") && !user_surname.getText().toString().equals("") && !user_password.getText().toString().equals("")&& !user_confirm_password.getText().toString().equals("")&& !shop_email.getText().toString().equals("")&& !shop_city.getSelectedItem().toString().equals("")&& !shop_name.getText().toString().equals("")&& !shop_location.getText().toString().equals("")) {
                    DBHandler db = DBHandler.getInstance(this);
                    String emri = user_name.getText().toString();
                    String mbiemri = user_surname.getText().toString();
                    String paswordi = user_password.getText().toString();
                    String konfirm_pasword = user_confirm_password.getText().toString();
                    String emri_mobileshopit = shop_name.getText().toString();
                    String qyteti_mobileshopit = shop_city.getSelectedItem().toString();
                    String emaili_mobileshopit = shop_email.getText().toString();

                    if(paswordi.equals(konfirm_pasword)) {
                        boolean vazhdo = false;
                        if(latitude != 0 && longitude != 0) {

                            Cursor getLocData = db.getLocationData();
                            Cursor getUsrData = db.getUserData();

                            if(getUsrData.getCount() == 0)
                                vazhdo = true;

                            for (int i = 0; i < getUsrData.getCount(); i++) {
                                if (getUsrData.move(i)) {
                                    if (getUsrData.getString(1).equals(emri) && getUsrData.getString(2).equals(mbiemri)) {
                                        vazhdo = false;
                                        break;
                                    }
                                    else {
                                        vazhdo = true;
                                    }
                                }
                            }

                            if(vazhdo) {
                                db.insertIntoLocations(latitude, longitude);
                                db.insertIntoUsers(emri,mbiemri,paswordi);
                                Cursor getLocData1 = db.getLocationData();
                                Cursor getUsrData1 = db.getUserData();
                                getLocData1.moveToLast();
                                getUsrData1.moveToLast();


                                int locationid = Integer.parseInt(getLocData1.getString(0));
                                int userid = Integer.parseInt(getUsrData1.getString(0));

                                db.insertIntoMobileShop(locationid, emri_mobileshopit, qyteti_mobileshopit, emaili_mobileshopit, userid);
                                db.close();
                                Toast.makeText(this, "JENI REGJISTRUAR ME SUKSESS!!!", Toast.LENGTH_LONG).show();
                                finish();
                            }else{
                                Toast.makeText(this,"Useri Egziston!!!",Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(this,"Gabim ne lokacion kontrollo mapin",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(this,"Passwordi nuk po perputhet",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this,"Insertoni te gjitha te dhenat",Toast.LENGTH_LONG).show();
                }




        }
    }
}
