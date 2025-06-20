package validator.utils;

public class PasswordValidator {
    public static boolean isStrong(String password) {
        if (password == null) return false;
        int length = password.length();
        if (length < 8 || length > 20) return false;

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()-_+=";

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (specialChars.indexOf(c) >= 0) hasSpecial = true;
            else return false; // запрещённый символ
        }

        return hasLower && hasUpper && hasDigit && hasSpecial;
    }
}
