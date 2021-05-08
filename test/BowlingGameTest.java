import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BowlingGameTest {
    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void testGutterGame() throws  Exception{
        rolMany(20, 0);
        Assert.assertEquals(0, bowlingGame.score());
    }
    @Test
    public void testAllOnes() throws  Exception{
        rolMany(20, 1);
        Assert.assertEquals(20, bowlingGame.score());
    }
    @Test
    public void testOneSpare() throws  Exception{
        rolSpare();
        bowlingGame.roll(3);
        rolMany(17, 0);
        Assert.assertEquals(16, bowlingGame.score());
    }
    @Test
    public void testOneStrike() throws  Exception{
        rolStrike();
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        rolMany(16, 0);
        Assert.assertEquals(24, bowlingGame.score());
    }
    @Test
    public void testPerfectGame() throws  Exception{
        rolMany(12, 10);
        Assert.assertEquals(300, bowlingGame.score());
    }


    public void rolMany(int n, int pins){
        for(int i = 0; i < n; i++){
            bowlingGame.roll(pins);
        }
    }

    public void rolSpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }

    public void rolStrike() {
        bowlingGame.roll(10);
    }
}
