package kr.hs.mirim.encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView toPlain;
    ImageView toCiper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toPlain = findViewById(R.id.toPlain);
        toCiper = findViewById(R.id.toCiper);

        toPlain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPlainA();
            }
        });
        toCiper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toCiperA();
            }
        });

    }

    public void toCiperA(){
        Intent intent = new Intent(this, PlainActivityM.class);
        startActivity(intent);
    }
    public void toPlainA() {
        Intent intent = new Intent(this, CiperActivityM.class);
        startActivity(intent);
    }
}