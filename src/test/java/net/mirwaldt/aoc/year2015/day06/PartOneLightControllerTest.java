package net.mirwaldt.aoc.year2015.day06;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartOneLightControllerTest {
    private static Stream<Arguments> lightController() {
        return Stream.of(Arguments.of(new PartOneLightController()));
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_allOffAtStart(SwitchableLightController lightController) {
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 999));
        assertEquals(0, lightController.countLightsOn());
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_turnOnAll(SwitchableLightController lightController) {
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 999));
        assertEquals(0, lightController.countLightsOn());
        lightController.turnOn(0, 0, 999, 999);
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 0, 0, 999, 999));
        assertEquals(1000 * 1000, lightController.countLightsOn());
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_turnOffAll(SwitchableLightController lightController) {
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 999));
        assertEquals(0, lightController.countLightsOn());
        lightController.turnOn(0, 0, 999, 999);
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 0, 0, 999, 999));
        assertEquals(1000 * 1000, lightController.countLightsOn());
        lightController.turnOff(0, 0, 999, 999);
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 999));
        assertEquals(0, lightController.countLightsOn());
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_toggleAllFromOffToOn(SwitchableLightController lightController) {
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 999));
        assertEquals(0, lightController.countLightsOn());
        lightController.toggle(0, 0, 999, 999);
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 0, 0, 999, 999));
        assertEquals(1000 * 1000, lightController.countLightsOn());
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_toggleAllFromOnToOff(SwitchableLightController lightController) {
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 999));
        assertEquals(0, lightController.countLightsOn());
        lightController.turnOn(0, 0, 999, 999);
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 0, 0, 999, 999));
        assertEquals(1000 * 1000, lightController.countLightsOn());
        lightController.toggle(0, 0, 999, 999);
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 999));
        assertEquals(0, lightController.countLightsOn());
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_turnOnSomewhere(SwitchableLightController lightController) {
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 999));
        assertEquals(0, lightController.countLightsOn());
        lightController.turnOn(10, 20, 49, 29);
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 10, 20, 49, 29));
        assertEquals((50 - 10) * (30 - 20), lightController.countLightsOn());
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 19));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 30, 999, 999));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 9, 999));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 50, 0, 999, 999));
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_turnOffSomewhere(SwitchableLightController lightController) {
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 999));
        assertEquals(0, lightController.countLightsOn());
        lightController.turnOn(0, 0, 999, 999);
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 0, 0, 999, 999));
        assertEquals(1000 * 1000, lightController.countLightsOn());
        lightController.turnOff(100, 350, 199, 399);
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 100, 350, 199, 399));
        assertEquals((1000 * 1000) - (200 - 100) * (400 - 350), lightController.countLightsOn());
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 0, 0, 999, 349));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 0, 400, 999, 999));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 0, 0, 99, 999));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 200, 0, 999, 999));
    }

    @ParameterizedTest
    @MethodSource("lightController")
    void test_toggleSomewhere(SwitchableLightController lightController) {
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 999));
        assertEquals(0, lightController.countLightsOn());
        lightController.turnOn(10, 20, 39, 29);
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 10, 20, 39, 29));
        assertEquals((40 - 10) * (30 - 20), lightController.countLightsOn());
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 19));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 30, 999, 999));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 9, 999));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 40, 0, 999, 999));
        lightController.toggle(0, 10, 19, 49);
        //noinspection PointlessArithmeticExpression
        assertEquals((10 - 0) * (50 - 10) + (20 - 10) * (20 - 10) + (20 - 10) * (50 - 30) + (40 - 20) * (30 - 20),
                lightController.countLightsOn());
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 50, 999, 999));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 0, 0, 999, 9));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 40, 0, 999, 999));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 10, 20, 19, 29));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 0, 10, 9, 49));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.OFF, 10, 20, 19, 29));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 10, 10, 19, 19));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 10, 30, 19, 49));
        assertTrue(lightController.isLightState(SwitchableLightController.LightState.ON, 20, 20, 39, 29));
    }
}
