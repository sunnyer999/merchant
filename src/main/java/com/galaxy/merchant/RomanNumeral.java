package main.java.com.galaxy.merchant;

import main.java.com.galaxy.merchant.exception.TranslatorException;

import java.util.HashMap;

/**
 * <p>Roman Numeral class</p>
 *
 * @author Qihan.Luo
 */
public class RomanNumeral {
    private static final HashMap<Character, Integer> romanSymbols = new HashMap<>();
    private static final String PATTERN_ROMAN = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";


    /* Roman symbol and value */
    static {
        romanSymbols.put('I', 1);
        romanSymbols.put('V', 5);
        romanSymbols.put('X', 10);
        romanSymbols.put('L', 50);
        romanSymbols.put('C', 100);
        romanSymbols.put('D', 500);
        romanSymbols.put('M', 1000);
    }

    /**
     * <p>Convert roman number to decimal</p>
     *
     * @param romanNumber Ex: "VII"
     * @return int Ex: 7
     * @throws TranslatorException if invalid roman number format
     */
    public static int toDecimal(String romanNumber) throws TranslatorException {
        if (!isValid(romanNumber)) {
            throw new TranslatorException("Invalid roman number: " + romanNumber);
        }

        int result = 0, len = romanNumber.length();
        for (int i = 0; i < len - 1; i++) {
            if (romanSymbols.get(romanNumber.charAt(i)) < romanSymbols.get(romanNumber.charAt(i + 1))) {
                result -= romanSymbols.get(romanNumber.charAt(i));
            } else {
                result += romanSymbols.get(romanNumber.charAt(i));
            }
        }

        return result + romanSymbols.get(romanNumber.charAt(len - 1));
    }

    /**
     * <p>validate roman number format</p>
     *
     * @param romanNumber String
     * @return boolean
     */
    private static boolean isValid(String romanNumber) {
        return romanNumber.matches(PATTERN_ROMAN);
    }

}
