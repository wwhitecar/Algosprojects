/**
 * Build a 2D chart where row j, column k holds the optimal score a 
 * player whi is faced with Vj through Vk can achieve
 * (asuming that both players play optimally, following the chart-if one
 * player make a sub-optimkal move, then the other can move in the chart
 * to the game they now face and proceed from there).
 *
 * In Addition to storing the optimal score in each cell you must also put
 * in either F or L, telling the player which move to make when faced with
 * this game.
 * 
 * Note that some cells of htis chart will not be filled in because they do
 * not represet a vaild game situation. 
 *
 * Your main job is to figure out precisely how you can fill the cell at (j, k)
 * assuming that all the cells for sub-problems have ben filled
 *
 * A secondary job is ot figure out which cells represent bases cases, and how
 * to fill them "from scratch".
 *
 * The chart you create and siplay must includ the optimal score and something
 * indicating which choide the player face with the situation represented by a
 * cell myst take to achieve that optimal score(i.ee, either take the first or
 * last item)
 *
 * For credit you must submit all the source code for a JAva application that asks
 * the user in the console how many vaule there will be, followed by the calues in
 * order, and then fills the chart, display it on=creen, where each cell of the 
 * chart has an integer score and either F or L.
 */

import java.util.Scanner;

public class FrontLastGame { 
 
    public static void main(String[] args) {
    
	Scanner scanner = new Scanner(System.in);
	System.out.print("How many values will there be: ");
	int numberOfValues = scanner.nextInt();

	Integer[] values = new Integer[numberOfValues];
	System.out.print("Enter each value (in order of how to play) " +
			"one by one followed by enter:\r\n");
	for(int i =0; i < numberOfValues; i++) {
	    values[i] = scanner.nextInt();
	}
	scanner.close();

	//display what the user just input
	String s = ("\r\nPlaying game with " + numberOfValues + " numbers\r\n");
	for(Integer number: values) {
	    s += (number + ", ");
	}
	System.out.println(s);
	solver(numberOfValues, values);
    }

    private static Integer[][] solver(Integer numberOfValues, Integer[] values) {
         Integer[][] solution = new Integer[numberOfValues][numberOfValues];
	 return null;
    }

    private class Pair {
	Character frontOrLast;
        Integer total;
        Pair( Character frontOrBack, Integer sum) {
	    this.frontOrLast = frontOrBack;
	    this.total = sum;
	}
    }
}