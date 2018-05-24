package main.java.com.galaxy.merchant;

import main.java.com.galaxy.merchant.exception.TranslatorException;
import main.java.com.galaxy.merchant.instruction.*;

import java.util.HashMap;
import java.util.function.Function;

/**
 * <p>SentenceManager class.<br>
 * Create instructions for different patterns of sentences</p>
 *
 * @author Qihan.Luo
 */
class SentenceManager {
    private static final HashMap<Enum, Function<String, Instruction>> instructionFactory = new HashMap<>();

    /* Sentences patterns */
    private static final String PATTERN_ASSIGNED = "^([A-Za-z]+) is ([IVXLCDM])$";
    private static final String PATTERN_CREDITS = "^([A-Za-z]+)([A-Za-z\\s]*) is ([0-9]+) ([c|C]redits)$";
    private static final String PATTERN_HOW_MUCH = "^how much is (([A-Za-z\\s])+)\\?$";
    private static final String PATTERN_HOW_MANY = "^how many [c|C]redits is (([A-Za-z\\s])+)\\?$";

    /* Register instructions for system */
    static {
        instructionFactory.put(Type.CREDITS, CreditInstr::new);
        instructionFactory.put(Type.ASSIGNED, AssignedInstr::new);
        instructionFactory.put(Type.HOW_MUCH, HowMuchInstr::new);
        instructionFactory.put(Type.HOW_MANY, HowManyInstr::new);
    }

    enum Type {
        /* Represents the sentence is of Assignment type. Ex: glob is V */
        ASSIGNED,
        /* Represents the sentence is of Credits  type. Ex: glob glob Silver is 34 Credits */
        CREDITS,
        /* Represents the sentence is of How-Much type. Ex: how much is pish tegj glob glob ? */
        HOW_MUCH,
        /* Represents the sentence is of How-Many type. Ex: how many Credits is glob prok Iron*/
        HOW_MANY
    }

    /**
     * <p>Parse the sentence</p>
     *
     * @param sentence String
     * @return sentence pattern
     * @throws TranslatorException if not match the patterns
     */
    Instruction parse(String sentence) throws TranslatorException {
        Enum type = getType(sentence);
        return instructionFactory.get(type).apply(sentence);
    }

    /**
     * <p>Get the sentence's specific type</p>
     *
     * @param sentence String
     * @return Enum Type
     * @throws TranslatorException if not match the patterns
     */
    private Enum getType(String sentence) throws TranslatorException {
        if (sentence.matches(PATTERN_ASSIGNED)) {
            return Type.ASSIGNED;
        } else if (sentence.matches(PATTERN_CREDITS)) {
            return Type.CREDITS;
        } else if (sentence.matches(PATTERN_HOW_MUCH)) {
            return Type.HOW_MUCH;
        } else if (sentence.matches(PATTERN_HOW_MANY)) {
            return Type.HOW_MANY;
        } else {
            throw new TranslatorException("I have no idea what you are talking about");
        }
    }

}
