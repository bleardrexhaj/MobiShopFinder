package com.sj.projekt.mobishopfinder;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Asus on 4/30/2018.
 */

public class Tab3Information extends Fragment {


    private String Emri_mobileshopit, Emri_pronarit, Numri_mobileshopit,Qyteti,Email;
    private TextView txt1,txt2,txt3,txt4,txt5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3info, container, false);
        txt1 = rootView.findViewById(R.id.txt1);
        txt2 = rootView.findViewById(R.id.txt2);
        txt3 = rootView.findViewById(R.id.txt3);
        txt4 = rootView.findViewById(R.id.txt4);
        txt5 = rootView.findViewById(R.id.txt5);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        Bundle getargs = this.getArguments();
        if(getargs != null) {

            Emri_pronarit = getargs.getString("Emri_pronarit");
            Emri_mobileshopit = getargs.getString("Emri_Mobileshopit");
            Numri_mobileshopit = getargs.getString("Numri_Mobileshopit");
            Qyteti = getargs.getString("Qyteti");
            Email = getargs.getString("Email");

            txt1.setText(Emri_pronarit);
            txt2.setText(Emri_mobileshopit);
            txt3.setText(Numri_mobileshopit);
            txt4.setText(Qyteti);
            txt5.setText(Email);

        }
    }
}
