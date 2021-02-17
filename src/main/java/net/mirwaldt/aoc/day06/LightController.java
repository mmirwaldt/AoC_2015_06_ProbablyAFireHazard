package net.mirwaldt.aoc.day06;

public interface LightController {
    enum LightState {
        ON, OFF
    }
    void turnOn(int startX, int startY, int endX, int endY);
    void turnOff(int startX, int startY, int endX, int endY);
    void toggle(int startX, int startY, int endX, int endY);
    int countLightsOn();

    LightState getLightState(int x, int y);
    boolean isLightState(LightState lightState, int startX, int startY, int endX, int endY);
}
