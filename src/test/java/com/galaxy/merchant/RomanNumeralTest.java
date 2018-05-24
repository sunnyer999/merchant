package test.java.com.galaxy.merchant;

import main.java.com.galaxy.merchant.RomanNumeral;
import main.java.com.galaxy.merchant.exception.TranslatorException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class RomanNumeralTest {

    @Test
    public void testRomanNumber() throws Exception {
        // Basic test cases
        assertEquals(RomanNumeral.toDecimal("I"), 1);
        assertEquals(RomanNumeral.toDecimal("V"), 5);
        assertEquals(RomanNumeral.toDecimal("X"), 10);
        assertEquals(RomanNumeral.toDecimal("L"), 50);
        assertEquals(RomanNumeral.toDecimal("C"), 100);
        assertEquals(RomanNumeral.toDecimal("D"), 500);
        assertEquals(RomanNumeral.toDecimal("M"), 1000);
        assertEquals(RomanNumeral.toDecimal("XII"), 12);
        assertEquals(RomanNumeral.toDecimal("XVI"), 16);
        assertEquals(RomanNumeral.toDecimal("XXIX"), 29);
        assertEquals(RomanNumeral.toDecimal("XLIV"), 44);
        assertEquals(RomanNumeral.toDecimal("XLV"), 45);
        assertEquals(RomanNumeral.toDecimal("LXVIII"), 68);
        assertEquals(RomanNumeral.toDecimal("LXXXIII"), 83);
        assertEquals(RomanNumeral.toDecimal("XCVII"), 97);
        assertEquals(RomanNumeral.toDecimal("XCIX"), 99);
        assertEquals(RomanNumeral.toDecimal("DI"), 501);
        assertEquals(RomanNumeral.toDecimal("DCXLIX"), 649);
        assertEquals(RomanNumeral.toDecimal("DCCXCVIII"), 798);
        assertEquals(RomanNumeral.toDecimal("DCCCXCI"), 891);
        assertEquals(RomanNumeral.toDecimal("MIV"), 1004);
        assertEquals(RomanNumeral.toDecimal("MVI"), 1006);
        assertEquals(RomanNumeral.toDecimal("MXXIII"), 1023);
        assertEquals(RomanNumeral.toDecimal("MCMIII"), 1903);
        assertEquals(RomanNumeral.toDecimal("MMXIV"), 2014);
        assertEquals(RomanNumeral.toDecimal("MMMCMXCIX"), 3999);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = TranslatorException.class)
    public void testEmptyInput() throws Exception {
        RomanNumeral.toDecimal("");
    }

    // Repeat Rules test cases
    @Test(expected = TranslatorException.class)
    public void testSuccessionForI() throws Exception {
        RomanNumeral.toDecimal("IIII");
    }

    @Test(expected = TranslatorException.class)
    public void testSuccessionForX() throws Exception {
        RomanNumeral.toDecimal("XXXX");
    }

    @Test(expected = TranslatorException.class)
    public void testSuccessionForC() throws Exception {
        RomanNumeral.toDecimal("CCCC");
    }

    @Test(expected = TranslatorException.class)
    public void testSuccessionForM() throws Exception {
        RomanNumeral.toDecimal("MMMM");
    }

    @Test(expected = TranslatorException.class)
    public void testOnlyD() throws Exception {
        RomanNumeral.toDecimal("DD");
    }

    @Test(expected = TranslatorException.class)
    public void testOnlyL() throws Exception {
        RomanNumeral.toDecimal("LL");
    }

    @Test(expected = TranslatorException.class)
    public void testOnlyV() throws Exception {
        RomanNumeral.toDecimal("VV");
    }

    // Subtraction rule test cases
    @Test()
    public void testSubRuleIV() throws Exception {
        assertEquals(RomanNumeral.toDecimal("IV"), 4);
    }

    @Test()
    public void testSubRuleIX() throws Exception {
        assertEquals(RomanNumeral.toDecimal("IX"), 9);
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleIL() throws Exception {
        RomanNumeral.toDecimal("IL");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleIC() throws Exception {
        RomanNumeral.toDecimal("IC");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleID() throws Exception {
        RomanNumeral.toDecimal("ID");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleIM() throws Exception {
        RomanNumeral.toDecimal("IM");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleVX() throws Exception {
        RomanNumeral.toDecimal("VX");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleVL() throws Exception {
        RomanNumeral.toDecimal("VL");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleVC() throws Exception {
        RomanNumeral.toDecimal("VC");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleVD() throws Exception {
        RomanNumeral.toDecimal("VD");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleVM() throws Exception {
        RomanNumeral.toDecimal("VM");
    }

    @Test()
    public void testSubRuleXL() throws Exception {
        assertEquals(RomanNumeral.toDecimal("XL"), 40);
    }

    @Test()
    public void testSubRuleXC() throws Exception {
        assertEquals(RomanNumeral.toDecimal("XC"), 90);
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleXD() throws Exception {
        RomanNumeral.toDecimal("XD");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleXM() throws Exception {
        RomanNumeral.toDecimal("XM");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleLC() throws Exception {
        RomanNumeral.toDecimal("LC");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleLD() throws Exception {
        RomanNumeral.toDecimal("LD");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleLM() throws Exception {
        RomanNumeral.toDecimal("LM");
    }

    @Test(expected = TranslatorException.class)
    public void testSubRuleDM() throws Exception {
        RomanNumeral.toDecimal("DM");
    }

}
