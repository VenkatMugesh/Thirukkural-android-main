package com.example.venkatmugesh.meetmrvalluvar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class KuralSelect extends AppCompatActivity {

    TextView selectLine1;
    TextView selectLine2;
    TextView paal;
    TextView athikaaram;
    int kuNo;
    Button saveSelectOffline;
    String Line1 = "";
    String Line2 = "";
    String trans = "";
    OfflineDataBase muDb;

    boolean internet_connection() {
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        @SuppressLint("MissingPermission") NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    public void selectOffline(View view){
        boolean adding = muDb.addData(String.valueOf(kuNo), Line1 , Line2 ,trans);
        if (adding)
        {
            Toast.makeText(KuralSelect.this , "Saved Successfully..!!" , Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kural_select);
        selectLine1 = (TextView) findViewById(R.id.selectLineText);
        selectLine2 = (TextView) findViewById(R.id.selectLineText2);
        paal = (TextView) findViewById(R.id.paalText);
        athikaaram = (TextView) findViewById(R.id.athikaaramText);
        saveSelectOffline = (Button) findViewById(R.id.selectOffline);
        muDb = new OfflineDataBase(this);

        selectLine1.setVisibility(View.INVISIBLE);
        selectLine2.setVisibility(View.INVISIBLE);
        paal.setVisibility(View.INVISIBLE);
        athikaaram.setVisibility(View.INVISIBLE);
        saveSelectOffline.setVisibility(View.INVISIBLE);


        String paalValue;
        String athikaaramValue;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                kuNo = 0;
                paalValue = null;
                athikaaramValue = null;

            } else {

                kuNo = extras.getInt("value");
                paalValue = extras.getString("paal");
                athikaaramValue = extras.getString("athikaaram");
            }
        } else {
            kuNo = (int) savedInstanceState.getSerializable("value");
            paalValue = (String) savedInstanceState.getSerializable("paal");
            athikaaramValue = (String) savedInstanceState.getSerializable("athikaaram");
        }

        if (internet_connection()){

            selectLine1.setVisibility(View.VISIBLE);
            selectLine2.setVisibility(View.VISIBLE);
            paal.setVisibility(View.VISIBLE);
            athikaaram.setVisibility(View.VISIBLE);
            saveSelectOffline.setVisibility(View.VISIBLE);

            paal.setText("பால் : " + paalValue);
            athikaaram.setText("அதிகாரம் : " + athikaaramValue);

            KuralSelect.DownloadTask task = new KuralSelect.DownloadTask();
            task.execute("https://getthirukkural.appspot.com/api/2.0/kural/" +kuNo+ "?appid=vtzhxktz2hhiu&format=json");

        }else {

            Toast.makeText(KuralSelect.this , "No Internet Connection" , Toast.LENGTH_LONG).show();
        }


    }
    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1) {

                    char current = (char) data;

                    result += current;

                    data = reader.read();

                }
                Log.i("Url Content" , result);

                return result;

            } catch (Exception e) {

                Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_LONG);

            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {

                String message = "";

                JSONObject jsonObject = new JSONObject(result);

                String kuralInfo = jsonObject.getString("KuralSet");

                Log.i("Url", kuralInfo);

                JSONObject kural = new JSONObject(kuralInfo);

                String kuralSet = kural.getString("Kural");
                Log.i("line1" , kuralSet);
                JSONArray arr = new JSONArray(kuralSet);

                for (int i = 0; i < arr.length(); i++) {

                    JSONObject jsonPart = arr.getJSONObject(i);


                    Line1 = jsonPart.getString("Line1");
                    Line2 = jsonPart.getString("Line2");
                    trans = jsonPart.getString("Translation");



                    selectLine1.setText(Line1);
                    selectLine2.setText(Line2);

                }



            } catch (JSONException e) {

                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG);

            }


        }
    }
}
