package Day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Stack;

public class Main {

    Map<String, Integer> cubeColorAmountMap = Map.of("red", 12, "green", 13, "blue", 14);
    Stack<Integer> integerStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/Day2/input");
        BufferedReader reader = Files.newBufferedReader(path);

        while (reader.ready()) {
            String line = reader.readLine();
            line = line.strip();

            String[] split = line.split("Game [1-9]++");
            System.out.println(split.length);
        }
    }
}
