package validator.tests;

import org.junit.jupiter.api.Test;
import validator.utils.PasswordValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PasswordValidatorTest {
    @Test
    void testValidPassword(){
        assertTrue(PasswordValidator.isStrong("Qwerty0!"));
        assertTrue(PasswordValidator.isStrong("Qwerty0?"));
        assertTrue(PasswordValidator.isStrong("Qwerty0@"));
        assertTrue(PasswordValidator.isStrong("Qwerty0#"));

        assertTrue(PasswordValidator.isStrong("A1b2c3d!"));
        assertTrue(PasswordValidator.isStrong("A1b2c3d4e5f6g7h8i9J!"));
    }

    @Test
    void testSymbolsLessThan8(){
        //TODO
        // Меньше 8 символов, но по составу подходящие (буквы, цифра, спецсимвол)
        assertFalse(PasswordValidator.isStrong("Qwert0!"));  // 7 символов
    }

    @Test
    void testInvalidSpecSymbol(){
        assertFalse(PasswordValidator.isStrong("Qwerty0 "));
        assertFalse(PasswordValidator.isStrong("Qwe^rty0"));
        assertFalse(PasswordValidator.isStrong("~Qwerty0"));
    }

    @Test
    void testNoUppercase() {
        // Пароль содержит строчные, цифру, спецсимвол, но нет заглавной буквы
        assertFalse(PasswordValidator.isStrong("qwerty2!"));
    }

}