package com.dapeng_szz.cn.commons.util;

import java.util.Random;

public class AuthUtil {

    private static final String [] code={"a","b","c","d","e","f","g","h","i","j","k",
            "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E",
            "F","G","H","I","J","K","L","M","N","O","P","R","S","T","U","V","W","X","Y","Z"};

    public static String getAuthCode(){
        StringBuilder auth=new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int j = random.nextInt(26);
            auth.append(code[j]);
        }
        return auth.toString();
    }
}
