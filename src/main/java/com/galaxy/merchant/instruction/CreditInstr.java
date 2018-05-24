package main.java.com.galaxy.merchant.instruction;

import main.java.com.galaxy.merchant.RomanNumeral;
import main.java.com.galaxy.merchant.Translator;
import main.java.com.galaxy.merchant.exception.TranslatorException;

import java.util.HashMap;

/**
 * <p>Credit Instruction class</p>
 *
 * @author Qihan.Luo
 */
public class CreditInstr implements Instruction {
    private final String content;

    public CreditInstr(String content) {
        this.content = content;
    }

    /**
     * <p>Convert the sentence semantic to execute credit instruction</p>
     *
     * @param translator Translator Class
     * @return String
     */
    @Override
    public String execute(Translator translator) throws TranslatorException {
        HashMap<String, Double> creditsMap = translator.getCreditsMap();
        HashMap<String, String> assignedMap = translator.getAssignedMap();
        // Split the sentence Ex: "glob glob Silver is 34 Credits" -> ["glob glob Silver", "34"]
        String[] expressions = this.content.trim().split("\\s+is\\s+");
        String[] galaxyMaterials = expressions[0].split("\\s+");

        // Get roman numbers from content
        StringBuilder romanNumber = new StringBuilder();
        for (int i = 0; i < galaxyMaterials.length - 1; i++) {
            String galaxySymbol = galaxyMaterials[i];
            if (assignedMap.containsKey(galaxySymbol)) {
                romanNumber.append(assignedMap.get(galaxySymbol));
            } else {
                throw new TranslatorException("Sorry! Cannot find corresponding galaxy Symbol: " + galaxySymbol);
            }
        }
        int quantity = RomanNumeral.toDecimal(romanNumber.toString());

        // Get galaxy material's type from content
        String materialsType = galaxyMaterials[galaxyMaterials.length - 1];

        String credits = expressions[1].split("\\s+")[0];
        Double creditsAmount = Double.parseDouble(credits);

        // Calculate credits unit of specific galaxy material type
        Double creditsUnit = creditsAmount / quantity;
        creditsMap.put(materialsType, creditsUnit);

        return "";
    }

}
