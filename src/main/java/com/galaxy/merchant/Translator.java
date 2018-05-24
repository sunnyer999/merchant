package main.java.com.galaxy.merchant;

import main.java.com.galaxy.merchant.exception.TranslatorException;
import main.java.com.galaxy.merchant.instruction.Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>Translator class</p>
 *
 * @author Qihan.Luo
 */
public class Translator {
    private final List<String> input;
    private final List<String> output = new ArrayList<>();
    private final HashMap<String, Double> creditsMap;
    private final HashMap<String, String> assignedMap;
    private final SentenceManager sentenceManager;


    public Translator(List<String> input) {
        this.input = input;
        this.creditsMap = new HashMap<>();
        this.assignedMap = new HashMap<>();
        this.sentenceManager = new SentenceManager();
    }

    /**
     * <p>Ask the questions</p>
     */
    public void ask() {
        for (String sentence : this.input) {
            parseLine(sentence);
        }

        reply();
    }

    /**
     * <p>Print the conversation's result</p>
     */
    private void reply() {
        for (String answer : this.output) {
            System.out.print(answer + '\n');
        }
    }

    /**
     * <p>Parse each line of the conversation</p>
     *
     * @param sentence String
     */
    private void parseLine(String sentence) {
        try {
            Instruction instruction = this.sentenceManager.parse(sentence.trim());
            String answer = instruction.execute(this);
            if (!answer.isEmpty()) {
                this.output.add(answer);
            }
        } catch (TranslatorException e) {
            this.output.add(e.getMessage());
        }
    }

    // Getters
    public HashMap<String, Double> getCreditsMap() {
        return creditsMap;
    }

    public HashMap<String, String> getAssignedMap() {
        return assignedMap;
    }

}
