package com.example.expcustombrodcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
MyReceiver MR = new MyReceiver();
    LocalBroadcastManager LB;
    Button btn;
    EditText     txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Log.i("aa","jgjgj");

        btn=(Button) findViewById(R.id.btnTester);
        txt=(EditText) findViewById(R.id.txtNombre);
        txt.setText("4");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nbr= Integer.parseInt( txt.getText().toString());
                if (nbr< 10)

                {
                    Intent intent = new Intent("MyFilter1");
                    intent.putExtra("test",String.valueOf(nbr));
                    LB.sendBroadcast(intent);
                    Log.i("aa", "send");



                }






                //intent.putExtra("key", "My Data");
                // put your all data using put extra


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("aa", "avant register");
        LB =LocalBroadcastManager.getInstance(this);
        LB.registerReceiver(MR,new IntentFilter("MyFilter1"));




    }

    @Override
    protected void onDestroy() {


    LB.unregisterReceiver(MR);

        super.onDestroy();
    }
}