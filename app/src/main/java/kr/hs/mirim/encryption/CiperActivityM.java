package kr.hs.mirim.encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class CiperActivityM extends AppCompatActivity {
    //복호화 메인

    EditText keyEdt;
    EditText ciperEdt;
    Button toProcess;

    static String keyC = "";
    static String ciper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciper_m);

        keyEdt = findViewById(R.id.keyEdt);
        ciperEdt = findViewById(R.id.ciperEdt);
        toProcess = findViewById(R.id.toProcess);

        toProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyC = keyEdt.getText().toString().trim();
                ciper = ciperEdt.getText().toString().trim();
                toProcessA();
            }
        });
    }

    public void toProcessA(){
        Intent intent = new Intent(this, CiperActivityP.class);
        startActivity(intent);
    }
}
