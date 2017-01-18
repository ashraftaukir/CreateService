package com.example.gagagugu.createservice;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityGgs extends AppCompatActivity {

    Button press;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ggs_activity_main);

        press=(Button)findViewById(R.id.btn_press);

        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                press.setVisibility(View.GONE);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                CreateServiceFragmentGgs fragment = new CreateServiceFragmentGgs();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();


            }
        });
    }


}
