package tp06.e02;

import java.util.Comparator;

public class Element {

    private final String name;
    private final double weight;
    private final double value;
    private double fraction;

    public Element(String name, double weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.fraction = 1;
    }

    public Element(String name, double weight, double value, double fraction) {
        this(name, weight, value);
        if (fraction >= 0 && fraction <= 1) {
            this.fraction = fraction;
        } else {
            this.fraction = 1;
        }
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }

    public double getFraction() {
        return fraction;
    }

    public void setFraction(double fraction) {
        if (fraction >= 0 && fraction <= 1) {
            this.fraction = fraction;
        }
    }

    public double getValuePerWeight() {
        return value / weight;
    }

    @Override
    public String toString() {
        return name + ":\tX=" + String.format("%.1f", fraction) + " | P=" + String.format("%.1f", weight) +
                " | V=" + String.format("%.1f", value) + " | V/P=" + String.format("%.1f", getValuePerWeight());
    }

    // Comparadores
    public static class ValueComparator implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2) {
            return Double.compare(e1.getValue(), e2.getValue());
        }
    }

    public static class WeightComparator implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2) {
            return Double.compare(e1.getWeight(), e2.getWeight());
        }
    }

    public static class ValuePerWeightComparator implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2) {
            return Double.compare(e1.getValuePerWeight(), e2.getValuePerWeight());
        }
    }

}
