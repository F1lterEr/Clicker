package com.example.clicker;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double countlife = 0;
    int life = 1;
    double xx=100;
    int life2 = life;
    double X = 1;

    Button kill_butt, CHeats;
    TextView textlife, Xfactor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kill_butt = (Button)findViewById(R.id.kill_butt);
        textlife = (TextView)findViewById(R.id.life);
        Xfactor = (TextView)findViewById(R.id.xfactor);
        CHeats = (Button)findViewById(R.id.Cheats);
        Kill_butt();
        Cheats_butt();
        Log.d(TAG, "onCreate");
    }

    void Kill_butt(){
        kill_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countlife == xx) {
                    X += 1;
                    xx*=5;
                    life2 += 1;

                }
                countlife += life2;
                textlife.setText("Монеты: "+countlife);
                Xfactor.setText("Скорость: "+X);
            }});
        Log.d(TAG, "onClick");
    }
    void Cheats_butt(){
        CHeats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                X += 999;
                life2 += 999;
                countlife += life2;
                textlife.setText("Монеты: "+countlife);
                Xfactor.setText("Скорость: "+X);
                Log.d(TAG, "onClick");
            }
        });
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", (int) countlife);
        Log.d(TAG, "onSaveInstanceState");
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        countlife = savedInstanceState.getInt("count");
        Log.d(TAG, "onRestoreInstanceState");
    }
}
