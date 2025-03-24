package tp05.e08;

public class Main {

    public static void main(String[] args) {
        PyramidProblem pp = new PyramidProblem();
        int b = 3;  // Número de celdas en la base de la pirámide
        int k = 10;    // El valor máximo que se puede usar

        System.out.println(pp.solve(b, k));
    }

}
