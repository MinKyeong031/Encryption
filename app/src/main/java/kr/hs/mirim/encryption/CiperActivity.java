//3104 김민경
package kr.hs.mirim.encryption;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class CiperActivity extends AppCompatActivity {
    //복호화 과정
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
    static String key;
    static String ciper;
    static String blank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciper_p);

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
        process = findViewById(R.id.process_plain);
        result = findViewById(R.id.result);
        String ciperresult;

        String[][] ciperTable = Methods.setBoard(key, alphabetBoard); //암호판 배열 입력
        Methods.inputCiperTable(ciperTable, ciper1, ciper2, ciper3, ciper4, ciper5, ciper6, ciper7, ciper8, ciper9, ciper10, ciper11, ciper12, ciper13
                , ciper14, ciper15, ciper16, ciper17, ciper18, ciper19, ciper20, ciper21, ciper22, ciper23, ciper24, ciper25); //테이블에 암호판 입력

        ciperresult = decryptionResult(ciper);

        for( int i = 0 ; i < ciperresult.length() ; i++)//공백 제거
        {
            if(blank.charAt(i)=='1')
            {
                ciperresult = ciperresult.substring(0,i)+" "+ciperresult.substring(i,ciperresult.length());
            }
        }

        process.setText(decryptionProcess(ciper)); //암호화 과정
        result.setText(ciperresult); //암호화된 문자열

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

    private String decryptionProcess(String ciper) {//복호화 과정(두 문자씩)
        ArrayList<char[]> playFair = new ArrayList<char[]>();
        String prociper = "";

        for( int i = 0 ; i < ciper.length() ; i+=2 ) // arraylist 세팅
        {
            char[] tmpArr = new char[2];
            tmpArr[0] = ciper.charAt(i);
            try{
                if( ciper.charAt(i) == ciper.charAt(i+1)) //글이 반복되면 x추가
                {
                    tmpArr[1] = 'x';
                    i--;
                }else{
                    tmpArr[1] = ciper.charAt(i+1);
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

    private String decryptionResult(String ciper) {//복호화 결과
        ArrayList<char[]> playFair = new ArrayList<char[]>(); //바꾸기 전 쌍자암호를 저장할 곳
        ArrayList<char[]> decPlayFair = new ArrayList<char[]>(); //바꾼 후의 쌍자암호 저장할 곳
        int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0; //쌍자 암호 두 글자의 각각의 행,열 값
        String deciper ="";

        for( int i = 0 ; i < ciper.length() ; i+=2 )
        {
            char[] tmpArr = new char[2];
            tmpArr[0] = ciper.charAt(i);
            tmpArr[1] = ciper.charAt(i+1);
            playFair.add(tmpArr);
        }

        for(int i = 0 ; i < playFair.size() ; i++ )
        {
            char[] tmpArr = new char[2];
            for( int j = 0 ; j < alphabetBoard.length ; j++ )
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
            if(x1==x2) //행이 같은 경우 각각 바로 아래열 대입
            {
                tmpArr[0] = alphabetBoard[x1][(y1+4)%5];
                tmpArr[1] = alphabetBoard[x2][(y2+4)%5];
            }
            else if(y1==y2) //열이 같은 경우 각각 바로 옆 열 대입
            {
                tmpArr[0] = alphabetBoard[(x1+4)%5][y1];
                tmpArr[1] = alphabetBoard[(x2+4)%5][y2];
            }
            else //행, 열 다른경우 각자 대각선에 있는 곳.
            {
                tmpArr[0] = alphabetBoard[x2][y1];
                tmpArr[1] = alphabetBoard[x1][y2];
            }
            decPlayFair.add(tmpArr);
        }
        for(int i = 0 ; i < decPlayFair.size() ; i++) //중복 문자열 돌려놓음
        {
            if(i!=decPlayFair.size()-1 && decPlayFair.get(i)[1]=='x'
                    && decPlayFair.get(i)[0]==decPlayFair.get(i+1)[0])
            {
                deciper += decPlayFair.get(i)[0];
            }
            else
            {
                deciper += decPlayFair.get(i)[0]+""+decPlayFair.get(i)[1];
            }
        }
        return deciper;
    }
}