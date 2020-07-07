package com.noah.library.lib;

import java.util.regex.Pattern;

/**
 * 패턴 매니저
 */
public class Code_NoahPatternManager {


    /**
     * email을 체크한다.
     * id + @ + domain + . + domain2
     * @param email
     * @return
     */
    public static boolean emailTypeCheck(String email){
        if (email != null) {
            String pattern = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
            return Pattern.matches(pattern, email);
        }
        return false;
    }

    /**
     * 비밀번호를 체크한다.
     * 소영문 + 숫자 포함 8~20자
     * @param pass
     * @return
     */
    public static boolean passCheck(String pass){
        if (pass != null) {
            String pattern = "^(?=.*[a-z])(?=.*[0-9])[a-z[0-9]]{8,20}$";
            return Pattern.matches(pattern, pass);
        }
        return false;
    }


}
