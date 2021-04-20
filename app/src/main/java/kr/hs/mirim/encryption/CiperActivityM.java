package kr.hs.mirim.encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CiperActivityM extends AppCompatActivity {

    Button toProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciper_m);

        toProcess = findViewById(R.id.toProcess);

        toProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toProcessA();
            }
        });
    }

    public void toProcessA(){
        Intent intent = new Intent(this, CiperActivityP.class);
        startActivity(intent);
    }
}
