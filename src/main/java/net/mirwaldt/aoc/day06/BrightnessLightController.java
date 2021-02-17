package net.mirwaldt.aoc.day06;

public interface BrightnessLightController {
    void turnOn(int startX, int startY, int endX, int endY);
    void turnOff(int startX, int startY, int endX, int endY);
    void toggle(int startX, int startY, int endX, int endY);
    long countBrightness();

    long getBrightness(int x, int y);
    boolean isBright(long brightness, int startX, int startY, int endX, int endY);
}
