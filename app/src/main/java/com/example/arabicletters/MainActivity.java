package com.example.arabicletters;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.textView7);
        button.setOnClickListener(new View.OnClickListener() {


                                      @Override
                                      public void onClick(View v) {
                                          openNewActivity();
                                      }
                                  });

                button = (Button) findViewById(R.id.textView8);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                opentestActivity();
            }



    });}
    public void openNewActivity(){
        Intent intent = new Intent(this, learn_letters.class);
        startActivity(intent);
    }
        public void opentestActivity(){
            Intent intent = new Intent(this, practivepage.class);
            startActivity(intent);
        }

}