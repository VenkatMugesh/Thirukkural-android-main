package com.example.venkatmugesh.meetmrvalluvar;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticeKurals extends AppCompatActivity {

    TextView pLine1;
    TextView pLine2;
    Button next;
    Button previous;
    Button finish;
    int j =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_kurals);

        final int[] ids = new int[1330];
        pLine1 = (TextView) findViewById(R.id.practiceline1);
        pLine2 = (TextView) findViewById(R.id.practiceline2);
        next = (Button) findViewById(R.id.Next);
        previous = (Button) findViewById(R.id.Previous);
        finish = (Button) findViewById(R.id.finish);
        final OfflineDataBase myDb = new OfflineDataBase(this);

        Cursor data = myDb.getData();
        int i = 0;
        while (data.moveToNext()){
            ids[i] = Integer.parseInt(data.getString(0));
            i++;
        }

        Cursor c = myDb.getData(ids[0]);
        while(c.moveToNext()){
            pLine1.setText(c.getString(2));
            pLine2.setText(c.getString(3));
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            j = j+1;
            if(j < ids.length){
             Cursor  d = myDb.getData(ids[j]);

                while(d.moveToNext()){
                    pLine1.setText(d.getString(2));
                    pLine2.setText(d.getString(3));
                }
            }else {
                Toast.makeText(PracticeKurals.this , "That's all the kurals in Offline" , Toast.LENGTH_LONG).show();
            }

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j = j-1;
                if(j >= 0){
                    Cursor  d = myDb.getData(ids[j]);

                    while(d.moveToNext()){
                        pLine1.setText(d.getString(2));
                        pLine2.setText(d.getString(3));
                    }
                }

            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PracticeKurals.this , PlayGameMain.class);
                startActivity(i);
            }
        });
    }
}
