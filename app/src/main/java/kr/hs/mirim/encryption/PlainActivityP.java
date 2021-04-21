package kr.hs.mirim.encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static kr.hs.mirim.encryption.PlainActivityM.keyP;
import static kr.hs.mirim.encryption.PlainActivityM.plain;

public class PlainActivityP extends AppCompatActivity {

    ImageView goHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plain_p);

        goHome = findViewById(R.id.goHome);

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHomeA();
            }
        });
    }

    public void goHomeA(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
