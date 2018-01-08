package com.example.anton.techy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.anton.techy.MainNews.MainNewsActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private LinearLayout mTestActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        mTestActivity = (LinearLayout) findViewById(R.id.test_layout);

        TextView theVerge = (TextView) findViewById(R.id.theverge);

        theVerge.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, MainNewsActivity.class);
                startActivity(intent);
            }
        });



    }

}
