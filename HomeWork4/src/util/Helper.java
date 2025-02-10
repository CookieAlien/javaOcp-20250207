package util;

import java.util.regex.Pattern;

public class Helper {
	 // 驗證帳號 (6~16位英文數字，首字不能為數字)
    public static boolean validateUsername(String username) {
        return Pattern.matches("^[A-Za-z][A-Za-z0-9]{5,15}$", username);
    }

    // 驗證密碼 (6~20位，須包含英文大小寫和數字)
    public static boolean validatePassword(String password) {
        return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{6,20}$", password);
    }

    // 驗證姓名 (2~16位中英文字)
    public static boolean validateName(String name) {
        return Pattern.matches("^[\u4e00-\u9fa5A-Za-z]{2,16}$", name);
    }

    // 驗證電子郵件 (須為電郵格式)
    public static boolean validateEmail(String email) {
        return Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", email);
    }

    // 驗證手機號碼 (09開頭的10位數字)
    public static boolean validatePhoneNumber(String phoneNumber) {
        return Pattern.matches("^09\\d{8}$", phoneNumber);
    }
}
