package Day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Map<String, Integer> cubeColorAmountMap = Map.of("red", 12, "green", 13, "blue", 14);
    static List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/Day2/input");
        BufferedReader reader = Files.newBufferedReader(path);

        while (reader.ready()) {
            int currentGameId = 0;
            String line = reader.readLine();
            line = line.strip();

            Pattern prefixPattern = Pattern.compile("Game [0-9]++:");
            Matcher matcher = prefixPattern.matcher(line);
            if (matcher.find()) {
                String prefixString = matcher.group(0);
                line = line.replace(prefixString, "");

                Pattern idPattern = Pattern.compile("[0-9]++");
                matcher = idPattern.matcher(prefixString);
                if (matcher.find()) {
                    currentGameId = Integer.parseInt(matcher.group(0));
                }
            }
            String[] sets = line.split(";");
            boolean possibleGame = true;
            for (String set : sets) {
                String[] cubes = set.split(",");
                for (String cube : cubes) {
                    String[] split = cube.split(" ");
                    Integer i = cubeColorAmountMap.get(split[2]);
                    if (i < Integer.parseInt(split[1])) {
                        possibleGame = false;
                    }
                }
            }
            if (possibleGame) {
                integerList.add(currentGameId);
            }
        }
        int result = 0;
        for (Integer i : integerList) {
            result = result + i;
        }
        System.out.println(result); // to high = 4748
        reader.close();
    }
}
