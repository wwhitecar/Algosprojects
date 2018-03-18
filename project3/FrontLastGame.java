/**
 * Will figure out the optimal way to score
 * as many points as possible based on the game
 * that is currently faced by the player
 * @author William Trevor Whitecar
 * @date 3/15/2018
 */

import java.util.Scanner;

public class FrontLastGame {

    private static Tuple[][] answer;
 
    public static void main(String[] args) {

        Integer[] values = getListForGame();
        int numberOfValues = (values.length);

	    answer = new Tuple[numberOfValues][numberOfValues];
        numberOfValues--;

	    //display what the user just input
	    String s = ("\r\nPlaying game with " + (numberOfValues + 1) + " numbers\r\n");
	    for(Integer number: values) {
	        s += (number + ", ");
	    }
	    System.out.println(s);
	    answer[0][numberOfValues] = solver(values, 0, numberOfValues);
	    displayChart();
    }

    private static Integer[] getListForGame() {
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
        return values;
    }

    private static void displayChart() {
        String result = "";
        for(int i = 0; i < answer.length; i++) {
            for(int j = 0; j < answer.length; j++) {
                if(answer[i][j] == null){
                    result += "-----" + " ";
                }
                else {
                    result += answer[i][j].toString() + " ";
                }
            }
            result += "\r\n";
        }
        System.out.println(result);
    }

    public static Tuple solver(Integer[] values, int front, int back) {
        if(values == null || values.length == 0){
            return answer[front][back];
        }
        if (values.length == 1) {
            answer[front][back] = new Tuple('F', values[0]);
            return answer[front][back];
        }
        else {
            if (answer[front + 1][back] == null) {
                answer[front + 1][back] = solver(removeFront(values), front + 1, back );
            }
            if (answer[front][back - 1] == null) {
                answer[front][back - 1] = solver(removeBack(values), front, back - 1);
            }
        }

        if(answer[front + 1][back - 1] == null) {
            if(answer[front + 1][back].getTotal() > answer[front][back-1].getTotal()){
                answer[front][back] = new Tuple('L', answer[front + 1][back].getTotal());
            }
            else {
                answer[front][back] = new Tuple('F', answer[front][back -1].getTotal());
            }
        }
        else if(answer[front + 1][back].getTotal() > answer[front][back -1].getTotal()){
            if(answer[front + 1][back - 1].getTotal() > answer[front][back - 2].getTotal()) {
                answer[front][back] = new Tuple('L',
                        answer[front][back - 2].getTotal() + values[values.length - 1]);
                //return answer[front][back];
            }
            else {
                answer[front][back] = new Tuple('L',
                        answer[front + 1][back - 1].getTotal() + values[values.length - 1]);
                //return answer[front][back];
            }
        }
        else if(answer[front][back - 1].getTotal() > answer[front + 1][back].getTotal()){
            if(answer[front + 1][back - 1].getTotal() > answer[front + 2][back].getTotal()) {
                answer[front][back] = new Tuple('F',
                        answer[front + 2][back].getTotal() + values[0]);
                //return answer[front][back];
            }
            else {
                answer[front][back] = new Tuple('F',
                        answer[front + 1][back - 1].getTotal() + values[0]);
                //return answer[front][back];
            }
        }
        else {
            if(answer[front][back -2].getTotal() > answer[front + 1][back -1].getTotal()
                    && answer[front][back -2].getTotal() < answer[front + 2][back].getTotal()
                    || answer[front][back -2].getTotal() < answer[front + 1][back -1].getTotal()
                    && answer[front][back -2].getTotal() > answer[front + 2][back].getTotal()) {
                answer[front][back] = new Tuple('F',
                        answer[front][back - 2].getTotal() + values[values.length - 1]);
            }
            else if(answer[front + 2][back].getTotal() > answer[front + 1][back -1].getTotal()
                    && answer[front + 2][back].getTotal() < answer[front][back - 2].getTotal()
                    || answer[front + 2][back].getTotal() < answer[front + 1][back -1].getTotal()
                    && answer[front + 2][back].getTotal() > answer[front][back - 2].getTotal()) {
                answer[front][back] = new Tuple('L',
                        answer[front + 2][back].getTotal() + values[0]);
            }
            else {
                answer[front][back] = new Tuple('F', answer[front + 1][back -1].getTotal() + values[0]);
            }
        }
        return answer[front][back];
    }

    private static Integer[] removeFront(Integer[] values) {
        Integer[] temp = new Integer[values.length - 1];
        for (int i = 1; i < values.length; i++) {
            temp[i - 1] = values[i];
        }
        return temp;
    }

    private static Integer[] removeBack(Integer[] values) {
        Integer[] temp = new Integer[values.length - 1];
        for (int i = 0; i < values.length - 1; i++) {
            temp[i] = values[i];
        }
        return temp;
    }
}
