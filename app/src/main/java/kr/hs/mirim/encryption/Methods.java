package kr.hs.mirim.encryption;

import java.util.ArrayList;

import static kr.hs.mirim.encryption.CiperActivityM.ciper;

public class Methods {
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
}
