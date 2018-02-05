package lambdas;

public class Apple {
    private String color;
    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String toString() {
        return ("color=" + color + "\t\t\tweight=" + weight);
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }
}
