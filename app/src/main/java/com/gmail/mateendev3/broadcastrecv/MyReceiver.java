package com.gmail.mateendev3.broadcastrecv;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MYBRReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())) {
            Log.d(TAG, "onReceive: Power Connected");
            Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_TIMEZONE_CHANGED.equals(intent.getAction())) {
            Log.d(TAG, "onReceive: TimeZone Changed");
            Toast.makeText(context, "Timezone changed", Toast.LENGTH_SHORT).show();
        } else if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            Log.d(TAG, "onReceive: Connectivity changed");
            Intent intent1 = new Intent(context, SecondActivity.class);
            intent1.setFlags(FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }else if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            Toast.makeText(context, "Completed", Toast.LENGTH_SHORT).show();
        }
        else if (Intent.ACTION_LOCKED_BOOT_COMPLETED.equals(intent.getAction())){
            Toast.makeText(context, "locked Completed", Toast.LENGTH_SHORT).show();
        }
        else {
            Log.d(TAG, "onReceive: Power Disconnected");
            Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
        }
    }
}
