package LLD.StrategyPattern;

public class Order {
    private double weight;
    private double value;
    private String destinationZone;

    public Order(double weight, double value, String destinationZone) {
        this.destinationZone = destinationZone;
        this.value = value;
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public String getDestinationZone() {
        return destinationZone;
    }
}