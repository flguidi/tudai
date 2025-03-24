package tp05.e06;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AttilaHorseProblem ahp = new AttilaHorseProblem();
        System.out.println(ahp.printBoard());

        System.out.println("Caminos posibles:");
        List<List<String>> paths = ahp.findPaths();
        for (List<String> path : paths) {
            System.out.println(path);
        }
    }

}
