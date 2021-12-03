package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //初始化Activity
        super.onCreate(savedInstanceState);
        //連接activity_main.xml畫面
        setContentView(R.layout.activity_main);
        //連接Button元件
        Button button=findViewById(R.id.button);
        //Button點擊事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MyService.class);
                //啟動Service
                startService(intent);
                Toast.makeText(MainActivity.this, "啟動SERVICE", Toast.LENGTH_SHORT).show();
                //關閉Activity
                finish();
            }
        });
    }
}