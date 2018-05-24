package main.java.com.galaxy.merchant.instruction;

import main.java.com.galaxy.merchant.RomanNumeral;
import main.java.com.galaxy.merchant.Translator;
import main.java.com.galaxy.merchant.exception.TranslatorException;

import java.util.HashMap;

/**
 * <p>How Much Instruction class</p>
 *
 * @author Qihan.Luo
 */
public class HowMuchInstr implements Instruction {
    private final String content;

    public HowMuchInstr(String content) {
        this.content = content;
    }

    /**
     * <p>Convert the sentence semantic to execute how-much instruction</p>
     *
     * @param translator Translator
     * @return String
     * @throws TranslatorException if cannot find galaxy symbol.
     */
    @Override
    public String execute(Translator translator) throws TranslatorException {
        HashMap<String, String> assignedMap = translator.getAssignedMap();

        String[] expressions = this.content.replace("?", "").trim().split("\\s+is\\s+");
        String[] galaxyMaterials = expressions[1].split("\\s");

        // Convert galaxy symbols to roman numbers
        StringBuilder romanNumber = new StringBuilder();
        for (String galaxySymbol : galaxyMaterials) {
            if (assignedMap.containsKey(galaxySymbol)) {
                romanNumber.append(assignedMap.get(galaxySymbol));
            } else {
                throw new TranslatorException("Sorry! Cannot find galaxy symbol: " + galaxySymbol);
            }
        }

        int quantity = RomanNumeral.toDecimal(romanNumber.toString());
        return expressions[1] + " is " + quantity;
    }

}
