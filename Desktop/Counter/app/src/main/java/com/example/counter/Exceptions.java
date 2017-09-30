package com.example.counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exceptions extends AppCompatActivity {
    private TextView warning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);

        warning = (TextView)findViewById(R.id.activity);
        Button Back = (Button) findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent backToMain = new Intent(Exceptions.this, MainActivity.class);
                startActivity(backToMain);
            }

        });
    }
}
