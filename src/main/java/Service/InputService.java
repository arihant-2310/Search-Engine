package Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputService {
    public ArrayList<String> parseFileInput() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("src/input.txt");
        Scanner sc = new Scanner(fis);

        ArrayList<String> inputLines = new ArrayList<>();

        while (sc.hasNextLine()) {
            String inputLine = sc.nextLine();
            inputLines.add(inputLine);
        }

        return inputLines;
    }
}
