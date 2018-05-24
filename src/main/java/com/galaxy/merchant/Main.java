package main.java.com.galaxy.merchant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>Main class</p>
 *
 * @author Qihan.Luo
 */
public class Main {

    public static void main(String[] args) {
        List<String> conversation = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the merchant's guide for the galaxy.");
        String line;
        while (scanner.hasNextLine() && (line = scanner.nextLine()).length() > 0) {
            conversation.add(line);
        }

        Translator translator = new Translator(conversation);
        translator.ask();
    }

}
