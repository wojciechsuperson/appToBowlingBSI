import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)

public class BowlingGameTest {

    private BowlingGame g;

    void rollMany(int n, int pins, BowlingGame g) {
        for (int i = 0; i < n; i++) g.roll(pins);
    }

    @Before
    public void setUp() {
        g = new BowlingGame();
    }

    @Test
    public void roll_0expected_when21timesRoll0Pins() {
        rollMany(20, 0, g);
        assertEquals(0, g.score());
    }

    @Test
    public void roll_shouldReturn20_after20x1throws() {
        rollMany(20, 1, g);
        assertEquals(20, g.score());
    }

    @Test
    public void roll_shouldDoubleOnlyFirstThrow_afterSpare() {
        g.roll(5);
        g.roll(5);
        g.roll(3);
        g.roll(3);
        assertEquals(19, g.score());
    }

    @Test
    public void roll_shouldDoubleBothThrows_afterStrikeIn() {
        g.roll(10);
        g.roll(3);
        g.roll(4);
        assertEquals(24, g.score());
    }

    @Test
    public void roll_shouldReturn300_LuckyGameWithOnlyStrikes() {
        rollMany(12, 10, g);
        assertEquals(300, g.score());
    }

    @Test(expected = IllegalArgumentException.class)
    public void roll_shouldThrowIllegalAE_givenMinusPinValue() {
        g.roll(-1);
    }
}