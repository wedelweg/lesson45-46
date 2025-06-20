package validator.tests;

import org.junit.jupiter.api.Test;
import validator.utils.PasswordValidator;
import static org.junit.jupiter.api.Assertions.*;

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
        assertFalse(PasswordValidator.isStrong("Qwert0!"));
    }

    @Test
    void testInvalidSpecSymbol(){
        assertFalse(PasswordValidator.isStrong("Qwerty0 "));
        assertFalse(PasswordValidator.isStrong("Qwe^rty0"));
        assertFalse(PasswordValidator.isStrong("~Qwerty0"));
    }

    @Test
    void testNoUppercase() {
        assertFalse(PasswordValidator.isStrong("qwerty2!"));
    }

    @Test
    void testNoLowercase() {
        assertFalse(PasswordValidator.isStrong("QWERTY2!"));
    }

    @Test
    void testNoDigit(){
        assertFalse(PasswordValidator.isStrong("Qwerty!!"));
    }

    @Test
    void testNull(){
        assertFalse(PasswordValidator.isStrong(null));
    }

    @Test
    void testEmptyString() {
        assertFalse(PasswordValidator.isStrong(""));
    }
}
