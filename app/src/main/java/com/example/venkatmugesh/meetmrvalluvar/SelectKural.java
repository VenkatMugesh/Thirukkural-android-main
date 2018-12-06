package com.example.venkatmugesh.meetmrvalluvar;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectKural extends AppCompatActivity {

    Button arathuButton;
    Button porutButton;
    Button kaamathuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_kural);

        arathuButton = (Button) findViewById(R.id.arathuButton);
        porutButton = (Button) findViewById(R.id.poruttButton);
        kaamathuButton = (Button) findViewById(R.id.kaamathButton);
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        final ArrayList<String> theList = new ArrayList<>();
        final ListAdapter listAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , theList);

        arathuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View myView = getLayoutInflater().inflate(R.layout.arathu_paal , null);
                mBuilder.setView(myView);

                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                dialog.setCancelable(true);

                ListView arathuList = (ListView) myView.findViewById(R.id.arathupaalList);
                theList.clear();
                theList.add("கடவுள் வாழ்த்து");
                theList.add("வான்சிறப்பு");
                theList.add("நீத்தார் பெருமை");
                theList.add("அறன் வலியுறுத்தல்");
                theList.add("இல்வாழ்க்கை");
                theList.add("வாழ்க்கைத் துணைநலம்");
                theList.add("மக்கட்பேறு / புதல்வரைப் பெறுதல்");
                theList.add("அன்புடைமை");
                theList.add("விருந்தோம்பல்");
                theList.add("இனியவைகூறல்");
                theList.add("செய்ந்நன்றி அறிதல்");
                theList.add("நடுவு நிலைமை");
                theList.add("அடக்கமுடைமை");
                theList.add("ஒழுக்கமுடைமை");
                theList.add("பிறனில் விழையாமை");
                theList.add("பொறையுடைமை");
                theList.add("அழுக்காறாமை");
                theList.add("வெஃகாமை");
                theList.add("புறங்கூறாமை");
                theList.add("பயனில சொல்லாமை");
                theList.add("தீவினையச்சம்");
                theList.add("ஒப்புரவறிதல்");
                theList.add("ஈகை");
                theList.add("புகழ்");
                theList.add("அருளுடைமை");
                theList.add("புலான்மறுத்தல்");
                theList.add("தவம்");
                theList.add("கூடாவொழுக்கம்");
                theList.add("கள்ளாமை");
                theList.add("வாய்மை");
                theList.add("வெகுளாமை");
                theList.add("இன்னாசெய்யாமை");
                theList.add("கொல்லாமை");
                theList.add("நிலையாமை");
                theList.add("துறவு");
                theList.add("மெய்யுணர்தல்");
                theList.add("அவாவறுத்தல்");
                theList.add("ஊழ்");
                ((ArrayAdapter) listAdapter).add(theList);
                int count = listAdapter.getCount();
                ((ArrayAdapter) listAdapter).remove(listAdapter.getItem(count - 1));
                arathuList.setAdapter(listAdapter);

                arathuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                        String name = adapterView.getItemAtPosition(i).toString();
                        Intent intent = new Intent(SelectKural.this , KuralListView.class);
                        intent.putExtra("Position" , 1);
                        intent.putExtra("value" , i);
                        intent.putExtra("athikaaramName" , name);
                        intent.putExtra("paal" , "அறத்துப்பால்");
                        startActivity(intent);

                    }
                });
            }
        });

        porutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View myView = getLayoutInflater().inflate(R.layout.porut_paal , null);
                mBuilder.setView(myView);

                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                dialog.setCancelable(true);

                ListView porutuList = (ListView) myView.findViewById(R.id.porutpaalList);
                theList.clear();
                theList.add("இறைமாட்சி");
                theList.add("கல்வி");
                theList.add("கல்லாமை");
                theList.add("கேள்வி");
                theList.add("அறிவுடைமை");
                theList.add("குற்றங்கடிதல்");
                theList.add("பெரியாரைத் துணைக்கோடல்");
                theList.add("சிற்றினஞ்சேராமை");
                theList.add("தெரிந்துசெயல்வகை");
                theList.add("வலியறிதல்");
                theList.add("காலமறிதல்");
                theList.add("இடனறிதல்");
                theList.add("தெரிந்துதெளிதல்");
                theList.add("தெரிந்துவினையாடல்");
                theList.add("சுற்றந்தழால்");
                theList.add("பொச்சாவாமை");
                theList.add("செங்கோன்மை");
                theList.add("கொடுங்கோன்மை");
                theList.add("வெருவந்தசெய்யாமை");
                theList.add("கண்ணோட்டம்");
                theList.add("ஒற்றாடல்");
                theList.add("ஊக்கமுடைமை");
                theList.add("மடியின்மை");
                theList.add("ஆள்வினையுடைமை");
                theList.add("இடுக்கணழியாமை");
                theList.add("அமைச்சு");
                theList.add("சொல்வன்மை");
                theList.add("வினைத்தூய்மை");
                theList.add("வினைத்திட்பம்");
                theList.add("வினைசெயல்வகை");
                theList.add("தூது");
                theList.add("மன்னரைச் சேர்ந்தொழுதல்");
                theList.add("குறிப்பறிதல்");
                theList.add("அவையறிதல்");
                theList.add("அவையஞ்சாமை");
                theList.add("நாடு ");
                theList.add("அரண்");
                theList.add("பொருள்செயல்வகை");
                theList.add("படைமாட்சி");
                theList.add("படைச்செருக்கு");
                theList.add("நட்பு ");
                theList.add("நட்பாராய்தல்");
                theList.add("பழைமை");
                theList.add("தீ நட்பு");
                theList.add("கூடாநட்பு");
                theList.add("பேதைமை");
                theList.add("புல்லறிவாண்மை");
                theList.add("இகல்");
                theList.add("பகைமாட்சி");
                theList.add("பகைத்திறந்தெரிதல்");
                theList.add("உட்பகை");
                theList.add("பெரியாரைப் பிழையாமை");
                theList.add("பெண்வழிச்சேறல்");
                theList.add("வரைவின்மகளிர்");
                theList.add("கள்ளுண்ணாமை");
                theList.add("சூது");
                theList.add("மருந்து");
                theList.add("குடிமை");
                theList.add("மானம்");
                theList.add("பெருமை");
                theList.add("சான்றாண்மை");
                theList.add("பண்புடைமை");
                theList.add("நன்றியில்செல்வம்");
                theList.add("நாணுடைமை");
                theList.add("குடிசெயல்வகை");
                theList.add("உழவு");
                theList.add("நல்குரவு");
                theList.add("இரவு");
                theList.add("இரவச்சம்");
                theList.add("கயமை");
                ((ArrayAdapter) listAdapter).add(theList);
                int count = listAdapter.getCount();
                ((ArrayAdapter) listAdapter).remove(listAdapter.getItem(count - 1));
                porutuList.setAdapter(listAdapter);

                porutuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                        String name = adapterView.getItemAtPosition(i).toString();
                        Intent intent = new Intent(SelectKural.this , KuralListView.class);
                        intent.putExtra("Position" , 2);
                        intent.putExtra("value" , i);
                        intent.putExtra("athikaaramName" , name);
                        intent.putExtra("paal" , "பொருட்பால்");
                        startActivity(intent);

                    }
                });
            }
        });

        kaamathuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View myView = getLayoutInflater().inflate(R.layout.kaamathu_paal , null);
                mBuilder.setView(myView);

                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                dialog.setCancelable(true);

                ListView kaamathuList = (ListView) myView.findViewById(R.id.kaamathuthupaalList);
                theList.clear();
                theList.add("தகையணங்குறுத்தல்");
                theList.add("குறிப்பறிதல்");
                theList.add("புணர்ச்சிமகிழ்தல்");
                theList.add("நலம்புனைந்துரைத்தல்");
                theList.add("காதற்சிறப்புரைத்தல்\n");
                theList.add("நாணுத்துறவுரைத்தல்");
                theList.add("அலரறிவுறுத்தல்");
                theList.add("பிரிவாற்றாமை");
                theList.add("படர்மெலிந்திரங்கல்");
                theList.add("கண்விதுப்பழிதல்");
                theList.add("பசப்புறுபருவரல்");
                theList.add("தனிப்படர்மிகுதி");
                theList.add("நினைந்தவர்புலம்பல்");
                theList.add("கனவுநிலையுரைத்தல்");
                theList.add("பொழுதுகண்டிரங்கல்");
                theList.add("உறுப்புநலனழிதல்");
                theList.add("நெஞ்சொடுகிளத்தல்");
                theList.add("நிறையழிதல்");
                theList.add("அவர்வயின்விதும்பல்");
                theList.add("குறிப்பறிவுறுத்தல்");
                theList.add("புணர்ச்சிவிதும்பல்");
                theList.add("நெஞ்சொடுபுலத்தல்");
                theList.add("புலவி");
                theList.add("புலவி நுணுக்கம்");
                theList.add("ஊடலுவகை");
                ((ArrayAdapter) listAdapter).add(theList);
                int count = listAdapter.getCount();
                ((ArrayAdapter) listAdapter).remove(listAdapter.getItem(count - 1));
                kaamathuList.setAdapter(listAdapter);

                kaamathuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                        String name = adapterView.getItemAtPosition(i).toString();
                        Intent intent = new Intent(SelectKural.this , KuralListView.class);
                        intent.putExtra("Position" , 3);
                        intent.putExtra("value" , i);
                        intent.putExtra("athikaaramName" , name);
                        intent.putExtra("paal" , "காமத்துப்பால்");
                        startActivity(intent);

                    }
                });

            }
        });

    }
}
