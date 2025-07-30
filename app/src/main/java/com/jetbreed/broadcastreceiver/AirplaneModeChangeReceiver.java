package com.jetbreed.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Handler handler = new Handler(Looper.getMainLooper());  // Use Looper.getMainLooper() for main thread
        long delayMillis = 10; // Delay in milliseconds (e.g., 2000ms = 2 seconds)

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isAirplaneModeOn(
                        context.getApplicationContext())) {
                    Toast.makeText(
                        context, "AirPlane mode is on",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(
                        context, "AirPlane mode is off",
                            Toast.LENGTH_LONG).show();
                }
            }
        }, delayMillis); // Toast will be shown after the specified delay
    }

    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}
