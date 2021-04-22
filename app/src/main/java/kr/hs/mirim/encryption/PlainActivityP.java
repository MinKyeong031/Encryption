package kr.hs.mirim.encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static kr.hs.mirim.encryption.PlainActivityM.keyP;
import static kr.hs.mirim.encryption.PlainActivityM.plain;

public class PlainActivityP extends AppCompatActivity {
    //암호화 과정
    public static char alphabetBoard[][] = new char[5][5];
    public static boolean oddFlag = false; //글자수 출력

    ImageView goHome;
    TextView ciper1;
    TextView ciper2;
    TextView ciper3;
    TextView ciper4;
    TextView ciper5;
    TextView ciper6;
    TextView ciper7;
    TextView ciper8;
    TextView ciper9;
    TextView ciper10;
    TextView ciper11;
    TextView ciper12;
    TextView ciper13;
    TextView ciper14;
    TextView ciper15;
    TextView ciper16;
    TextView ciper17;
    TextView ciper18;
    TextView ciper19;
    TextView ciper20;
    TextView ciper21;
    TextView ciper22;
    TextView ciper23;
    TextView ciper24;
    TextView ciper25;
    TextView process;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plain_p);

        goHome = findViewById(R.id.goHome);
        ciper1 = findViewById(R.id.ciper1);
        ciper2 = findViewById(R.id.ciper2);
        ciper3 = findViewById(R.id.ciper3);
        ciper4 = findViewById(R.id.ciper4);
        ciper5 = findViewById(R.id.ciper5);
        ciper6 = findViewById(R.id.ciper6);
        ciper7 = findViewById(R.id.ciper7);
        ciper8 = findViewById(R.id.ciper8);
        ciper9 = findViewById(R.id.ciper9);
        ciper10 = findViewById(R.id.ciper10);
        ciper11 = findViewById(R.id.ciper11);
        ciper12 = findViewById(R.id.ciper12);
        ciper13 = findViewById(R.id.ciper13);
        ciper14 = findViewById(R.id.ciper14);
        ciper15 = findViewById(R.id.ciper15);
        ciper16 = findViewById(R.id.ciper16);
        ciper17 = findViewById(R.id.ciper17);
        ciper18 = findViewById(R.id.ciper18);
        ciper19 = findViewById(R.id.ciper19);
        ciper20 = findViewById(R.id.ciper20);
        ciper21 = findViewById(R.id.ciper21);
        ciper22 = findViewById(R.id.ciper22);
        ciper23 = findViewById(R.id.ciper23);
        ciper24 = findViewById(R.id.ciper24);
        ciper25 = findViewById(R.id.ciper25);
        process = findViewById(R.id.process_ciper);
        result = findViewById(R.id.result);

        String[][] ciperTable = Methods.setBoard(keyP, alphabetBoard); //암호판 배열 입력
        inputCiperTable(ciperTable); //테이블에 암호판 입력

        String zCheck = "";
        String blankCheck = "";

        for( int i = 0 ; i < plain.length() ; i++ )
        {
            if(plain.charAt(i)==' ') //공백제거
            {
                plain = plain.substring(0,i)+plain.substring(i+1,plain.length());
                blankCheck+=10;
            }
            else {   blankCheck+=0; }
            if(plain.charAt(i)=='z') //z를 q로 바꿔줘서 처리함.
            {
                plain = plain.substring(0,i)+'q'+plain.substring(i+1,plain.length());
                zCheck+=1;
            }
            else{   zCheck+=0; }
        }

        process.setText(encryptionProcess(plain)); //암호화 과정
        result.setText(encryptionResult(plain)); //암호화된 문자열

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHomeA();
            }
        }); //메인 메뉴로 이동
    }

    private void goHomeA() {//메인 메뉴로 이동
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private String encryptionProcess(String plain) {//암호화 과정(두 문자씩)
        ArrayList<char[]> playFair = new ArrayList<char[]>();
        String prociper = "";

        for( int i = 0 ; i < plain.length() ; i+=2 ) // arraylist 세팅
        {
            char[] tmpArr = new char[2];
            tmpArr[0] = plain.charAt(i);
            try{
                if( plain.charAt(i) == plain.charAt(i+1)) //글이 반복되면 x추가
                {
                    tmpArr[1] = 'x';
                    i--;
                }else{
                    tmpArr[1] = plain.charAt(i+1);
                }
            }catch(StringIndexOutOfBoundsException e)
            {
                tmpArr[1] = 'x';
                oddFlag = true;
            }
            playFair.add(tmpArr);
        }

        for(int i = 0 ; i < playFair.size() ; i++ )
        {
            prociper += playFair.get(i)[0]+""+playFair.get(i)[1]+" ";
        }
        return prociper;
    }

    private String encryptionResult(String plain) {//암호화 결과
        ArrayList<char[]> playFair = new ArrayList<char[]>();
        ArrayList<char[]> encPlayFair = new ArrayList<char[]>();
        int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0;
        String enplain ="";

        for( int i = 0 ; i < plain.length() ; i+=2 ) // arraylist 세팅
        {
            char[] tmpArr = new char[2];
            tmpArr[0] = plain.charAt(i);
            try{
                if( plain.charAt(i) == plain.charAt(i+1)) //글이 반복되면 x추가
                {
                    tmpArr[1] = 'x';
                    i--;
                }else{
                    tmpArr[1] = plain.charAt(i+1);
                }
            }catch(StringIndexOutOfBoundsException e)
            {
                tmpArr[1] = 'x';
                oddFlag = true;
            }
            playFair.add(tmpArr);
        }
        for(int i = 0 ; i < playFair.size() ; i++ )
        {
            char[] tmpArr = new char[2];
            for( int j = 0 ; j < alphabetBoard.length ; j++ ) //쌍자암호의 각각 위치체크
            {
                for( int k = 0 ; k < alphabetBoard[j].length ; k++ )
                {
                    if(alphabetBoard[j][k] == playFair.get(i)[0])
                    {
                        x1 = j;
                        y1 = k;
                    }
                    if(alphabetBoard[j][k] == playFair.get(i)[1])
                    {
                        x2 = j;
                        y2 = k;
                    }
                }
            }

            if(x1==x2) //행이 같은경우
            {
                tmpArr[0] = alphabetBoard[x1][(y1+1)%5];
                tmpArr[1] = alphabetBoard[x2][(y2+1)%5];
            }
            else if(y1==y2) //열이 같은 경우
            {
                tmpArr[0] = alphabetBoard[(x1+1)%5][y1];
                tmpArr[1] = alphabetBoard[(x2+1)%5][y2];
            }
            else //행, 열 모두 다른경우
            {
                tmpArr[0] = alphabetBoard[x2][y1];
                tmpArr[1] = alphabetBoard[x1][y2];
            }
            encPlayFair.add(tmpArr);
        }

        for(int i = 0 ; i < encPlayFair.size() ; i++)
        {
            enplain += encPlayFair.get(i)[0]+""+encPlayFair.get(i)[1]+" ";
        }
        return enplain;
    }

    private void inputCiperTable(String[][] ciperTable) { //테이블에 암호판 입력
        ciper1.setText(ciperTable[0][0]);
        ciper2.setText(ciperTable[0][1]);
        ciper3.setText(ciperTable[0][2]);
        ciper4.setText(ciperTable[0][3]);
        ciper5.setText(ciperTable[0][4]);
        ciper6.setText(ciperTable[1][0]);
        ciper7.setText(ciperTable[1][1]);
        ciper8.setText(ciperTable[1][2]);
        ciper9.setText(ciperTable[1][3]);
        ciper10.setText(ciperTable[1][4]);
        ciper11.setText(ciperTable[2][0]);
        ciper12.setText(ciperTable[2][1]);
        ciper13.setText(ciperTable[2][2]);
        ciper14.setText(ciperTable[2][3]);
        ciper15.setText(ciperTable[2][4]);
        ciper16.setText(ciperTable[3][0]);
        ciper17.setText(ciperTable[3][1]);
        ciper18.setText(ciperTable[3][2]);
        ciper19.setText(ciperTable[3][3]);
        ciper20.setText(ciperTable[3][4]);
        ciper21.setText(ciperTable[4][0]);
        ciper22.setText(ciperTable[4][1]);
        ciper23.setText(ciperTable[4][2]);
        ciper24.setText(ciperTable[4][3]);
        ciper25.setText(ciperTable[4][4]);
    }
}