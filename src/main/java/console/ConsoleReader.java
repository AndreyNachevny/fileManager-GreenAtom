package console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader {

    private  Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> consoleRead(){
        String action = scanner.nextLine();
        return new ArrayList<>(List.of(action.split(" ")));
    }
}
