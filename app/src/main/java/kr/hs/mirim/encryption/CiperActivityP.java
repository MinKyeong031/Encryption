package kr.hs.mirim.encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import static kr.hs.mirim.encryption.CiperActivityM.keyC;
import static kr.hs.mirim.encryption.CiperActivityM.ciper;

public class CiperActivityP extends AppCompatActivity {

    ImageView goHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciper_p);

        goHome = findViewById(R.id.goHome);

        ArrayList<String> distinctKeyC = Methods.distinct(keyC.split(""));

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
