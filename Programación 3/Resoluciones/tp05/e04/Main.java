package tp05.e04;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {3, 3, 7, 1};

        PartitionProblem pp = new PartitionProblem();
        List<List<Integer>> partitions = pp.findPartitions(numbers);

        if (!partitions.isEmpty()) {
            for (List<Integer> partition : partitions) {
                System.out.println(partition);
            }
        } else {
            System.out.println("El conjunto no se puede particionar.");
        }
    }

}
