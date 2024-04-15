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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences shared = getSharedPreferences("Name",MODE_PRIVATE);
                Boolean bol = shared.getBoolean("flag", false);

                System.out.println("ayush 1 --> "+ bol);


                Intent inext;
                if(bol)
                {
                    System.out.println("ayush 11 --> "+ bol);
                    inext = new Intent(splashscreen.this, MainActivity.class); }

                else
                {
                    System.out.println("ayush 12 --> "+ bol);
                    inext = new Intent(splashscreen.this, loginactivity.class); }

                startActivity(inext);
                finish();

            }
        },500);

    }
}