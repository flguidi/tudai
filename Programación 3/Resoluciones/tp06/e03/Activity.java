package tp06.e03;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;

public class Activity {

    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;

    public Activity(String title, String description, LocalDateTime start, LocalDateTime end) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Duration getDuration() {
        return Duration.between(start, end);
    }

    // Comparador por fecha de inicio
    public static class StartDateComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return a1.getStart().compareTo(a2.getStart());
        }
    }

    // Comparador por fecha de finalización
    public static class EndDateComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return a1.getEnd().compareTo(a2.getEnd());
        }
    }

    // Comparador por duración
    public static class DurationComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return a1.getDuration().compareTo(a2.getDuration());
        }
    }

}
