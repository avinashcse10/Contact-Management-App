package com.example.homework2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;


public class ThirdActivity extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //String i = getIntent().getStringExtra("position");
        Bundle bundle = getIntent().getBundleExtra("bundle");
        String Name = bundle.getString("textName");
        String Number = bundle.getString("textNumber");
        String Mail = bundle.getString("textMail");
        String ID = bundle.getString("textID");
        TextView textName = findViewById(R.id.listViewName);
        TextView textNumber = findViewById(R.id.listViewNumber);
        TextView textMail = findViewById(R.id.listViewMail);
        TextView textID = findViewById(R.id.listViewID);
        textName.setText("Name:: "+Name);
        textNumber.setText("Number::  "+Number);
        textMail.setText("Email ID::  "+Mail);
        textID.setText("CSU ID::  "+ID);
        //Toast.makeText(this,Number,Toast.LENGTH_SHORT).show();
    }
    public void ListViewBack(View view){
        finish();
    }
}
