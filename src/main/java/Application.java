import Service.InputService;
import Service.SearchEngineService;


import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        InputService inputService = new InputService();
        ArrayList<String> inputLines = inputService.parseFileInput();

        SearchEngineService searchEngineService = new SearchEngineService();
        searchEngineService.process(inputLines);
    }
}
