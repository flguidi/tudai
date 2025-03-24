package tp05.e05;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] taskTimes = {1, 1, 3, 7, 5};
        int processorsCount = 3;

        MultiprocessorSchedulingProblem pp = new MultiprocessorSchedulingProblem();
        int[] processorsTimes = pp.assignTasks(taskTimes, processorsCount);
        System.out.println(Arrays.toString(processorsTimes));
    }

}
