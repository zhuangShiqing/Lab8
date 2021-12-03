package com.example.lab8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    @Override
    public void onCreate(){
        super.onCreate();
        //使用Thread來模擬執行耗時任務
        new Thread(new Runnable(){
            @Override
            public void run() {
                try{
                    //延遲5秒
                    Thread.sleep(5000);
                    Intent intent=new Intent(MyService.this,Main2Activity.class);
                    //Service要啟動Activity要加入Flag定義一個新任務去產生Activity
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //啟動Main2Activity
                    MyService.this.startActivity(intent);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
        stopSelf();
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        super.onStartCommand(intent, flags, startId);
        //Service被結束時會重啟並清空Intent
        return START_STICKY;
    }

    @Override
    public void onDestroy(){super.onDestroy();}

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}