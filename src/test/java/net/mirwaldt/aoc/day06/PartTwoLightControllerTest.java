package net.mirwaldt.aoc.day06;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static net.mirwaldt.aoc.day06.SwitchableLightController.LightState.OFF;
import static net.mirwaldt.aoc.day06.SwitchableLightController.LightState.ON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartTwoLightControllerTest {
    private static Stream<Arguments> lightController() {
        return Stream.of(Arguments.of(new PartTwoLightController()));
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_allOffAtStart(BrightnessLightController lightController) {
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_turnOnAllOnce(BrightnessLightController lightController) {
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
        lightController.turnOn(0, 0, 999, 999);
        assertTrue(lightController.isBright(1, 0, 0, 999, 999));
        assertEquals(1000 * 1000, lightController.countBrightness());
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_turnOnAllTwice(BrightnessLightController lightController) {
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
        lightController.turnOn(0, 0, 999, 999);
        assertTrue(lightController.isBright(1, 0, 0, 999, 999));
        assertEquals(1000 * 1000, lightController.countBrightness());
        lightController.turnOn(0, 0, 999, 999);
        assertTrue(lightController.isBright(2, 0, 0, 999, 999));
        assertEquals(2 * 1000 * 1000, lightController.countBrightness());
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_turnOffAll(BrightnessLightController lightController) {
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
        lightController.turnOn(0, 0, 999, 999);
        assertTrue(lightController.isBright(1, 0, 0, 999, 999));
        assertEquals(1000 * 1000, lightController.countBrightness());
        lightController.turnOff(0, 0, 999, 999);
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_turnOffAllTwice(BrightnessLightController lightController) {
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
        lightController.turnOn(0, 0, 999, 999);
        assertTrue(lightController.isBright(1, 0, 0, 999, 999));
        assertEquals(1000 * 1000, lightController.countBrightness());
        lightController.turnOff(0, 0, 999, 999);
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
        lightController.turnOff(0, 0, 999, 999);
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_toggleAllOnce(BrightnessLightController lightController) {
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
        lightController.toggle(0, 0, 999, 999);
        assertTrue(lightController.isBright(2, 0, 0, 999, 999));
        assertEquals(2 * 1000 * 1000, lightController.countBrightness());
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_toggleAllTwice(BrightnessLightController lightController) {
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
        lightController.toggle(0, 0, 999, 999);
        assertTrue(lightController.isBright(2, 0, 0, 999, 999));
        assertEquals(2 * 1000 * 1000, lightController.countBrightness());
        lightController.toggle(0, 0, 999, 999);
        assertTrue(lightController.isBright(4, 0, 0, 999, 999));
        assertEquals(4 * 1000 * 1000, lightController.countBrightness());
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_turnOnSomewhere(BrightnessLightController lightController) {
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
        lightController.turnOn(10, 20, 49, 29);
        assertTrue(lightController.isBright(1, 10, 20, 49, 29));
        assertEquals((50 - 10) * (30 - 20), lightController.countBrightness());
        assertTrue(lightController.isBright(0, 0, 0, 999, 19));
        assertTrue(lightController.isBright(0, 0, 30, 999, 999));
        assertTrue(lightController.isBright(0, 0, 0, 9, 999));
        assertTrue(lightController.isBright(0, 50, 0, 999, 999));
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_turnOffSomewhere(BrightnessLightController lightController) {
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
        lightController.turnOn(0, 0, 999, 999);
        assertTrue(lightController.isBright(1, 0, 0, 999, 999));
        assertEquals(1000 * 1000, lightController.countBrightness());
        lightController.turnOff(100, 350, 199, 399);
        assertTrue(lightController.isBright(0, 100, 350, 199, 399));
        assertEquals((1000 * 1000) - (200 - 100) * (400 - 350), lightController.countBrightness());
        assertTrue(lightController.isBright(1, 0, 0, 999, 349));
        assertTrue(lightController.isBright(1, 0, 400, 999, 999));
        assertTrue(lightController.isBright(1, 0, 0, 99, 999));
        assertTrue(lightController.isBright(1, 200, 0, 999, 999));
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_toggleSomewhere(BrightnessLightController lightController) {
        assertTrue(lightController.isBright(0, 0, 0, 999, 999));
        assertEquals(0, lightController.countBrightness());
        lightController.turnOn(10, 20, 39, 29);
        assertTrue(lightController.isBright(1, 10, 20, 39, 29));
        assertEquals((40 - 10) * (30 - 20), lightController.countBrightness());
        assertTrue(lightController.isBright(0, 0, 0, 999, 19));
        assertTrue(lightController.isBright(0, 0, 30, 999, 999));
        assertTrue(lightController.isBright(0, 0, 0, 9, 999));
        assertTrue(lightController.isBright(0, 40, 0, 999, 999));
        lightController.toggle(0, 10, 19, 49);
        //noinspection PointlessArithmeticExpression
        assertEquals(2 * (10 - 0) * (50 - 10)
                        + 3 * (20 - 10) * (30 - 20)
                        + 2 * (20 - 10) * (20 - 10)
                        + 2 * (20 - 10) * (50 - 30)
                        + (40 - 20) * (30 - 20),
                lightController.countBrightness());
        assertTrue(lightController.isBright(0, 0, 50, 999, 999));
        assertTrue(lightController.isBright(0, 0, 0, 999, 9));
        assertTrue(lightController.isBright(0, 40, 0, 999, 999));
        assertTrue(lightController.isBright(2, 0, 10, 9, 49));
        assertTrue(lightController.isBright(3, 10, 20, 19, 29));
        assertTrue(lightController.isBright(2, 10, 10, 19, 19));
        assertTrue(lightController.isBright(2, 10, 30, 19, 49));
        assertTrue(lightController.isBright(1, 20, 20, 39, 29));
    }
}
