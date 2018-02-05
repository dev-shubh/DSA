package lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaExamples {


    static List<Apple> apples = new ArrayList<>();


    public static void main(String[] args) {
        instantiateApples();
        apples.sort(Comparator.comparingInt(Apple::getWeight));
        printAll();
        apples.sort((Apple a1, Apple a2) -> {return a2.getWeight() - a1.getWeight();});
        printAll();
        boolean allHaveSameWeight = apples.stream().allMatch((apple) -> {return apple.getWeight() > 10000 ;});
        System.out.println("All have same weight : " + Boolean.toString(allHaveSameWeight));

        boolean anyMatch = apples.stream().anyMatch((apple) -> {return apple.getWeight() > 250 ;});
        System.out.println("any match = " + Boolean.toString(anyMatch));
        System.out.println("total = " + apples.stream().count());
        System.out.println("distinct =  " + apples.stream().distinct().count());
        System.out.println("max " + apples.stream().max(Comparator.comparingInt(Apple::getWeight)).isPresent());

    }

    private static void printAll(){
        apples.forEach( apple -> System.out.println(apple.toString()));
        System.out.println("-----------------------");
    }

    private static void instantiateApples() {
        apples.add(new Apple("green", 100));
        apples.add(new Apple("red", 200));
        apples.add(new Apple("yellow", 150));
        apples.add(new Apple("green", 300));
        apples.add(new Apple("red", 250));
        apples.add(new Apple("green", 100));
        apples.add(new Apple("red", 250));
        apples.add(new Apple("green", 150));
        apples.add(new Apple("red", 50));
        apples.add(apples.get(0));
        apples.add(apples.get(2));
        apples.add(apples.get(3));
        apples.add(apples.get(4));
        apples.add(apples.get(0));
        apples.add(apples.get(0));
    }

}
