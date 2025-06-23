package validator.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import validator.utils.PasswordValidator;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    static PasswordValidator validator;

    @BeforeAll
    static void setUpAll() {
        validator = new PasswordValidator();
    }

    @Test
    void testValidPassword() {
        assertTrue(validator.isStrong("Qwerty0!"));
        assertTrue(validator.isStrong("Qwerty0?"));
        assertTrue(validator.isStrong("Qwerty0@"));
        assertTrue(validator.isStrong("Qwerty0#"));
    }

    @Test
    void testSymbolsLessThan8() {
        assertFalse(validator.isStrong("Qwert0!"));
    }

    @Test
    void testInvalidSpecSymbol() {
        assertFalse(validator.isStrong("Qwerty0 "));
        assertFalse(validator.isStrong("Qwe^rty0"));
        assertFalse(validator.isStrong("~Qwerty0"));
    }

    @Test
    void testNoUpperCase() {
        assertFalse(validator.isStrong("qwerty2!"));
    }

    @Test
    void testNoLowerCase() {
        assertFalse(validator.isStrong("QWERTY2!"));
    }

    @Test
    void testNoDigit() {
        assertFalse(validator.isStrong("Qwerty!!"));
    }

    @Test
    void testNull() {
        assertFalse(validator.isStrong(null));
    }
}
