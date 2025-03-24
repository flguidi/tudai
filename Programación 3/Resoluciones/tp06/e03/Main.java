package tp06.e03;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear una lista de actividades de ejemplo
        List<Activity> activities = new ArrayList<>();

        activities.add(new Activity(
                "Actividad 1",
                "Descripción 1",
                LocalDateTime.of(2024, 12, 24, 9, 0),
                LocalDateTime.of(2024, 12, 24, 10, 0)
        ));
        activities.add(new Activity(
                "Actividad 2",
                "Descripción 2",
                LocalDateTime.of(2024, 12, 24, 10, 30),
                LocalDateTime.of(2024, 12, 24, 12, 0)
        ));
        activities.add(new Activity(
                "Actividad 3",
                "Descripción 3",
                LocalDateTime.of(2024, 12, 24, 11, 0),
                LocalDateTime.of(2024, 12, 24, 12, 30)
        ));
        activities.add(new Activity(
                "Actividad 4",
                "Descripción 4",
                LocalDateTime.of(2024, 12, 24, 13, 0),
                LocalDateTime.of(2024, 12, 24, 14, 0)
        ));
        activities.add(new Activity(
                "Actividad 5",
                "Descripción 5",
                LocalDateTime.of(2024, 12, 24, 13, 0),
                LocalDateTime.of(2024, 12, 24, 15, 0)
        ));

        // Problema de selección de actividades
        ActivitySelectionProblem problem = new ActivitySelectionProblem();
        List<Activity> selectedActivities = problem.solve(activities);

        System.out.println("Actividades seleccionadas:");
        for (Activity activity : selectedActivities) {
            System.out.println(activity.getTitle() + " desde " + activity.getStart() + " hasta " + activity.getEnd());
        }
    }

}
