package test.java.com.galaxy.merchant;

import main.java.com.galaxy.merchant.Translator;
import main.java.com.galaxy.merchant.exception.TranslatorException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TranslatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testAssignedScenario() {
        List<String> conversation = new ArrayList<>();
        conversation.add("glob is I");
        conversation.add("prok is V");
        conversation.add("pish is X");
        conversation.add("tegj is L");
        Translator translator = new Translator(conversation);
        translator.ask();
        assertEquals("", outContent.toString());
    }

    @Test
    public void testCreditsScenario() {
        List<String> conversation = new ArrayList<>();
        conversation.add("glob is I");
        conversation.add("prok is V");
        conversation.add("pish is X");
        conversation.add("tegj is L");
        conversation.add("glob glob Silver is 34 Credits");
        conversation.add("glob glob Silver is 34 Credits");
        conversation.add("pish pish Iron is 3910 Credits");
        Translator translator = new Translator(conversation);
        translator.ask();
        assertEquals("", outContent.toString());
    }


    @Test
    public void testHowMuchScenario() throws TranslatorException {
        List<String> conversation = new ArrayList<>();
        conversation.add("glob is I");
        conversation.add("prok is V");
        conversation.add("pish is X");
        conversation.add("tegj is L");
        conversation.add("glob glob Silver is 34 Credits");
        conversation.add("glob glob Silver is 34 Credits");
        conversation.add("pish pish Iron is 3910 Credits");
        conversation.add("how much is pish tegj glob glob ?");
        Translator translator = new Translator(conversation);
        translator.ask();
        assertEquals("pish tegj glob glob is 42", outContent.toString().trim());
    }

    @Test
    public void testHowManyScenario() {
        List<String> conversation = new ArrayList<>();
        conversation.add("glob is I");
        conversation.add("prok is V");
        conversation.add("pish is X");
        conversation.add("tegj is L");
        conversation.add("glob glob Silver is 34 Credits");
        conversation.add("glob prok Gold is 57800 Credits");
        conversation.add("pish pish Iron is 3910 Credits");
        conversation.add("how many Credits is glob prok Silver ?");
        conversation.add("how many Credits is glob prok Gold ?");
        conversation.add("how many Credits is glob prok Iron ?");
        Translator translator = new Translator(conversation);
        translator.ask();
        assertEquals("glob prok Silver is 68.0 Credits\n" +
                "glob prok Gold is 57800.0 Credits\n" +
                "glob prok Iron is 782.0 Credits", outContent.toString().trim());
    }

    @Test
    public void testNoMatch() {
        List<String> conversation = new ArrayList<>();
        conversation.add("glob glob Silver is 34 Creditsss");
        conversation.add("glob prok Gold is a57800 Creditsaaa");
        conversation.add("pish pish Iron is 3910 Credits1");
        conversation.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
        conversation.add("how sfasdf ?");
        Translator translator = new Translator(conversation);
        translator.ask();
        assertEquals("I have no idea what you are talking about\n" +
                "I have no idea what you are talking about\n" +
                "I have no idea what you are talking about\n" +
                "I have no idea what you are talking about\n" +
                "I have no idea what you are talking about", outContent.toString().trim());
    }


    @Test
    public void testGalaxySymbolToRomanNumber() {
        List<String> conversation = new ArrayList<>();
        conversation.add("glob is I");
        conversation.add("prok is V");
        conversation.add("pish is X");
        conversation.add("tegj is L");
        conversation.add("glob glob glob glob Silver is 34 Credits");
        conversation.add("pish pish pish pish Silver is 34 Credits");
        conversation.add("glob tegj Silver is 34 Credits");
        Translator translator = new Translator(conversation);
        translator.ask();
        assertEquals("Invalid roman number: IIII\n" +
                "Invalid roman number: XXXX\n" +
                "Invalid roman number: IL", outContent.toString().trim());
    }

    @Test
    public void testInvalidAssigned() {
        List<String> conversation = new ArrayList<>();
        conversation.add("glob is XL");
        conversation.add("prok is O");
        conversation.add("pish is PAL");
        conversation.add("tegj is XXX");
        Translator translator = new Translator(conversation);
        translator.ask();
        assertEquals("I have no idea what you are talking about\n" +
                "I have no idea what you are talking about\n" +
                "I have no idea what you are talking about\n" +
                "I have no idea what you are talking about", outContent.toString().trim());
    }

    @Test
    public void testInvalidGalaxySymbol() {
        List<String> conversation = new ArrayList<>();
        conversation.add("glob is I");
        conversation.add("prok is V");
        conversation.add("pish is X");
        conversation.add("tegj is L");
        conversation.add("glob glob xxxx Silver is 34 Credits");
        conversation.add("X y Silver is 34 Credits");
        Translator translator = new Translator(conversation);
        translator.ask();
        assertEquals("Sorry! Cannot find corresponding galaxy Symbol: xxxx\n" +
                "Sorry! Cannot find corresponding galaxy Symbol: X", outContent.toString().trim());
    }

    @Test
    public void testInvalidGalaxyMaterialCredits() {
        List<String> conversation = new ArrayList<>();
        conversation.add("glob is I");
        conversation.add("prok is V");
        conversation.add("pish is X");
        conversation.add("tegj is L");
        conversation.add("glob glob Silver is 34 Credits");
        conversation.add("glob glob Silver is 34 Credits");
        conversation.add("pish pish Iron is 3910 Credits");
        conversation.add("how many Credits is glob prok XXX ?");
        conversation.add("how many Credits is glob prok YYY ?");
        Translator translator = new Translator(conversation);
        translator.ask();
        assertEquals("Sorry! Cannot find XXX's unit credits\n" +
                "Sorry! Cannot find YYY's unit credits", outContent.toString().trim());
    }


    @Test
    public void testInvalidNumFormatCredits() {
        List<String> conversation = new ArrayList<>();
        conversation.add("glob is I");
        conversation.add("prok is V");
        conversation.add("pish is X");
        conversation.add("glob prok Silver is 0.0 Credits");
        conversation.add("glob pish Silver is YYY Credits");
        Translator translator = new Translator(conversation);
        translator.ask();
        assertEquals("I have no idea what you are talking about\n" +
                "I have no idea what you are talking about", outContent.toString().trim());
    }

}
