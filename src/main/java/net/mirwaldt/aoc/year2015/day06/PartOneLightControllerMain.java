package net.mirwaldt.aoc.year2015.day06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PartOneLightControllerMain {
    private static final String TURN_ON = "turn on";
    private static final String TURN_OFF = "turn off";
    private static final String TOGGLE = "toggle";

    public static void main(String[] args) throws IOException {
        final List<String> lines = Files.readAllLines(Path.of("input.txt"), StandardCharsets.US_ASCII);
        final PartOneLightController partOneLightController = new PartOneLightController();
        int lineCounter = 1;
        for (String line : lines) {
            String[] tokens = line.split(" ");
            if(line.startsWith(TURN_ON)) {
                final String[] startStrings = tokens[2].split(",");
                final String[] endStrings = tokens[4].split(",");
                final int startX = Integer.parseInt(startStrings[0]);
                final int startY = Integer.parseInt(startStrings[1]);
                final int endX = Integer.parseInt(endStrings[0]);
                final int endY = Integer.parseInt(endStrings[1]);
                partOneLightController.turnOn(startX, startY, endX, endY);
            } else if(line.startsWith(TURN_OFF)) {
                final String[] startStrings = tokens[2].split(",");
                final String[] endStrings = tokens[4].split(",");
                final int startX = Integer.parseInt(startStrings[0]);
                final int startY = Integer.parseInt(startStrings[1]);
                final int endX = Integer.parseInt(endStrings[0]);
                final int endY = Integer.parseInt(endStrings[1]);
                partOneLightController.turnOff(startX, startY, endX, endY);
            } else if(line.startsWith(TOGGLE)) {
                final String[] startStrings = tokens[1].split(",");
                final String[] endStrings = tokens[3].split(",");
                final int startX = Integer.parseInt(startStrings[0]);
                final int startY = Integer.parseInt(startStrings[1]);
                final int endX = Integer.parseInt(endStrings[0]);
                final int endY = Integer.parseInt(endStrings[1]);
                partOneLightController.toggle(startX, startY, endX, endY);
            } else {
                throw new AssertionError("Cannot handle line " + lineCounter + " with content'" + line + "'.");
            }
            lineCounter++;
        }
        System.out.println(partOneLightController.countLightsOn()); // result - 569999
    }
}
