import org.junit.*;

public class FLGameTest {

    FrontLastGame fLGame;
    @Before
    public void setup () {
        fLGame = new FrontLastGame();
    }

    @Test
    public void solverTest() {
        //Using 1 2 3
        Pair[][] rightAnswer = new Integer[3][3];
	rightAnswer[0][0] = new Pair('F', 1);
	rightAnswer[0][1] = new Pair('L', 2);
	rightAnswer[0][2] = new Pair('F', 3);
	Assert.assertArraysEquals(rightAnswer, frontLastGame.solver(3, new Integer[]{1, 2, 3}));
    }

    private class Pair {
        Character frontOrLast;
	Integer total;

	Pair(Character frontback, Integer sum) {
	    this.frontOrLast = frontback;
	    this.total = sum;
	}
    }
}
