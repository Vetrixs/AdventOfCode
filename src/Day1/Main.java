package Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static List<String> validNumberList = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
    static List<String> validNumberWrittenList = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
    static List<Integer> integerList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/Day1/input");
        BufferedReader reader = Files.newBufferedReader(path);

        processInput(reader, integerList);


        AtomicInteger sum = new AtomicInteger();
        integerList.forEach(integer -> {
            sum.set(sum.get() + integer);
        });
        System.out.println(sum);
        reader.close();
    }

    private static void processInput(BufferedReader reader, List<Integer> integerList) throws IOException {
        while (reader.ready()) {
            String raw = reader.readLine();
            String kindaProcessed = raw.strip();

            boolean contains = false;
            for (String validStringNumber : validNumberWrittenList) {
                contains = kindaProcessed.contains(validStringNumber);
                if (contains) break;
            }
            if (!contains) {
                firstPart(kindaProcessed);
            } else {
                secondPart(kindaProcessed);
            }

        }
    }

    private static void secondPart(String kindaProcessed) {
        int smallesIndex = 99;
        String smalles = "";
        int biggestIndex = -99;
        String biggest = "";
        for (String validNumberWritten : validNumberWrittenList) {
            int i = kindaProcessed.indexOf(validNumberWritten);
            if (i == -1) {
                continue;
            }
            int ismall = kindaProcessed.indexOf(validNumberWritten);
            int ibig = kindaProcessed.lastIndexOf(validNumberWritten);
            if (smallesIndex > ismall) {
                smallesIndex = ismall;
                smalles = validNumberWritten;

            }
            if (biggestIndex < ibig) {
                biggestIndex = ibig;
                biggest = validNumberWritten;
            }
        }
        for (String validNumber : validNumberList) {
            if (kindaProcessed.equals("eighttwo257djtdp5two")) {
                System.out.println();
            }
            int ismall = kindaProcessed.indexOf(validNumber);
            int ibig = kindaProcessed.lastIndexOf(validNumber);
            if (ismall == -1) {
                continue;
            }
            if (smallesIndex > ismall) {
                smallesIndex = ismall;
                smalles = validNumber;
            }
            if (biggestIndex < ibig) {
                biggestIndex = ibig;
                biggest = validNumber;
            }
        }
        String stringBuilder = String.valueOf(parseStringToInt(smalles)) +
                parseStringToInt(biggest);
        integerList.add(Integer.parseInt(stringBuilder));
    }

    private static int parseStringToInt(String string) {
        return switch (string) {
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;
            case "four" -> 4;
            case "five" -> 5;
            case "six" -> 6;
            case "seven" -> 7;
            case "eight" -> 8;
            case "nine" -> 9;
            default -> Integer.parseInt(string);
        };
    }

    private static void firstPart(String line) {
        String processedLine = line.replaceAll("[a-zA-Z]", "");

        int value;
        StringBuilder stringBuilder = new StringBuilder();
        if (processedLine.length() >= 2) {
            stringBuilder.append(processedLine.charAt(0));
            stringBuilder.append(processedLine.charAt(processedLine.length() - 1));
        } else {
            stringBuilder.append(processedLine.charAt(0));
            stringBuilder.append(processedLine.charAt(0));
        }
        value = Integer.parseInt(stringBuilder.toString());
        integerList.add(value);
    }
}

