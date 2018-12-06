package com.example.venkatmugesh.meetmrvalluvar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class KuralListView extends AppCompatActivity {

    ListView listOfKural;
    TextView athikaaramText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kural_list_view);
        athikaaramText = (TextView) findViewById(R.id.athikaaramText);
        listOfKural = (ListView) findViewById(R.id.kuralList);
        ArrayList<Integer> theList = new ArrayList<>();
        final KuralSearch mysearch = new KuralSearch();


        int pos;
        int kuNo;
        final String name;
        final String paal;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                pos = 0;
                kuNo = 0;
                name = null;
                paal = null;
            } else {
                pos= extras.getInt("Position");
                kuNo = extras.getInt("value");
                name = extras.getString("athikaaramName");
                paal = extras.getString("paal");
            }
        } else {
            pos = (int) savedInstanceState.getSerializable("Position");
            kuNo = (int) savedInstanceState.getSerializable("value");
            name = (String) savedInstanceState.getSerializable("athikaaramName");
            paal = (String) savedInstanceState.getSerializable("paal");
        }

        athikaaramText.setText("அதிகாரம் :" + name);
        theList.clear();

        Log.i("came here" , "here");
        switch (pos){
            case 1:
                kuNo = kuNo * 10;
                kuNo = kuNo +1;
                for (int i =kuNo ; i< kuNo+10; i++){
                theList.add(i);
            }break;
            case 2:
                kuNo = kuNo+38;
                kuNo = (kuNo) * 10;
                for (int i =kuNo ; i<= kuNo+10; i++){
                    theList.add(i);
                }break;
            case 3:
                kuNo  = kuNo+108;
                kuNo = (kuNo) * 10;
                Log.i("value of kuno" , String.valueOf(kuNo));
                for (int i =kuNo ; i<= kuNo+10; i++){
                    theList.add(i);
                }break;
        }

        ListAdapter listAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , theList);
        listOfKural.setAdapter(listAdapter);
        Log.i("before" , "listener");

       listOfKural.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
               Log.i("working" , "fine");
               int number = Integer.parseInt(adapterView.getItemAtPosition(i).toString());
               Log.i("check" , String.valueOf(number));
               if(number != 0){
                   Log.i("before" , "intent");
                   Intent intent = new Intent(KuralListView.this , KuralSelect.class);
                   Log.i("after" , "intent");
                   intent.putExtra("value" , number);
                   intent.putExtra("athikaaram" , name);
                   intent.putExtra("paal" , paal);
                   startActivity(intent);
                   Log.i("final" , "log");

               }

           }
       });

    }
}
