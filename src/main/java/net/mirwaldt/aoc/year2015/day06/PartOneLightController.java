package net.mirwaldt.aoc.year2015.day06;

public class PartOneLightController implements SwitchableLightController {
    private final LightState[][] board = new LightState[1000][1000];

    public PartOneLightController() {
        turnOff(0, 0, 999, 999);
    }

    @Override
    public void turnOn(int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                board[x][y] = LightState.ON;
            }
        }
    }

    @Override
    public void turnOff(int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                board[x][y] = LightState.OFF;
            }
        }
    }

    @Override
    public void toggle(int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (board[x][y] == LightState.ON) {
                    board[x][y] = LightState.OFF;
                } else {
                    board[x][y] = LightState.ON;
                }
            }
        }
    }

    @Override
    public int countLightsOn() {
        int lightsOnCounter = 0;
        for (int x = 0; x <= 999; x++) {
            for (int y = 0; y <= 999; y++) {
                if (getLightState(x, y) == LightState.ON) {
                    lightsOnCounter++;
                }
            }
        }
        return lightsOnCounter;
    }

    @Override
    public LightState getLightState(int x, int y) {
        return board[x][y];
    }

    @Override
    public boolean isLightState(LightState lightState, int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                if (getLightState(x, y) != lightState) {
                    return false;
                }
            }
        }
        return true;
    }
}
