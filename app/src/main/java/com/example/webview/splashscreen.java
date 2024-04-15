package com.example.webview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashscreen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txt = findViewById(R.id.txtview);

        new Handler().postAtTime(new Runnable() {
            @Override
            public void run() {
                SharedPreferences shared = getSharedPreferences("Name",MODE_PRIVATE);
                Boolean bol = shared.getBoolean("flag", false);

                Intent inext;

                if(bol)
                {
                    inext = new Intent(splashscreen.this,MainActivity);
                }
            }
        },400);


    }
}