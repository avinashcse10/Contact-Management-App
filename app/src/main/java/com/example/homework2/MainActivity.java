package com.example.homework2;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class MainActivity extends Activity {


    ArrayList<String> arrayName = new ArrayList<String>();
    ArrayList<String> arrayNumber = new ArrayList<String>();
    ArrayList<String> arrayMail = new ArrayList<String>();
    ArrayList<String> arrayID = new ArrayList<String>();
    int request_code = 1;
    String[] myarray={"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonMain(View view) {
        startActivityForResult(new Intent("com.example.homework2.SecondActivity"), request_code);
        // TextView textView = findViewById(R.id.TextviewMain);
        //textView.setText((CharSequence) arrayName);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == request_code) {
            if (resultCode == RESULT_OK) {
                final Bundle bundle = data.getBundleExtra("bundle");
                arrayName.add(bundle.getString("textName"));
                arrayNumber.add(bundle.getString("textNumber"));
                arrayMail.add(bundle.getString("textMail"));
                arrayID.add(bundle.getString("textID"));
                ArrayAdapter adapter = new ArrayAdapter(this,R.layout.activity_mylist,arrayName);
                ListView listView = (ListView) findViewById(R.id.mylist);
                listView.setAdapter(adapter);
                listView.setClickable(true);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //setContentView(R.layout.activity_third);
                        Intent activity3 = new Intent("com.example.homework2.ThirdActivity");
                        //activity3.putExtra("position",i);
                        final Bundle bundleList = new Bundle();
                        bundleList.putString("textName",arrayName.get(i));
                        bundleList.putString("textNumber",arrayNumber.get(i));
                        bundleList.putString("textMail",arrayMail.get(i));
                        bundleList.putString("textID",arrayID.get(i));
                        activity3.putExtra("bundle",bundleList);
                        startActivity(activity3);
                    }
                });
            }
        }


    }

}
