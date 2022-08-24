package com.example.threadsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txt;
Button btn;
private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txt);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText("button is clicked");

new Thread(new Runnable() {

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            Log.d("thread","thread activate");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler.post(new Runnable() {
            @Override
            public void run() {

//                    Thread.sleep(10000);

                    txt.setText("thread activate");
btn.setText("finished");
            }
        });

    }
}).start();

            }
        });
    }
}






