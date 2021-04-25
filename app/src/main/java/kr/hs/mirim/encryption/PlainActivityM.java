//3104 김민경
package kr.hs.mirim.encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlainActivityM extends AppCompatActivity {
    //암호화 메인
    
    EditText keyEdt;
    EditText plainEdt;
    Button toProcess;

    static String keyP = "";
    static String plain = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plain_m);

        keyEdt = findViewById(R.id.keyEdt);
        plainEdt = findViewById(R.id.plainEdt);
        toProcess = findViewById(R.id.toProcess);

        toProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyP = keyEdt.getText().toString().trim();
                plain = plainEdt.getText().toString().trim();
                if(keyP.isEmpty() || plain.isEmpty()){
                    Toast.makeText(getApplicationContext(), "암호키와 암호문을 적어주세요!", Toast.LENGTH_SHORT).show();
                }else{
                    toProcess();
                }
            }
        });
    }

    public void toProcess(){
        Intent intent = new Intent(this, PlainActivityP.class);
        startActivity(intent);
    }
}
