package net.mirwaldt.aoc.day06;

import static java.lang.Math.max;

public class PartTwoLightController implements BrightnessLightController {
    private final long[][] board = new long[1000][1000];

    @Override
    public void turnOn(int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                board[x][y]++;
            }
        }
    }

    @Override
    public void turnOff(int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                board[x][y] = max(0, board[x][y] - 1);
            }
        }
    }

    @Override
    public void toggle(int startX, int startY, int endX, int endY) {
        turnOn(startX, startY, endX, endY);
        turnOn(startX, startY, endX, endY);
    }

    @Override
    public long countBrightness() {
        long brightness = 0;
        for (int x = 0; x <= 999; x++) {
            for (int y = 0; y <= 999; y++) {
                brightness+=getBrightness(x, y);
            }
        }
        return brightness;
    }

    @Override
    public long getBrightness(int x, int y) {
        return board[x][y];
    }

    @Override
    public boolean isBright(long brightness, int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (getBrightness(x, y) != brightness) {
                    return false;
                }
            }
        }
        return true;
    }
}
