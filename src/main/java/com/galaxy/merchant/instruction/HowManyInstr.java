package main.java.com.galaxy.merchant.instruction;

import main.java.com.galaxy.merchant.RomanNumeral;
import main.java.com.galaxy.merchant.Translator;
import main.java.com.galaxy.merchant.exception.TranslatorException;

import java.util.HashMap;

/**
 * <p>How Many Instruction class</p>
 *
 * @author Qihan.Luo
 */
public class HowManyInstr implements Instruction {
    private final String content;

    public HowManyInstr(String content) {
        this.content = content;
    }

    /**
     * <p>Convert the sentence semantic to execute how-many instruction</p>
     *
     * @param translator Translator class
     * @return String
     * @throws TranslatorException if not find the material type or not find galaxy symbol.
     */
    @Override
    public String execute(Translator translator) throws TranslatorException {
        HashMap<String, Double> creditsMap = translator.getCreditsMap();
        HashMap<String, String> assignedMap = translator.getAssignedMap();

        // Get substr of the sentence, Ex: "how many Credits is glob prok Silver ?" -> “glob prok Silver”
        String[] expressions = this.content.replace("?", "").trim().split("\\s+is\\s+");
        String[] galaxyMaterials = expressions[1].split("\\s");
        // Get roman number
        StringBuilder romanNumber = new StringBuilder();
        for (int i = 0; i < galaxyMaterials.length - 1; i++) {
            String galaxySymbol = galaxyMaterials[i];
            if (assignedMap.containsKey(galaxySymbol)) {
                romanNumber.append(assignedMap.get(galaxySymbol));
            } else {
                throw new TranslatorException("Sorry! Cannot find corresponding galaxy symbol: " + galaxySymbol);
            }
        }
        int quantity = RomanNumeral.toDecimal(romanNumber.toString());
        // Get material type
        String materialsType = galaxyMaterials[galaxyMaterials.length - 1];

        //Get credit Unit
        Double creditsUnit;
        if (creditsMap.containsKey(materialsType)) {
            creditsUnit = creditsMap.get(materialsType);
        } else {
            throw new TranslatorException("Sorry! Cannot find " + materialsType + "'s unit credits");
        }

        return expressions[1] + " is " + creditsUnit * quantity + " Credits";
    }

}
