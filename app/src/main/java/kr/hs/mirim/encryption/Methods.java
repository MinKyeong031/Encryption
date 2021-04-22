package kr.hs.mirim.encryption;

import android.widget.TextView;

import java.util.ArrayList;

import static kr.hs.mirim.encryption.CiperActivityM.ciper;

public class Methods { //공통으로 사용되는 메서드 정리
    public static String[][] setBoard(String key, char alphabetBoard[][]) {//암호화 과정(테이블)
        String keyForSet = "";					        // 중복된 문자가 제거된 문자열을 저장할 문자열.
        boolean duplicationFlag = false;	        	// 문자 중복을 체크하기 위한 flag 변수.
        int keyLengthCount = 0;				        	// alphabetBoard에 keyForSet을 넣기 위한 count변수.
        String[][] ciperTable = new String[5][5];       //리턴할 배열

        key += "abcdefghijklmnopqrstuvwxyz"; 	// 키에 모든 알파벳을 추가.


        // 중복처리
        for( int i = 0 ; i < key.length() ; i++ )
        {
            for( int j = 0 ; j < keyForSet.length() ; j++ )
            {
                if(key.charAt(i)==keyForSet.charAt(j))
                {
                    duplicationFlag = true;
                    break;
                }
            }
            if(!(duplicationFlag)) keyForSet += key.charAt(i);
            duplicationFlag = false;
        }
        //배열에 대입
        for( int i = 0 ; i < alphabetBoard.length ; i++ )
        {
            for( int j = 0; j <alphabetBoard[i].length ; j++ )
            {
                alphabetBoard[i][j] = keyForSet.charAt(keyLengthCount++);
            }
        }

        //암호판 배열에 대입
        for( int i = 0 ; i < alphabetBoard.length ; i++ )
        {
            for( int j = 0; j <alphabetBoard[i].length ; j++ )
            {
                if(alphabetBoard[i][j] == 'q'){
                    ciperTable[i][j] = String.valueOf(alphabetBoard[i][j]) + "/z";
                }else{
                    ciperTable[i][j] = String.valueOf(alphabetBoard[i][j]);
                }
            }
        }

        return ciperTable;
    }

    public static void inputCiperTable(String[][] ciperTable, TextView ciper1, TextView ciper2, TextView ciper3, TextView ciper4, TextView ciper5
            , TextView ciper6, TextView ciper7, TextView ciper8, TextView ciper9, TextView ciper10, TextView ciper11, TextView ciper12, TextView ciper13
            , TextView ciper14, TextView ciper15, TextView ciper16, TextView ciper17, TextView ciper18, TextView ciper19, TextView ciper20, TextView ciper21
            , TextView ciper22, TextView ciper23, TextView ciper24, TextView ciper25) { //테이블에 암호판 입력
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
