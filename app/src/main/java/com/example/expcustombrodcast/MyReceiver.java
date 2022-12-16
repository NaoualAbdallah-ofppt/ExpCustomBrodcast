package com.example.expcustombrodcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (intentAction=="MyFilter1"){

                Log.i("aa", intent.getStringExtra("test"));
                   }

    }
}