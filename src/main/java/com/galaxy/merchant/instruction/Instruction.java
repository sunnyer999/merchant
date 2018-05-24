package main.java.com.galaxy.merchant.instruction;

import main.java.com.galaxy.merchant.Translator;
import main.java.com.galaxy.merchant.exception.TranslatorException;


/**
 * <p>Instruction interface</p>
 *
 * @author Qihan.Luo
 */
public interface Instruction {
    String execute(Translator translator) throws TranslatorException;
}
