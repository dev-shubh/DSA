package javalearning.construct;

/**
 * Created by shumishra on 6/28/17.
 */
public class Test {
    public static void main(String[] args) {
        Car car1 = new Ciaz();
        Car car2 = new City();
        Tata car3 = new Indica("Red");

        System.out.println(car1.getBrandSymbol());
        System.out.println(car2.getBrandSymbol());
        System.out.println(car3.getBrandSymbol());

        System.out.println(car1.getName());
        System.out.println(car2.getName());
        System.out.println(car3.getName());

        System.out.println(car3.color);
    }
}
