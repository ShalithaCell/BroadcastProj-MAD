package com.example.broadcastproj;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class BackgroundServices extends IntentService {

    public BackgroundServices(){
        super("BackgroundServices");
    }

    public static void startAction(Context context){
        Intent intent= new Intent(context, BackgroundServices.class);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent != null){
            for(int i = 0; i < 5; i++){
                Intent localBroadcast = new Intent(MainActivity.BROADCAST_ACTION);
                localBroadcast.putExtra("value", "Broadcast" + (i + 1));
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                sendBroadcast(localBroadcast);
            }
        }
    }


}
