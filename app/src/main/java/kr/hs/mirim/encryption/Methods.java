package kr.hs.mirim.encryption;

import java.util.ArrayList;

public class Methods {
    public static ArrayList<String> distinct(String[] keystr) {
        ArrayList<String> distinctKey = new ArrayList<String>();
        for(int i = 0; i < keystr.length; i++){
            if(!distinctKey.contains(keystr[i])){
                distinctKey.add(keystr[i]);
            }
        }
        return distinctKey;
    }

}
