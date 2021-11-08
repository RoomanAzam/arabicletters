package com.example.arabicletters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class learn_letters extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_letters);
    }

    public void mess(View v) {
        //initialize image view object
        ImageView im=(ImageView)findViewById(R.id.imageView1);
        //get clicked button id from view object
        switch(v.getId())
        {
            case R.id.button:
                //if button1 is clicked than set image1
                im.setImageResource(R.drawable.throat);
                break;
            case R.id.button2:
                //if button2 is clicked than set image2
                im.setImageResource(R.drawable.toungbase);
                break;
            case R.id.button3:
                //if button1 is clicked than set image1
                im.setImageResource(R.drawable.btteeth);
                break;
            case R.id.button4:
                //if button2 is clicked than set image2
                im.setImageResource(R.drawable.first2teeth);
                break;
            case R.id.button5:
                //if button1 is clicked than set image1
                im.setImageResource(R.drawable.nose);
                break;
            case R.id.button6:
                //if button2 is clicked than set image2
                im.setImageResource(R.drawable.tounground);
                break;
            case R.id.button7:
                //if button1 is clicked than set image1
                im.setImageResource(R.drawable.toungtip);
                break;
            case R.id.button8:
                //if button2 is clicked than set image2
                im.setImageResource(R.drawable.toungup);
                break;
        }
    }
}