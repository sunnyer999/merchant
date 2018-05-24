package main.java.com.galaxy.merchant.instruction;

import main.java.com.galaxy.merchant.Translator;

import java.util.HashMap;


/**
 * <p>Assigned Instruction class</p>
 *
 * @author Qihan.Luo
 */
public class AssignedInstr implements Instruction {
    private final String content;

    public AssignedInstr(String content) {
        this.content = content;
    }


    /**
     * <p>Convert the sentence semantic to execute assigned instruction</p>
     *
     * @param translator Translator Class
     * @return String
     */
    @Override
    public String execute(Translator translator) {
        // Split the sentence Ex: "glob is I" -> ["glob", "I"]
        String[] expressions = this.content.trim().split("\\s+is\\s+");

        String galaxySymbol = expressions[0].trim();
        String romanSymbol = expressions[1].trim();

        HashMap<String, String> assignedMap = translator.getAssignedMap();
        assignedMap.put(galaxySymbol, romanSymbol);

        return "";
    }

}
