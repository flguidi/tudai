package tp04.e08;

public class Task {

    private String name;
    private String description;
    private int durationInHours;

    public Task(String name, String description, int durationInHours) {
        this.name = name;
        this.description = description;
        this.durationInHours = durationInHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }

    @Override
    public String toString() {
        return name + " (" + durationInHours + "hs)";
    }

}
