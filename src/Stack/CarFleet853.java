package Stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet853 {
    public static void main(String[] args) {

    }
}

class Sol853 {
    public int fleet(int target, int[] position, int[] speed) {

        if (position.length == 1) return 1;

        Stack<Double> stack = new Stack<>();
        int[][] combine = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, java.util.Comparator.comparingInt(element -> element[0]));

        for (int i = combine.length - 1; i >= 0; i--) {
            double timeToReach = (double) (target - combine[i][0]) / combine[i][1];

            if (!stack.isEmpty() && timeToReach <= stack.peek()) {
                continue;
            } else {
                stack.push(timeToReach);
            }
        }

        return stack.size();
    }

    public int fleetOptimized(int target, int[] position, int[] speed) {

        if (position.length == 1) return 1;

        double[] stack = new double[position.length];
        int top = -1;
        int[][] combine = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, java.util.Comparator.comparingInt(element -> element[0]));

        for (int i = combine.length - 1; i >= 0; i--) {
            double timeToReach = (double) (target - combine[i][0]) / combine[i][1];

            if (top != -1 && timeToReach <= stack[top]) {
                continue;
            } else {
                stack[++top] = timeToReach;
            }
        }

        return top + 1;
    }
}
