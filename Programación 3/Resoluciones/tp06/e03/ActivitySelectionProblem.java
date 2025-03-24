package tp06.e03;

import java.util.ArrayList;
import java.util.List;

/**
 * Maximizar el número de actividades compatibles:
 * Se tienen N actividades que necesitan utilizar un recurso, tal como una sala de conferencias, en
 * exclusión mutua. Cada actividad i tiene asociado un tiempo de comienzo C(i) y un tiempo de finalización
 * F(i) de utilización del recurso, con C(i) < F(i). Si la actividad i es seleccionada, se llevará a cabo
 * durante el intervalo [C(i), F(i)). Las actividades i y j son compatibles si los intervalos [C(i), F(i))
 * y [C(j), F(j)) no se superponen (es decir, C(i) > F(j) ó C(j) > F(i)). El problema consiste en encontrar
 * la cantidad máxima de actividades compatibles entre sí.
 */
public class ActivitySelectionProblem {

    /**
     * Resuelve el problema de selección de actividades para maximizar el número de actividades compatibles.
     * Esta función utiliza un enfoque codicioso para seleccionar el mayor número de actividades que no se
     * solapan, lo que garantiza que se maximiza el uso del recurso sin que las actividades se crucen entre sí.
     * Las actividades se ordenan primero por su hora de finalización en orden ascendente. Luego, se recorre la
     * lista de actividades y selecciona aquellas que son compatibles con la actividad previamente seleccionada,
     * es decir, aquellas cuyo tiempo de inicio no se solapa con el tiempo de finalización de la actividad ya
     * seleccionada.
     *
     * @param activities Una lista de objetos {@code Activity} que representan las actividades a ser seleccionadas.
     *                   Cada actividad tiene un tiempo de inicio ({@code start}) y un tiempo de finalización
     *                   ({@code end}).
     * @return Una lista con la mayor cantidad de actividades compatibles.
     */
    public List<Activity> solve(List<Activity> activities) {
        // Conjunto solución vacío
        List<Activity> solution = new ArrayList<>();

        // Se ordenan las actividades por fecha de finalización
        activities.sort(new Activity.EndDateComparator());

        // Se selecciona la primera actividad (la que termina más temprano)
        Activity current = activities.removeFirst();
        solution.add(current);

        // Mientras haya actividades para seleccionar
        while (!activities.isEmpty()) {
            // Se elige la actividad que termine primero (para maximizar el tiempo disponible)
            Activity a = activities.removeFirst();

            // Si la actividad 'a' no se solapa con la actividad actual, se agrega a la solución
            if (areActivitiesCompatible(a, current)) {
                solution.add(a);
                current = a; // Se actualiza la actividad actual
            }
        }

        return solution;
    }

    private boolean areActivitiesCompatible(Activity a1, Activity a2) {
        return a1.getEnd().isBefore(a2.getStart()) || a2.getEnd().isBefore(a1.getStart());
    }

}
